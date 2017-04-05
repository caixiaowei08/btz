package org.baron.framework.component.vo;

import java.io.Serializable;

/**
 * Created by User on 2017/4/5.
 */
public class AjaxRequestJQueryDt implements Serializable {
    private Integer draw = 1;
    private Integer start = 0;
    private Integer length = 10;

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
