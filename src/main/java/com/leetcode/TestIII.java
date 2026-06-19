package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestIII {

    public static void main(String[] args) {
        String input = "Mumbai"; // 2nd non reapeating character
        //b
        Character result = input.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap :: new,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                        .skip(1)
                                .findFirst()
                                        .orElse(null);


        System.out.println("result:   "+result);
    }

}
