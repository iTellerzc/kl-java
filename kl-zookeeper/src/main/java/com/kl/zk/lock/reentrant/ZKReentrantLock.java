package com.kl.zk.lock.reentrant;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author iTeller_zc
 * date:2020/5/10
 * description:
 */
public class ZKReentrantLock{

    private final ConcurrentHashMap<Thread, Object> threadData = new ConcurrentHashMap<Thread, Object>();


}
