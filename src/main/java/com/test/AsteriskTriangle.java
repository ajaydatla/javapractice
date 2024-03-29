package com.test;

public class AsteriskTriangle {

  public static void main(String[] args) {
    int rows = 50; // Adjust this for the desired triangle size
//    printRightTriangle(rows);
    printTriangle(rows);
  }

  private static void printTriangle(int rows){
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows-i; j++) {
        System.out.print(" ");
      }
      System.out.print("*");
      for (int j = rows-i; j < rows+i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void printRightTriangle(int rows) {
    for (int i = 1; i <= rows; i++) {
      // Print spaces before asterisks (decreasing number of spaces)
      for (int j = 1; j <= rows - i; j++) {
        System.out.print(" ");
      }
      // Print asterisks (increasing number of asterisks)
      for (int k = 1; k <= 2 * i - 1; k++) {
        System.out.print("*");
      }
      System.out.println(); // Move to the next line
    }
  }
}
