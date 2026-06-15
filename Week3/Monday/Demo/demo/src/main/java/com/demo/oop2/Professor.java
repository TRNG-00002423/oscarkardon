package com.demo.oop2;

public class Professor extends Person{
    double salary;

    public Professor() {}


    public Professor(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void introduce(){
        System.out.println("Hello I a am a professor");
    }
    
    
}
