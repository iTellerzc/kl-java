package com.iteller.kl.netty.dto.base;

import com.iteller.kl.netty.consts.TransportDirections;
import com.iteller.kl.netty.consts.TransportVersions;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:30
 * description:
 */
public class NettyBaseHeader implements Serializable{

    private static final long serialVersionUID = -8168470075689055453L;

    /**
     * @see com.iteller.kl.netty.consts.TransportDirections
     */
    private int type = TransportDirections.INPUT;

    /**
     * @see TransportVersions
     */
    private String version = TransportVersions.FIRST;

    public NettyBaseHeader(){

    }

    public NettyBaseHeader(int type){
        this.version = TransportVersions.FIRST;
        this.type = type;
    }

    public NettyBaseHeader(int type, String version){
        this.version = version;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
