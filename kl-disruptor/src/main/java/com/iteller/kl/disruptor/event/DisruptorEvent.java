package com.iteller.kl.disruptor.event;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/4/3 15:45
 * description:事件定义
 */
public class DisruptorEvent implements Serializable {
    private static final long serialVersionUID = 6966667713418297877L;

    private String msg;

    public DisruptorEvent(){

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DisruptorEvent{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
