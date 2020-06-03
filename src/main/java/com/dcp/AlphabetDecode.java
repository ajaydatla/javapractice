package com.dcp;

import java.util.HashMap;

/**
 * @author Aj
 * 
 *This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class AlphabetDecode {
	
	public static void main(String[] args) {
		String val = "1111";
		int numOfWays = 0;
		for (int i = 0; i < val.length()-1; i++) {
			String newS = String.valueOf(val.charAt(i))+String.valueOf(val.charAt(i+1));
			if(Integer.valueOf(newS) < 27) numOfWays++;
		}
		System.out.println(1+numOfWays);
	}

}
