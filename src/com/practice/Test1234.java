package com.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1234 {

    /**
     * Given an array arr[] of N+2 elements. All elements of the array are in the range of 1 to N.
     * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.
     * Examples:
     * Input: arr = [4, 2, 4, 5, 2, 3, 1], N = 5
     * Output: 4 2
     * Explanation: The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.
     */

    public static void main(String[] args) {
        int[] arr= {4, 2, 4, 5, 2, 3, 1};
        int [] count=new int[6];
        Arrays.stream(arr).forEach(n -> count[n]++);
        List<Integer> dupes= IntStream.range(0, count.length).filter(i -> count[i] == 2).boxed().collect(Collectors.toList());
        System.out.println(dupes);

        /*List<Integer> dupes=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
         Stream.of(4, 2, 4, 5, 2, 3, 1).map(n->{
             if(map.containsKey(n)){
                 map.put(n,map.get(n)+1);
             }else{
                 map.put(n,1);
             }

             return null;
         });
         map.forEach((key, value) -> {
             if (value == 2) {
                 dupes.add(key);
             }
         });

        System.out.println(dupes);*/

    }
}
