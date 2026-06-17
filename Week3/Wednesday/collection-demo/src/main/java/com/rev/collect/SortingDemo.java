package com.rev.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kaitlyn");
        names.add("Anuha");
        names.add("Utsav");
        names.add("Benson");
        names.add("Eugene");
        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);
        System.out.println(names.reversed());


    }
}
