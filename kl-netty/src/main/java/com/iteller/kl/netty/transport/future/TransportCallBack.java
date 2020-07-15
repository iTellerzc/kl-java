package com.iteller.kl.netty.transport.future;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/15 9:31
 * description:
 */
public interface TransportCallBack {

    void onSuccess(Object obj);

    void onError(Throwable cause);
}
