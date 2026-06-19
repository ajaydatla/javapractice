package com.index.dev;

public class LongestSubstring {

//    Input: "abcabcdbb"
//    Output: 4 (substring "abcd")
//    abcueyiabcdbb

    public static Integer get(String input) {
        if (input == null || input.isEmpty()) return 0;
        if (input.length() == 1) return 1;

        int left = 0, right = 1;
        int maxLength = 0;
        int finalMaxLength = 0;
        for (int i = 0; i < input.length(); i++) {
            if (right > input.length() - 1) break;
            if (!input.substring(left, right).contains(String.valueOf(input.charAt(right)))) {
                right++;
            } else {

                left++;
                i = left;
            }

            maxLength = right - left;
            finalMaxLength = Math.max(maxLength, finalMaxLength);

        }

        return Math.max(1, finalMaxLength);
    }


}
