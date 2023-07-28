package com.practice.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateWordsInString {
    public static void main(String args[]) {
        // Given String containing duplicate words
        String input = "Java is a programming language. Python is also a programming language.";
        // Converting given String to lowerCase
        input = input.toLowerCase();
      /* Split the Input String into words using
      built-in split() method */
        String[] strArray = input.split(" ");
      /* Declare List of String that will
      contain repeated words*/
        List<String> repeatedWords = new ArrayList<>();
      /* Declare HashSet of String that will
      contain unique words */
        Set<String> uniqueWords = new HashSet<>();
        for (String str : strArray) {
            if (!uniqueWords.add(str))
                repeatedWords.add(str);
        }
        System.out.println(repeatedWords);
    }
}
