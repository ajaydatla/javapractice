package com.test.Index;

import com.index.dev.LongestSubstring;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringTest {


    static Stream<Arguments> basicCases()
    {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("abcabcdbb", 4),
                Arguments.of("abcueyiabcdbb", 8),
                Arguments.of("pwwkew", 3)
        );
    }


    @ParameterizedTest
    @MethodSource("basicCases")
    public void testBasicCases(String input, Integer expected) {
        assertEquals(expected, LongestSubstring.get(input));
    }

    static Stream<Arguments> edgeCases()
    {
        return Stream.of(
          Arguments.of("", 0),
          Arguments.of("a", 1),
          Arguments.of("aa", 1),
          Arguments.of("ab", 2),
          Arguments.of("aab", 2),
          Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("edgeCases")
    public void testEdgeCases(String input, Integer expected) {
        assertEquals(expected, LongestSubstring.get(input));
    }

}
