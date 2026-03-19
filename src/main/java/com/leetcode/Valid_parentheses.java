package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Valid_parentheses {

    public static void main(String[] args) {
        Valid_parentheses vp = new Valid_parentheses();
        System.out.println("--> "+vp.isValid("({[]})"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(']','[');
        brackets.put('}','{');
        brackets.put(')','(');

        ArrayList<Character> arrChar = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
           if(!arrChar.isEmpty() && arrChar.get(arrChar.size()-1).equals(brackets.get(s.charAt(i))))
                   arrChar.remove(arrChar.size() - 1);

           else
               arrChar.add(s.charAt(i));

        }
        return arrChar.isEmpty();
    }
}
