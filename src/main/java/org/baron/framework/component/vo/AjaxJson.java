package org.baron.framework.component.vo;

import javassist.scopedpool.SoftValueHashMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 2017/4/5.
 */
public class AjaxJson implements Serializable{

    public static final int CODE_SUCCESS = 0;

    public static final int CODE_FAIL = -1;

    public static final String MSG_SUCCESS = "操作成功";

    public static final String MSG_FAIL = "操作失败";

    private int success = CODE_SUCCESS;

    private String msg = MSG_SUCCESS;

    private Object content = "";// 其他信息

    private Map<String, Object> attributes = new HashMap<String, Object>();

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
