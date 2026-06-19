package com.test;

import java.util.TreeMap;

public class MergeTreeMaps {
    public static void main(String[] args) {
        // Define the two TreeMaps
        TreeMap<Integer, Integer> treeMap1 = new TreeMap<>();
        treeMap1.put(1, 10);
        treeMap1.put(2, 20);
        treeMap1.put(3, 30);

        TreeMap<Integer, Integer> treeMap2 = new TreeMap<>();
        treeMap2.put(2, 15);
        treeMap2.put(3, 25);
        treeMap2.put(4, 40);

        // Merge the TreeMaps
        TreeMap<Integer, Integer> mergedMap = mergeTreeMaps(treeMap1, treeMap2);

        // Print the merged result
        System.out.println("Merged TreeMap: " + mergedMap);
    }

    public static TreeMap<Integer, Integer> mergeTreeMaps(
            TreeMap<Integer, Integer> map1, TreeMap<Integer, Integer> map2) {
                //write code here
        TreeMap<Integer, Integer> result = new TreeMap<>(map1);

        map2.forEach((k, v) ->
                result.merge(k, v, Integer::sum));

        return result;
    }
}