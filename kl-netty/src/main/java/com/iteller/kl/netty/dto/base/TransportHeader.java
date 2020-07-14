package com.iteller.kl.netty.dto.base;

import com.iteller.kl.netty.consts.TransportDirections;
import com.iteller.kl.netty.consts.TransportMagic;
import com.iteller.kl.netty.consts.TransportVersions;

import java.io.Serializable;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/7/7 19:30
 * description:
 */
public class NettyBaseHeader implements Serializable{

    private static final long serialVersionUID = -8168470075689055453L;

    private byte magic = TransportMagic.MAGIC;

    /**
     * @see com.iteller.kl.netty.consts.TransportDirections
     */
    private byte type = TransportDirections.INPUT;

    /**
     * @see TransportVersions
     */
    private byte version = TransportVersions.FIRST;

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public NettyBaseHeader(){

    }

    public NettyBaseHeader(byte magic, byte type, byte version) {
        this.magic = magic;
        this.type = type;
        this.version = version;
    }
}
