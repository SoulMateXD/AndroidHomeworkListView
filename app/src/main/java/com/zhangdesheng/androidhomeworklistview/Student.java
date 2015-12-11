package com.zhangdesheng.androidhomeworklistview;

import android.view.View;

/**
 * Created by Administrator on 2015/12/10.
 */
public class Student  {
    private String name;
    private int grade;
    private int age;

    protected Student(String name, int grade, int age){     /*Student的构造函数，用于存输入的三个变量*/
        this.name = name;
        this.grade = grade;
        this.age = age;

    }

    public String getName (){      /*这种get+information的方法看起来更直观，并且可以直接通过对象调用方法来获得值*/
        return name;
    }

    public int getGrade(){
        return grade;
    }

    public int getAge(){
        return age;
    }
}
