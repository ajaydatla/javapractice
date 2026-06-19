package com.leetcode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testing11122 {
    //input string contains alphabet from a to z. example - abcbefdfxy, find longest substring without repeating characters

    private static int getLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        Set<Character> set = new LinkedHashSet<>();
        int left = 0, right = 0;

        while(left < n && right < n) {
//            System.out.println(set+" "+set);
            if(set.contains(s.charAt(right))) {
//                System.out.println(set);
                maxLength = Math.max(maxLength, right - left+1);
                set.remove(s.charAt(left));
                left++;
            }else{

                set.add(s.charAt(right));
                System.out.println(set+" ddd ");

                right++;
            }
        }
        System.out.println(set);
//        System.out.println(maxLength);
//        System.out.println(set);
        return maxLength;

    }

    public static void main(String[] args) {
//        System.out.println(getLongestSubstring("abcbefghdfxy"));
//        System.out.println(getLongestSubstring("bacdmnjcaxabcd"));
        System.out.println(getLongestSubstring("abcdefabcbb"));
    }

}
