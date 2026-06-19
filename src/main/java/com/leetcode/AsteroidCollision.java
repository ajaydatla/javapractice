package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids){

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(asteroids[index]);
        while(index < asteroids.length-1){
            int currentElement = asteroids[index+1];
            if(currentElement > 0){
                stack.push(currentElement);
                index++;
            }else{
                if(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) <  Math.abs(currentElement)){
                    stack.pop();
                }
                else if(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) >  Math.abs(currentElement)){
                    index++;
                }else if(!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) ==  Math.abs(currentElement)){
                    stack.pop();
                    index++;
                }
                else{
                    stack.push(currentElement);
                    index++;
                }
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        int[] result = asteroidCollision(new int[]{3,5,-6,2,-1,4, -7});
        int[] result = asteroidCollision(new int[]{8, -8});
        System.out.println(Arrays.toString(result));
    }

}
