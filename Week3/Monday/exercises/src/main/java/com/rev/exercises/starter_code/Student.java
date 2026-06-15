package com.rev.exercises.starter_code;

import java.util.Objects;

/**
 * Lab 2 — Student. Replace UnsupportedOperationException bodies with real logic.
 * See ../README.md
 */
public class Student {
    private final int id;
    private String name;
    private String program;
    private static int nextId = 0;

    public Student(String name, String program) {
        this.id = nextId;
        this.name = name;
        this.program = program;
        nextId++;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public static int getEnrollmentCount() {
        return nextId;
    }

    @Override
    public String toString() {
        return "Student [" + id + "]: " + name + " is in " + program;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        Student other = (Student) o;
        return id == other.getId();
    }    

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}