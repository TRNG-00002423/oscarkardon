package com.rev.collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Oscar");
        arrayList.add("Apple");
        arrayList.add(1, "Frisbee");
        arrayList.add("Milk");
        String getOscar = arrayList.get(0);
        arrayList.set(1, "Pizza");
        arrayList.remove(2);
        int index = arrayList.indexOf("Milk");
        List<String> subList = arrayList.subList(1, 2);
        System.out.println(arrayList.size());
        System.out.println(arrayList.contains("Oscar"));
        System.out.println(arrayList.containsAll(List.of("Oscar", "Milk")));
        arrayList.addAll(subList);
        for(String element : arrayList){
            System.out.print(element + ", ");
        }





        List<String> linkedList = new LinkedList<>();
        linkedList.add("Oscar");
        linkedList.add("Apple");
        linkedList.addFirst("Frisbee");
        linkedList.addLast("hdfj");
    }
}
