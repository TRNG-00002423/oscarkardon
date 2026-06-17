package com.rev.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    public static void main(String[] args) {
        Student s1 = new Student(0, "Oscar");
        Student s2 = new Student(1, "Andrew");
        Student s3 = new Student(2, "Jasdhir");
        Student s4 = new Student(3, "Benson");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println(students);

        Collections.sort(students);
        System.out.println(students);
        System.out.println("Sort by Name");
        students.sort(new StudentNameComparator());
        System.out.println(students);



    }
}
