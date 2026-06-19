package com.test;

import java.util.*;

public class SeconddHighest {

    public static void main(String[] args) {
        String s = "ceceba";
        int k = 2;
        System.out.println("Length of the longest substring with at most " + k + " distinct characters: " + longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char rightChar = s.charAt(i);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            while(map.size() > k) {
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }

}
