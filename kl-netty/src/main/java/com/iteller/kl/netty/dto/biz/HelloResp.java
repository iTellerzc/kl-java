package com.iteller.kl.netty.dto.biz;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 20:09
 * description:
 */
public class HelloResp implements Serializable {
    private static final long serialVersionUID = 3683684506056739580L;

    private String respMsg;

    public HelloResp(String respMsg){
        this.respMsg = respMsg;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
