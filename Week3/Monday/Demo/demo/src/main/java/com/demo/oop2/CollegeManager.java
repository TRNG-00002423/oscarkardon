package com.demo.oop2;

public class CollegeManager {
    public static void main(String[] args) {
        Student student = new Student();
        Professor professor = new Professor();

        Student [] students = new Student[5];
        students[0]  = new Student();
        students[1]  = new Student();
        students[2]  = new Student();
        students[3]  = new Student();

        // Student s =  new Student();
        // Person p = s;

        Person p = new Student();
        Student s = (Student) p;

    }
}
