package com.rev.collect;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Double> scores = new HashMap<>();
        scores.put("John", 90.2);
        scores.put("Audy", 91.2);
        scores.put("Oscar", 100.0);
        scores.put("John", 84.3);
        scores.put("Thomas", 95.6);
        System.out.println(scores);

        for(Map.Entry<String, Double> entry: scores.entrySet()){
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }
    }
}
