package com.index.dev;

import java.util.Objects;

public class StringCompressor {


    public static String compress(String str) {
//        "aabcccccaaa" into "a2b1c5a3"
        if(Objects.isNull(str) || str.isEmpty()) return str;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        char pointerChar = str.charAt(0);
        str.repeat(count);
        for (int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == pointerChar) {
                count++;
            }
            else{
                sb.append(pointerChar).append(count);
                count = 1;
                pointerChar = str.charAt(i);
            }
        }


        return sb.append(pointerChar).append(count).toString();
    }

}
