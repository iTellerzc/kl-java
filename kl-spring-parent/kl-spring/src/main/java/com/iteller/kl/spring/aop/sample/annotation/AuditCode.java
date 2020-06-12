package com.iteller.kl.spring.aop.sample.annotation;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/5/13 17:13
 * description:
 */
public enum  AuditCode {

    R("r", "读"),
    W("w", "写"),
    RW("rw", "读写");

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private AuditCode(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
