package com.rev.partner_a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Partner A — word counts + sorted unique words.
 * See ../../README.md
 */
public class WordFrequencyApp {

    private static final Logger logger = LoggerFactory.getLogger("pair.a.words");


    public static void main(String[] args) {
        Map<String, Integer> counts = new HashMap<>();

        String paragraph = "Hello, my name is Oscar. I am 22 and recently graduated from Elon University. I am doing training at Revature.";
        if(paragraph.isBlank()){
            logger.warn("Paragraph is blank");
        }
        String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");
        logger.info("Paragraph split into words");

        // for (String word: words){
        //     counts.put(word, counts.getOrDefault(word, 0) + 1);
        // }
        List.of(words).forEach(
            word -> {
                logger.debug("Processing word: {}", word);
                counts.put(word,counts.getOrDefault(word, 0) + 1);
            }
        );

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());

        // entries.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed());
        Comparator<Map.Entry<String, Integer>> byFrequency =Comparator.comparing(Map.Entry::getValue);
        entries.sort(byFrequency.reversed());
        
        logger.info("Word count sorted");
        
        int n = 3;
        for (int i = 0; i < n; i++) {
            Map.Entry<String, Integer> entry = entries.get(i);
            logger.debug(entry.getKey() + " for " + entry.getValue());
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        logger.info("Displayed top" + n + " words by count");

        TreeSet<String> unique = new TreeSet<>();
        // for(String word: words)
        //     unique.add(word);
        List.of(words).forEach(unique::add);
        logger.info("Added all words to tree set");

        System.out.println(unique.getFirst());
        System.out.println(unique.getLast());
    }
}