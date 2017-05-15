package com.btz.web.constant;

/**
 * Created by User on 2017/5/15.
 */
public enum Role {

    ADMIN(1,"管理员"),PENMAN(2,"录入员");

    private String desc;
    private int code;

    private Role(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
