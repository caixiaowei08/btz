package org.baron.framework.component.vo;

import java.io.Serializable;

/**
 * Created by User on 2017/4/5.
 */
public class AjaxJson implements Serializable{

    public static final Integer CODE_SUCCESS = 0;

    public static final Integer CODE_FAIL = 1;

    public static final String MSG_SUCCESS = "成功";

    public static final String MSG_FAIL = "失败";


    private Integer code = CODE_SUCCESS;

    private String msg = MSG_SUCCESS ;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
