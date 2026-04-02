package com.test;

import java.util.ArrayList;
import java.util.List;

public class Testing2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd332tt5");
        list.add("owiei99");
        list.add("nvieow");
        list.add("9903932");
        list.add("9903932@$");

        list.stream().filter(Testing2::findAlphaNumeric).forEach(System.out::println);
    }

    private static boolean findAlphaNumeric(String input) {

        boolean isAlpha = false;
        boolean isNum = false;

        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);

            if(c >= 97  && c <= 122) {
                isAlpha = true;
            }else if(c >= 48 && c <= 57) {
                isNum = true;
            }

            if(isAlpha && isNum) {
                break;
            }

        }
        return isAlpha && isNum;
    }

}


