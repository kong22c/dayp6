package com.example.dayp6.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String pass;
    private String sex;
    private String classname;
    private String age;
    @Generated(hash = 1582731491)
    public User(Long id, String name, String pass, String sex, String classname,
            String age) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.classname = classname;
        this.age = age;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return this.pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getClassname() {
        return this.classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    
}
