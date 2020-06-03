package com.hackerrank;


import java.util.Scanner;

public class Anagrams {
	static boolean isAnagram(String a, String b) {
		a = a.toUpperCase();
		b = b.toUpperCase();
		boolean flag = true;
		if(a.length() == b.length()) {
			java.util.HashMap<Character, Integer> mapA = new java.util.HashMap<Character, Integer>();
			java.util.HashMap<Character, Integer> mapB = new java.util.HashMap<Character, Integer>();
			for (int i = 0; i < a.length(); i++) {
				if(mapA.containsKey(a.charAt(i))) mapA.put(a.charAt(i), 1+mapA.get(a.charAt(i)));
				else mapA.put(a.charAt(i), 1);
			}
			for (int i = 0; i < b.length(); i++) {
				if(mapB.containsKey(b.charAt(i))) mapB.put(b.charAt(i), 1+mapB.get(b.charAt(i)));
				else mapB.put(b.charAt(i), 1);
			}
			for (int i = 0; i < a.length(); i++) {
				if(mapA.get(a.charAt(i)) != mapB.get(a.charAt(i))) flag = false;
			}
			return flag;
		}
		else return false;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
