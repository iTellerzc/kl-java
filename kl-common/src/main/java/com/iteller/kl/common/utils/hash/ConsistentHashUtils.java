package com.iteller.kl.common.utils.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/14 15:46
 * description:
 */
public class ConsistentHashUtils {
    private static final String JOIN = "--"; //分隔符

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private SortedMap<Long, String> sortedMap = new TreeMap<Long, String>();
    /**
     * 一致性虚拟节点数
     */
    private int virtualNodeNumber = 10000;

    /**
     * 初始化
     *
     * @param initNode
     */
    public void init(List<String> initNode) {
        createVirtualNode(initNode);
    }

    /**
     * 获取key对应的value
     */
    public String getNode(String keyName) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();
        try {
            // 根据key获取离他顺时针最近的虚拟节点
            String vip = getVirtualNode(keyName, sortedMap);
            // 拆分，获取真正的节点，返回
            if (!(vip == null || vip.length() == 0) && vip.contains(JOIN)) {
                return vip.split(JOIN)[0];
            } else {
                return null;
            }
        } finally {
            readLock.unlock();
        }
    }

    private String getVirtualNode(String keyName, SortedMap<Long, String> serverSortedMap) {
        // 得到待路由的结点的Hash值
        long hash = getHash(keyName);
        // 得到大于该Hash值的所有Map
        SortedMap<Long, String> subMap = serverSortedMap.tailMap(hash);
        // 第一个Key就是顺时针过去离node最近的那个结点
        if (subMap.size() == 0) {
            return serverSortedMap.get(serverSortedMap.firstKey());
        }
        Long i = subMap.firstKey();
        return subMap.get(i);
    }

    /**
     * 创建虚拟节点
     *
     * @param nodes
     */
    private void createVirtualNode(List<String> nodes) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            SortedMap<Long, String> virtualNodeMap = new TreeMap<>();
            int nodeNumber = virtualNodeNumber;
            for (int i = 0; i < nodes.size(); i++) {
                for (int j = 0; j < nodeNumber; j++) {//虚拟节点数
                    String vnName = nodes.get(i) + JOIN + "VN" + j;
                    long hash = getHash(vnName);
                    virtualNodeMap.put(hash, vnName);
                }
            }
            this.sortedMap = virtualNodeMap;
        } finally {
            writeLock.unlock();
        }
    }
    /*=====================================下面都是计算hash，计算md5相关的内容====================================*/

    /**
     * 获取Hash值
     *
     * @param key 字符串入参
     * @return long型Hash值
     */
    private long getHash(String key) {
        byte[] digest = computeMd5(key);
        if (digest != null) {
            return hash(digest, 0);
        } else {
            throw new NullPointerException("digest is null");
        }
    }

    private long hash(byte[] digest, int nTime) {
        long rv = ((long) (digest[3 + nTime * 4] & 0xFF) << 24)
                | ((long) (digest[2 + nTime * 4] & 0xFF) << 16)
                | ((long) (digest[1 + nTime * 4] & 0xFF) << 8)
                | (digest[nTime * 4] & 0xFF);

        return rv & 0xffffffffL;
    }

    private byte[] computeMd5(String k) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("md5 not supported", e);
        }
        md5.reset();
        byte[] keyBytes;
        keyBytes = k.getBytes(StandardCharsets.UTF_8);
        md5.update(keyBytes);
        return md5.digest();
    }
}
