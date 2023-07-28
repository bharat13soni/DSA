package com.practice.map;

import java.text.ParseException;
import java.util.*;

/**
 * How to sort HashMap in Java by keys and values.
 * HashMap doesn't guarantee any order, so you cannot rely on it, even if
 * it appears that it's storing entries in a particular order, because
 * it may not be available in future version e.g. earlier HashMap stores
 * integer keys on the order they are inserted but from Java 8 it has changed.
 *
 */

public class HashMapSorting {

    public static void main(String[] args) throws ParseException {

        // let's create a map with Java releases and their code names
        HashMap<String, String> codeNames = new HashMap<String, String>();

        codeNames.put("JDK 1.1.4", "Sparkler");
        codeNames.put("J2SE 1.2", "Playground");
        codeNames.put("J2SE 1.3", "Kestrel");
        codeNames.put("J2SE 1.4", "Merlin");
        codeNames.put("J2SE 5.0", "Tiger");
        codeNames.put("Java SE 6", "Mustang");
        codeNames.put("Java SE 7", "Dolphin");

        System.out.println("HashMap before sorting, random order ");
        Set<Map.Entry<String, String>> entries = codeNames.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " ==> " + entry.getValue());
        }

        // Now let's sort HashMap by keys first 
        // all you need to do is create a TreeMap with mappings of HashMap
        // TreeMap keeps all entries in sorted order
        TreeMap<String, String> sorted = new TreeMap<>(codeNames);
        Set<Map.Entry<String, String>> mappings = sorted.entrySet();

        System.out.println("HashMap after sorting by keys in ascending order ");
        for (Map.Entry<String, String> mapping : mappings) {
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }


        // Now let's sort the HashMap by values
        // there is no direct way to sort HashMap by values but you
        // can do this by writing your own comparator, which takes
        // Map.Entry object and arrange them in order increasing 
        // or decreasing by values.

        Comparator<Map.Entry<String, String>> valueComparator
                = (e1, e2) -> {
                    String v1 = e1.getValue();
                    String v2 = e2.getValue();
                    return v1.compareTo(v2);
                };

        // Sort method needs a List, so let's first convert Set to List in Java
        List<Map.Entry<String, String>> listOfEntries
                = new ArrayList<>(entries);

        // sorting HashMap by values using comparator
        listOfEntries.sort(valueComparator);

        LinkedHashMap<String, String> sortedByValue
                = new LinkedHashMap<>(listOfEntries.size());

        // copying entries from List to Map
        for (Map.Entry<String, String> entry : listOfEntries) {
            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        System.out.println("HashMap after sorting entries by values ");
        Set<Map.Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();

        entrySetSortedByValue.stream().map(mapping -> mapping.getKey() + " ==> " + mapping.getValue()).forEach(System.out::println);
    }


}
