package com.demo.arrays;

public class ArraysDemo {
    public static void main(String args[]){
        int myArray [] = new int[5];
        String [] courses = {
            "Java", "Databases", "Operating Systems"
        };
        for(int i = 0; i < courses.length; i++){
            System.out.println(courses[i]);
        }
        for(String course: courses){
            System.out.println(course);
        }

    }
}
