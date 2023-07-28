package com.practice;

import java.beans.BeanProperty;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Ex {
    public static void main(String[] args) {
        /*List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        Predicate<Integer> predicate = i -> i % 2 == 0;
        Function<Integer, Integer> function = n -> n * 2;

        Consumer<Integer> consumer = System.out::println;
        nums.stream().filter(predicate).map(function).forEach(consumer);
        System.out.println(predicate.test(2));
        System.out.println(function.apply(2));
        consumer.accept(2);
        // Supplier interface implementation that generates random integer value
        Supplier<Integer> supp = () -> new Random().nextInt();
        int count = 5;

        // Calling get method to get the random value
        while (count-- > 0) System.out.println(supp.get());

*/

        String[] arr = {"51", "123763", "66987", "12", "9"};
        String[] asc = sort(arr, true);
        System.out.println("asc -> " + Arrays.asList(asc));
        String[] desc = sort(arr, false);
        System.out.println("desc ->" + Arrays.asList(desc));

    }


    //order=true ->ASC order=false ->DESC
    private static String[] sort(String[] arr, boolean order) {
        if (order)
//            Arrays.sort(arr, String::compareTo);
            Arrays.sort(arr, Comparator.comparingInt(Integer::parseInt));
        else
            Arrays.sort(arr, (s1, s2) -> Integer.parseInt(s2) - Integer.parseInt(s1));

        return arr;


    }
}

/*
@Qualifier("imp1")
@Auto
Interface

Interface
@Service("impl1")
        impl1
@Service("impl2")impl2*/


