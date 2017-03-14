package org.btz.test.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by User on 2017/3/12.
 */
@Entity
@Table(name = "AjaxTest", schema = "")
@SuppressWarnings("serial")
public class AjaxEntity implements Serializable{
    private String id;
    private  String name ;
    private int age;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name ="NAME",nullable=true,length=50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name ="AGE",nullable=false,length=20)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
