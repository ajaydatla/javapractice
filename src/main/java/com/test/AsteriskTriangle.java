package com.test;

import java.util.ArrayList;
import java.util.List;

public class AsteriskTriangle {

  public static void main(String[] args) {
    List<Integer> arg = new ArrayList<>();
    List<Integer> arg2 = new ArrayList<>();
    List<Integer> arg3 = new ArrayList<>();
    arg.add(33);
    arg.add(33);
    arg.add(44);

    arg.add(44);
    arg.add(5);

    arg.stream().forEach(h -> {
      if(arg2.contains(h)){
        arg3.add(h);
      }else{
        arg2.add(h);
      }

    });

    System.out.println(arg3);
  }

}
