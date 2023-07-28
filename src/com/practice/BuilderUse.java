package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BuilderUse {
    public static void main(String[] args) {
        /*StringBuilder secInternalIdBuilder = new StringBuilder();
        Stream.of("A","B","C").forEach(s->{
            secInternalIdBuilder.append(s);
            secInternalIdBuilder.append(",");
        });
        String s = secInternalIdBuilder.length() > 0 ? (secInternalIdBuilder.substring(0, secInternalIdBuilder.length() - 1)) : "";
        System.out.println(s);*/
        List<Integer> list=new ArrayList<>();
        list.add(1);
        if(!list.isEmpty()){
        System.out.println(list.get(0));
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
