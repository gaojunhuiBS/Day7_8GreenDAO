package com.gaojunhui.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STUDENT".
 */
public class student {

    private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String sex;
    private Integer age;

    public student() {
    }

    public student(Long id) {
        this.id = id;
    }

    public student(Long id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getSex() {
        return sex;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
