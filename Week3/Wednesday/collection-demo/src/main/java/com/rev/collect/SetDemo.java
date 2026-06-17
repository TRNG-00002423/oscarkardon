package com.rev.collect;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> mySet = new TreeSet<>();
        mySet.add("Oscar");
        mySet.add("Cody");
        mySet.add("Natalie");
        mySet.add("Oscar");
        mySet.add("Dwight");

        System.out.println(mySet);

    }
}
