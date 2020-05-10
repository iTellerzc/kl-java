package com.iteller.kl.zk.lock.mutex.template;

import com.iteller.kl.zk.lock.mutex.ZKLock;
import org.apache.flink.shaded.curator.org.apache.curator.framework.CuratorFramework;

/**
 * @author iTeller_zc
 * date:2020/5/10
 * description:
 */
public abstract class AbstractZKLockMutex implements ZKLock {


    protected String lockPath;


    protected CuratorFramework zkClient;

    private AbstractZKLockMutex(){

    }

    public AbstractZKLockMutex(String lockPath, CuratorFramework zkClient){
        this.lockPath = lockPath;
        this.zkClient = zkClient;
    }


    @Override
    public void lock() throws Exception {

        if(tryLock()){
            System.out.println(Thread.currentThread().getName() + "获取锁成功！");

        }else {

            //阻塞等待
            waitLock();

            //递归 再次获取锁
            lock();
        }

    }


    /**
     * 等待获取锁
     * @throws Exception
     */
    protected abstract void waitLock() throws Exception;


    /**
     * 尝试获取锁
     * @return
     */
    protected abstract boolean tryLock();


    @Override
    public abstract void unlock() throws Exception;
}
