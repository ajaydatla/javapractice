package com;

import java.util.ArrayList;
import java.util.List;

public class StringToStringNum {
    public static void main(String[] args) {
//        sts();
//        System.out.println(compressString("aabcccccaaaa"));
        System.out.println(longestSubstringWithoutRepeating("abcabedbb"));
    }

    private static int longestSubstringWithoutRepeating(String input){
        int count = 0;
        int lastCount = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
//            Math.max()
            if(!list.contains(input.charAt(i))){
                list.add(input.charAt(i));
                count++;
            }else{
                if(count > lastCount) lastCount = count;
                count = 0;
                list = new ArrayList<>();
            }
        }
        return  lastCount;
    }

    private static void sts(){
        String str = "aabcccccddddddaaaa";
        int count = 0;
        char[] charArr = str.toCharArray();
        char previous = charArr[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] == previous){
                count++;
            }else{
                sb.append(String.valueOf(previous)).append(count);
                previous = charArr[i];
                count = 1;
            }

        }
        sb.append(previous).append(count);
        System.out.println(sb.toString());
    }

    private static String compressString(String input) {
        if (input == null || input.length() <= 1) return input;

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        // Handle last character sequence
        compressed.append(input.charAt(input.length() - 1)).append(count);

        return compressed.length() < input.length() ? compressed.toString() : input;
    }
}
