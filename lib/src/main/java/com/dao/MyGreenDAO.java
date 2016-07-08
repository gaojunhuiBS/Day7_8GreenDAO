package com.dao;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyGreenDAO {
    public static void main(String[] args){
        //创建数据库的模板
        Schema schema=new Schema(1,"com.gaojunhui.dao");
        //在数据库中添加一个类
        Entity student=schema.addEntity("student");
        //添加主键id
        student.addIdProperty();
        student.addStringProperty("name").notNull();
        student.addStringProperty("sex").notNull();
        student.addIntProperty("age");
        try {
            //生成数据操作类的路径
            new DaoGenerator().generateAll(schema,"D:\\StutioProjects\\Day7_8GreenDAO\\app\\src\\main\\java-gen");
        } catch (Exception e) {
            System.out.println("运行错误");
            e.printStackTrace();
        }
        System.out.println("运行完成");
    }
}
