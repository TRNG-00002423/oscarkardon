package com.demo.oops;

import java.util.Objects;

public class Student {
    String name;
    int age;
    double cgpa;


    static String university = "ABC College";
    static int counter = 0;

    public Student(){}



    public Student(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        counter++;
    }
    



    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", cgpa=" + cgpa + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Student other = (Student) obj;
        return age == other.age && name.equals(other.name) && Double.compare(cgpa, other.cgpa) == 0;
    }

    public void enroll(String courseName){
        System.out.println("Enrolled in: " + courseName);

    } 


    @Override
    public int hashCode() {
        return Objects.hash(name, age, cgpa);
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public double getCgpa() {
        return cgpa;
    }



    public void setCgpa(double cgpa) {
        if (cgpa >= 0 && cgpa <= 5.0){
            this.cgpa = cgpa;
        }
    }

}
