package com.btz.web.examination.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.baron.framework.core.ssh.entity.IdEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 2017/4/5.
 */
@Entity
@Table(name = "btz_course_classification", schema = "")
public class CourseClassificationEntity implements Serializable {
    private Integer id;
    private String courseName;
    private Integer displayOrder;
    private Integer state;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id",nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name ="courseName",nullable=false)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name ="displayOrder",nullable=true)
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Column(name ="state",nullable=false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name ="createTime",nullable=false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name ="updateTime",nullable=false)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
