package com.kl.zk.lock.mutex;

/**
 * @author iTeller_zc
 * date:2020/5/10
 * description:
 */
public interface ZKLock {

    void lock() throws Exception;

    void unlock() throws Exception;

}


