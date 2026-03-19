package com.leetcode;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Container_with_most_water {

    public static void main(String[] args) {
        int []height = {1,8,6,2,5,4,8,3,7};
        Container_with_most_water cwmw = new Container_with_most_water();

        System.out.println(cwmw.maxArea(height));

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

    }

    public int maxArea(int[] height) {
        int area = 0;
        int len = height.length;
        int firstLine, lastLine, indexDiff = 0;

        return area;
    }

}
