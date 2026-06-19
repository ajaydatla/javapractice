package com.test;

import com.leetcode.LeetCodeSolutions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class LeetCodeSolutionsTest {


    private final LeetCodeSolutions solution = new LeetCodeSolutions();



    public static Stream<Arguments> rotateMatrixInput() {
        return Stream.of(
//                Arguments.of(new int[][]{{5,1,9,11}, {2,4,8,10},{13,3,6,7},{15,14,12,16}},
//                new int[][]{{15,13,2,5}, {14,3,4,1},{12,6,8,9},{16,7,10,11}})
//                ,
                Arguments.of(new int[][]{{1,2,3},{4,5,6},{7,8,9}},
                        new int[][]{{7,4,1},{8,5,2},{9,6,3}}));
    }

    public static Stream<Arguments> longestUniqueSubstring() {
        return Stream.of(
                Arguments.of("abcabcbba" , 3),
                Arguments.of("abcabcefgbba" , 6),
                Arguments.of("kumar" , 5),
                Arguments.of("kumarr" , 5),
                Arguments.of("kumar d" , 7),
                Arguments.of("kumar d " , 7),
                Arguments.of("abccceeddabcdefghabc" , 8)
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("longestUniqueSubstring")
    public void longestUniqueSubstring(String input, int expected) {
        assertEquals(expected, solution.lengthOfLongestUniqueSubstring(input));

    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("rotateMatrixInput")
    public void rotate2(int[][] input, int[][] expected) {
        solution.rotate2(input);
        System.out.println(Arrays.deepToString(input));
        assertArrayEquals(expected,input);

    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("rotateMatrixInput")
    public void rotate(int[][] input, int[][] expected) {
        int[][] result = solution.rotate(input);
        assertArrayEquals(expected,result);
    }

    public static Stream<Arguments> inputsAndOutputsFirstMissingPositive() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 8, 3, 9, 10, 4, 55, 5, -2}, 6)
                ,
                Arguments.of(new int[]{3,4,-2,1}, 2)
                ,
                Arguments.of(new int[]{3,4,-2}, 1)
                ,
                Arguments.of(new int[]{1,2,0}, 3)
                ,
                Arguments.of(new int[]{0}, 1)
                ,
                Arguments.of(new int[]{1000,-1}, 1)
                ,
                Arguments.of(new int[]{-1,-2}, 1)
                ,
                Arguments.of(new int[]{1,1}, 2)
                ,
                Arguments.of(new int[]{1,2,3,4,5,6,7,8,9,20}, 10)
                ,
                Arguments.of(new int[]{0,-1,3,1}, 2)
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("inputsAndOutputsFirstMissingPositive")
    public void testfirstMissingPositive(int[] nums , int expected) {
        assertEquals(expected, solution.firstMissingPositive(nums));
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("inputsAndOutputsFirstMissingPositive")
    public void testfirstMissingPositiveS(int[] nums , int expected) {
        assertEquals(expected, solution.firstMissingPositiveSecond(nums));
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("inputsAndOutputsFirstMissingPositive")
    public void testfirstMissingPositiveT(int[] nums , int expected) {
        assertEquals(expected, solution.firstMissingPositiveThird(nums));
    }

    @Test
    public void testPermute_basicCase() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
        assertNotNull(result);
        assertEquals(6, result.size()); // 3! = 6

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );

        assertTrue(result.containsAll(expected));
    }


}
