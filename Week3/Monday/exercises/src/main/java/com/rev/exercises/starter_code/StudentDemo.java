package com.rev.exercises.starter_code;

/** Lab 2 driver — run after Student is implemented. */
public class StudentDemo {
    public static void main(String[] args) {
        // TODO: create 3 Student instances, print enrollment count,
        // demonstrate equals vs == with two references to same id scenario if possible

        Student s1 = new Student("Oscar", "Java");
        Student s2 = new Student("Racso", "Python");
        Student s3 = new Student("Jack", "SQL");
        System.out.println("Enrollment: " + Student.getEnrollmentCount());

        Student s4 = s1;

        System.out.println("s1 == s4: " + (s1 == s4));             
        System.out.println("s1.equals(s4): " + s1.equals(s4));

        Student s5 = new Student("Oscar", "Java");

        System.out.println("s1 == s5: " + (s1 == s5));           
        System.out.println("s1.equals(s5): " + s1.equals(s5));  

    }
}