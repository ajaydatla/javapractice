package com.leetcode;
public class MatrixMn {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 1, 1, 1},{0,0,0,1,1},{0,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1}};
        for (int[] b : arr) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(b[j]);System.out.print(" ");
            }System.out.println();
        }
        System.out.println("total ones are " + findOnes(arr));
    }
    private static int findOnes(int[][] arr) {
        int sum = 0, n = arr.length;
        if(arr == null || arr.length == 0) return 0;
        for (int[] a : arr) {
            int index = singleOne(a);
            sum += n - index;
        }
        return sum;
    }
    private static int singleOne(int[] a){
        int l = 0, r = a.length - 1, position = a.length, sum = 0;
        while(l <= r){
            int mid = l+(r-1)/2;
            if(mid < a.length && a[mid] == 1){
                position = mid;
                r = mid - 1;}
            else{
                 l = mid+1;
            }}
        return position;
    }
}

//    Find the number of 1’s in the given matrix of size M*N
//    Input : 0 0 1 1 1
//            0 0 0 1 1
//            0 1 1 1 1
//            0 0 0 0 0
//            1 1 1 1 1
//    Output : 14

