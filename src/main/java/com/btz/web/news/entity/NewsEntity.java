package com.btz.web.news.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by User on 2017/5/19.
 */
@Entity
@Table(name = "btz_app_ad_carousel")
public class NewsEntity implements Serializable {
    private Integer id;
    private String img;
    private String url;
    private Integer sfyn;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="ID",nullable=false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name ="img",nullable=false)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @Column(name ="url",nullable=false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @Column(name ="sfyn",nullable=false)
    public Integer getSfyn() {
        return sfyn;
    }

    public void setSfyn(Integer sfyn) {
        this.sfyn = sfyn;
    }
    @Column(name ="createTime",nullable=true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name ="updateTime",nullable=true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
