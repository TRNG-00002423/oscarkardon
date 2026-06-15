package com.demo.oop2;

public class Student extends Person implements LoginAble{
    double cgpa;

    public Student() {}

    public Student(String name, int age, double cgpa) {
        super(name, age);
        this.cgpa = cgpa;
    }

    void enrollCourse(String courseName){
        System.out.println(courseName);
    }

    void enrollCourse(String courseName, int semester){
        System.out.println(courseName + "  " + semester);
    }

    @Override
    public void introduce(){
        System.out.println("Hello I a am a student");
    }

    public void login(){
        System.out.println("Logged in");
    }
    
}
