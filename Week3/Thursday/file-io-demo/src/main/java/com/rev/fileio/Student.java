package com.rev.fileio;

import java.io.Serializable;

public class Student implements Serializable{
    private int id;
    private String name;
    private transient int age;
    private static final long serialVersionID =  1L;

    public Student(){}
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
   

    
}
