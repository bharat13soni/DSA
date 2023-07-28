package com.practice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        Thread even=new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName() + " - "+ i);
                }
            }
        });

        Thread odd=new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                if(i%2!=0){
                    System.out.println(Thread.currentThread().getName() + " - "+ i);
                }
            }
        });
        even.start();
        try {
            even.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        odd.start();

//        List ints=Arrays.asList(1,2);
//        List list=ints;
//        list.add(3.14);
//        System.out.println(list);

//        String test="Java is simple";
//        System.out.println(reverse(test));
        /*String remoteDirectoryPath = getRemoteDirectoryPath("/QA2VMC/MKMCA_RIPPLE/Outbound/Publication/On Demand/mca_15022_20230501.txt.zip", 1);
        System.out.println(remoteDirectoryPath);*/
        /*String s = "Please upvote the post";
        StringBuilder resultBuilder=new StringBuilder(s);
        for (String word :
                s.split(" ")) {
            String reversedString = new StringBuilder(word).reverse().toString();
            reversedString=Character.toUpperCase(reversedString.charAt(0))+reversedString.substring(1);
            resultBuilder.append(reversedString).append(" ");
        }
        System.out.println(resultBuilder.toString());*/
        /*Map<String,String> map=new HashMap<>();
        map.put("a","b");
        map.put("ab","bc");
        map.put(null,"abc");
        map.put("c",null);
        System.out.println("----------------map"+map);
        System.out.println(map);
        map.keySet().removeIf(Objects::isNull);
        map.values().removeIf(Objects::isNull);
        System.out.println(map);*/
//        printList(new ArrayList<>(map.values()));
    }

    private static List<Integer> getFilteredList(List<Integer> list) {
        List<Integer> integers = new ArrayList<>(list);
        Collections.sort(integers);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == 3) {
                System.out.println("removing 3");
                iterator.remove();
            }
        }
        return integers;
    }

    private static void printList(List<Object> list) {
        list.forEach(System.out::println);
    }

    private static void getAssociatedValues(List<String> list, String k) {
        list.stream().collect(Collectors.groupingBy(s -> s.split(",")[0]))
                .forEach((key, value) -> {
                    if (key.equals(k)) {
                        System.out.println("key ->" + key);
                        value.stream().map(v -> v.split(",")[1]).forEach(System.out::println);
                    }
                });
    }

    public static String getRemoteDirectoryPath(String remoteDirPath, int attemptCount) {
        if (attemptCount == 1) {
            remoteDirPath = remoteDirPath.substring(remoteDirPath.indexOf("Outbound"));
        }
        return remoteDirPath;
    }

    public static String reverse(String line){
        String[] words = line.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = words.length-1; i >=0 ; i--) {
            sb.append(words[i]).append(" ");
        }
        return new String(sb);
    }
}
