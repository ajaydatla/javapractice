package com.test;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 5, 6};
        int newLength = removeDuplicates(nums);

        System.out.println("The array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        int left = 0, right = 1;
        for (int i = 0; i < nums.length && right < nums.length; i++) {
            if(nums[left] == nums[right]){
                right++;
            }else{
                left++;
                nums[left] = nums[right];
                i = left;
            }
        }
        return nums.length - left-1;
    }
}
