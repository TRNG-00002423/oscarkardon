package com.demo.oops;

public class StudentManager {
    public static void main(String[] args) {
        // Student s1 = new Student();
        // s1.name = "Oscar";
        // s1.age = 22;
        // s1.cgpa = 5.0;
        // Student s2 = new Student();
        // s1.name = "Saul";
        // s1.age = 20;
        // s1.cgpa = 4.2;
        // System.out.println(Student.counter);
        // System.out.println(Student.university);
        // System.out.println(s1.university);
        // System.out.println(Student.counter);
        // s2.setCgpa(3.5);
        // System.out.println(s2.getClass());
        // System.out.println(s2);
        Student s1 = new Student("Oscar", 22, 5.0);
        Student s2 = new Student("Oscar", 22, 5.0);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
