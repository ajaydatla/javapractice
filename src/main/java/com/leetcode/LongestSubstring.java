package com.leetcode;

import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        HashMap<Character, Integer> map = new HashMap<>();
        Integer length = (Integer) 0;
        Integer longestLength = 0;
        for(int i = 0; i< s.length(); i ++){
            length++;
            if(map.containsKey(s.charAt(i))){
                int oldIndex = map.get(s.charAt(i));
                map.replace(s.charAt(i), i);
                length = length - oldIndex-1;
            }else{
                map.put(s.charAt(i), i);
//                length++;
            }
            if(length > longestLength) longestLength = length;
        }
        System.out.println(longestLength);
    }
}
