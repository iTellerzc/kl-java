package com.iteller.kl.netty.dto.biz;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 20:07
 * description:
 */
public class HelloReq implements Serializable{

    private static final long serialVersionUID = -7414402120578687080L;

    private String msg;

    public HelloReq(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
