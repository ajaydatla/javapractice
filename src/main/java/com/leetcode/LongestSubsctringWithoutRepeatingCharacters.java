package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestSubsctringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "";
//        System.out.println(s.substring(0,1));
        LongestSubsctringWithoutRepeatingCharacters l = new LongestSubsctringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        StringBuilder currentString = new StringBuilder();
        String[] strArr = s.split("");

        int size = 0;

        for (int i = 0; i < strArr.length; i++) {
            if(currentString.indexOf(strArr[i]) != -1){
//                System.out.println(currentString);
                if(size < currentString.length()) size = currentString.length();
                currentString = new StringBuilder(currentString.substring(currentString.indexOf(strArr[i])+1, currentString.length()));
                currentString.append(strArr[i]);
//                System.out.println(currentString);
            }else currentString.append(strArr[i]);

        }
        if(size < currentString.length()) size = currentString.length();
        return size;
    }
}
