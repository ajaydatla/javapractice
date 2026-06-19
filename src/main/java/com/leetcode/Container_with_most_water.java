package com.leetcode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Container_with_most_water {

    public static void main(String[] args) {
//        int []height = {1,8,6,2,5,4,8,3,7};
        int []height = {2,3,4,5,18,17,6};
        //difference between indices multiply by smaller of thier values
        int waterAmount = 0;
        int start=0, end = height.length-1;
        for (int i = 0; i < height.length; i++) {

            waterAmount = getWaterAmount(height, start, end);

            if(getWaterAmount(height, i, end) > waterAmount){
                start = i;
            }
            if(getWaterAmount(height, start, i) > waterAmount){
                end = i;
            }

        }
        System.out.println(getWaterAmount(height, start, end));
    }

    private static int getWaterAmount(int []height, int start, int end) {
        return (end - start)*(Math.min(height[end], height[start]));
    }


}
