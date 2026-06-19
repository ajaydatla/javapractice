package com.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Slutionsss {

    public static void main(String[] args) {
        String str = "kkkeosje";

        Map<Character, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        }
        System.out.println(map.toString());
        int value = 0;
        int hightes = 0;
        int secondHighest = 0;
        char secondH = str.charAt(0);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            value = entry.getValue();
            if (value > hightes) {
                secondHighest  = hightes;
                hightes = Math.max(hightes, value);
                secondH =  entry.getKey();
            }else if (value > secondHighest) {
                secondHighest = value;
                secondH =  entry.getKey();
            }
        }
        System.out.println(secondHighest);

    }

}
