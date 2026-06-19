package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("this is c program");
        list.add("this is java program");
        list.add("this is python program");

        Map<String, Long> map = list.stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(map);

    }
}

