package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<String> list= Arrays.asList("AF", "AL", "DZ");
        String string = list.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", ",");
        System.out.println(string);

    }

    private static void getAssociatedValues(List<String> list,String k) {
        list.stream().collect(Collectors.groupingBy(s -> s.split(",")[0]))
                .forEach((key, value) -> {
                    if(key.equals(k)) {
                        System.out.println("key ->" + key);
                        value.stream().map(v -> v.split(",")[1]).forEach(System.out::println);
                    }
                });
    }
}
