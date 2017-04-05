package org.baron.framework.component.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/4/5.
 */
public class AjaxResponseJQueryDt implements Serializable {
    private Integer draw = 1;
    /**
     * 数据库里总共记录数
     */
    private Integer recordsTotal = 100;
    /**
     * 过滤后的记录数
     */
    private Integer recordsFiltered = 100;
    /**
     * 表中中需要显示的数据
     */
    private List data = new ArrayList();
    /**
     * 你可以定义一个错误来描述服务器出了问题后的友好提示
     */
    private String error;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
