package com.iteller.kl.zk.lock.mutex.template;

import org.apache.flink.shaded.curator.org.apache.curator.framework.CuratorFramework;
import org.apache.flink.shaded.curator.org.apache.curator.framework.listen.ListenerContainer;
import org.apache.flink.shaded.curator.org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.flink.shaded.curator.org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.flink.shaded.zookeeper.org.apache.zookeeper.CreateMode;
import org.apache.flink.shaded.zookeeper.org.apache.zookeeper.ZooDefs;
import org.apache.flink.shaded.zookeeper.org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @author iTeller_zc
 * date:2020/5/10
 * description:互斥锁
 */
public class ZKLockMutex extends AbstractZKLockMutex {

    private CountDownLatch countDownLatch;

    public ZKLockMutex(String lockPath, CuratorFramework zkClient) {
        super(lockPath, zkClient);
    }


    @Override
    protected void waitLock() throws Exception {
        //监听节点的新增 变更 删除
        final NodeCache nodeCache = new NodeCache(zkClient, lockPath);
        //启动监听
        nodeCache.start();

        ListenerContainer<NodeCacheListener> listenable = nodeCache.getListenable();

        //监听器
        NodeCacheListener listener = () -> {
            //节点被删除，获取锁
            if(nodeCache.getCurrentData() == null){
                //节点存在，此时监听到节点已删除
                if(countDownLatch != null){
                  countDownLatch.countDown();
              }
          }
        };

        listenable.addListener(listener);

        //判断节点是否存在
        Stat stat = zkClient.checkExists().forPath(lockPath);

        if(stat != null){
            countDownLatch = new CountDownLatch(1);
            //阻塞主线程
            countDownLatch.await();
        }

        //移除监听器
        listenable.removeListener(listener);
    }

    @Override
    protected boolean tryLock() {
        try{
            zkClient.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                    .forPath(lockPath, "lock".getBytes());
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public void unlock() throws Exception {
        zkClient.delete().forPath(lockPath);
    }
}
