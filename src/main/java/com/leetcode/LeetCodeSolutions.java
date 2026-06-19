package com.leetcode;

import java.util.*;

public class LeetCodeSolutions {

//            0,0 = 0,n-1
//            0,1 = 1,n-1
//            0,2 = 2,n-1
//            0,3 = 3,n-1
//
//            1,0 = 0,n-2
//            1,1 = 1,n-2

    public int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int left = 0;
        int maxLen = 0;

        Set<Character> set = new LinkedHashSet<>();

        for (int right = 0; right <= s.length() - 1; right++) {

            if(set.contains(s.charAt(right))) {
                maxLen = Math.max(maxLen, right - left);
                set.remove(s.charAt(left++));
                left++;
                set.add(s.charAt(right));
            }else{

                set.add(s.charAt(right));
//                maxLen = Math.max(maxLen, right - left+1);
            }

        }

        if(maxLen == 0) maxLen = set.size();

        return maxLen;
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][i];
                matrix[n-i-1][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCodeSolutions leetCodeSolutions = new LeetCodeSolutions();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrix);
        System.out.println("aadd--"+Arrays.deepToString(matrix));
        leetCodeSolutions.rotate2(matrix);
        System.out.println("aadd-----"+Arrays.deepToString(matrix));
        System.out.println(matrix);
    }

    public int[][] rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
//        System.out.println(Arrays.deepToString(matrix));
        int n = matrix.length;
        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length-1; i > -1; i--) {
                result[j][n-i-1] = matrix[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result;
    }

    public int firstMissingPositiveThird(int[] nums) {


        Map<Integer, Boolean> map = new LinkedHashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            map.put(i, false);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, true);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!map.get(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    public int firstMissingPositiveSecond(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int i = 0;
        while(i < nums.length) {
            int corIdx = nums[i] - 1;
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[corIdx]) {
                int temp = nums[i];
                nums[i] = nums[corIdx];
                nums[corIdx] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public int firstMissingPositive(int[] nums) {
//        nums = {3,4,-2,1};

        // 1, 2, 8, 3, 9, 10, 4, 55, 5, -2 //6



        Arrays.sort(nums);
        int smallest = 1;
        int secondSmallest = nums[0];

        if(nums.length == 1){
            if(secondSmallest == 1){
                return 2;
            }else{
                return 1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(secondSmallest == smallest){
                secondSmallest = nums[i];
                smallest++;
            }else if(secondSmallest > smallest){
                return smallest;
            }else{
                secondSmallest = nums[i];
            }
        }
        if(smallest == secondSmallest) return smallest+1;
        else if(secondSmallest - smallest == 1){
            return Math.min(smallest,Math.abs(secondSmallest));
        }else if(secondSmallest - smallest > 1){
            return smallest;
        }

        return Math.max(smallest,Math.abs(secondSmallest));
    }

    private void getTotalComb(int[] nums){
        int totalCombination = 1;

        for (int i = nums.length; i > 0; i--) {
            totalCombination *= i;
        }

        for (int i = 0; i <= totalCombination; i++) {
            List<Integer> list = new ArrayList<>();
        }
        System.out.println(totalCombination);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        Input: nums = [1,2,3]
//        Output: [[1,2,3,4],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


        result.add(swap(new ArrayList<>(
                Arrays.stream(nums)
                        .boxed()
                        .toList()   // Java 16+
        ), 1, 2));

        return result;
    }

    private List<Integer> swap(List<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        return a;
    }
}
