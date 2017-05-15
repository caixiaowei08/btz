package com.btz.web.constant;

/**
 * Created by User on 2017/5/15.
 */
public enum State {

    VALID(1,"有效"),INVALID(2,"无效");

    private String desc;
    private int code;

    private State(int code,String desc) {
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
