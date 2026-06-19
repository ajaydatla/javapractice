package com.test.Index;

import com.index.dev.StringCompressor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for StringCompressor.compress()
 *
 * Coverage:
 *  - Basic functionality
 *  - Edge cases (null, empty, single char)
 *  - No-compression scenarios
 *  - Large counts (10+)
 *  - Case sensitivity
 *  - Repeating patterns
 *  - Special characters / whitespace / digits
 *  - Output format assertions
 *  - Performance / stress
 */
@DisplayName("StringCompressor Unit Tests")
class StringCompressorTest {

    // ─────────────────────────────────────────────────────────────────────────
    // 1. Basic Functionality
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> basicFunctionality() {
        return Stream.of(
            Arguments.of("aabcccccaaa",  "a2b1c5a3"),       // classic example
            Arguments.of("aabbcc",        "a2b2c2"),         // two-char groups
            Arguments.of("abcabc",        "a1b1c1a1b1c1"),   // alternating singles
            Arguments.of("aaaaa",         "a5"),              // all same characters
            Arguments.of("aaabaaa",       "a3b1a3")           // group-single-group
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("basicFunctionality")
    @DisplayName("Basic functionality")
    void testBasicFunctionality(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 2. Edge Cases (null, empty, single char, two chars)
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> edgeCases() {
        return Stream.of(
            Arguments.of(null, null),    // null input → null
            Arguments.of("",   ""),      // empty string → empty string
            Arguments.of("a",  "a1"),    // single character
            Arguments.of("aa", "a2"),    // two of the same
            Arguments.of("ab", "a1b1"),  // two different characters
            Arguments.of("z",  "z1")     // single char, end of alphabet
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("edgeCases")
    @DisplayName("Edge cases — null, empty, single, two chars")
    void testEdgeCases(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 3. No-Compression Benefit (all unique characters)
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> noCompressionBenefit() {
        return Stream.of(
            Arguments.of("abcd",   "a1b1c1d1"),       // 4 unique → output longer
            Arguments.of("abcde",  "a1b1c1d1e1"),     // 5 unique
            Arguments.of("abcabc", "a1b1c1a1b1c1"),   // repeating pattern, no run
            Arguments.of("ababab", "a1b1a1b1a1b1")    // alternating pair
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("noCompressionBenefit")
    @DisplayName("No compression benefit — all unique / alternating chars")
    void testNoCompressionBenefit(String input, String expected) {
        String result = StringCompressor.compress(input);
        assertEquals(expected, result);
        // Output is longer than input — valid per problem statement
        assertTrue(result.length() > input.length(),
            "Expected output longer than input for all-unique input");
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 4. Large Counts (two-digit and above)
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> largeCounts() {
        return Stream.of(
            Arguments.of("a".repeat(10),                           "a10"),
            Arguments.of("a".repeat(100),                          "a100"),
            Arguments.of("a".repeat(12) + "b" + "c".repeat(8),    "a12b1c8"),
            Arguments.of("a".repeat(11) + "b".repeat(22),         "a11b22")
        );
    }

    @ParameterizedTest(name = "input => {1}")
    @MethodSource("largeCounts")
    @DisplayName("Large counts — two-digit and above")
    void testLargeCounts(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 5. Case Sensitivity
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> caseSensitivity() {
        return Stream.of(
            Arguments.of("aAaA",   "a1A1a1A1"), // uppercase ≠ lowercase
            Arguments.of("aaaAAA", "a3A3"),     // groups split by case
            Arguments.of("AAABBB", "A3B3"),     // all uppercase
            Arguments.of("aabbAA", "a2b2A2")    // mixed lower and upper groups
        );
    }

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("caseSensitivity")
    @DisplayName("Case sensitivity — uppercase ≠ lowercase")
    void testCaseSensitivity(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 6. Digit Characters in Input
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> digitCharacters() {
        return Stream.of(
            Arguments.of("111222", "13" + "23"),  // '1'×3 then '2'×3
            Arguments.of("5",      "51"),          // single digit char
            Arguments.of("1122",   "12" + "22")   // two digit-char groups
        );
    }

    @ParameterizedTest(name = "\"{0}\" => \"{1}\"")
    @MethodSource("digitCharacters")
    @DisplayName("Digit characters treated like any other character")
    void testDigitCharacters(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 7. Special Characters and Whitespace
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> specialCharacters() {
        return Stream.of(
            Arguments.of("!!!@@",  "!3@2"),    // punctuation
            Arguments.of("   ab",  " 3a1b1"),  // leading spaces
            Arguments.of("\n\na",  "\n2a1"),   // newlines
            Arguments.of("##$$%%", "#2$2%2")   // mixed symbols
        );
    }

    @ParameterizedTest(name = "input => \"{1}\"")
    @MethodSource("specialCharacters")
    @DisplayName("Special characters and whitespace")
    void testSpecialCharacters(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 8. Output Format — Correct Number of Character Groups
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> outputGroupCounts() {
        return Stream.of(
            Arguments.of("aabcccccaaa", 4),  // a2 b1 c5 a3
            Arguments.of("aaabbb",      2),  // a3 b3
            Arguments.of("abcd",        4),  // a1 b1 c1 d1
            Arguments.of("a",           1),  // a1
            Arguments.of("aaaAAA",      2)   // a3 A3
        );
    }

    @ParameterizedTest(name = "\"{0}\" has {1} group(s)")
    @MethodSource("outputGroupCounts")
    @DisplayName("Output format — correct number of character groups")
    void testOutputGroupCount(String input, int expectedGroups) {
        String result = StringCompressor.compress(input);
        int groups = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.isLetter(result.charAt(i))) groups++;
        }
        assertEquals(expectedGroups, groups,
            "Expected " + expectedGroups + " group(s) in compressed output: " + result);
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 9. All Counts in Output Must Be Positive Integers ≥ 1
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> positiveCountInputs() {
        return Stream.of(
            Arguments.of("aabcccccaaa"),
            Arguments.of("abcd"),
            Arguments.of("aaaAAA"),
            Arguments.of("a".repeat(50) + "b".repeat(50))
        );
    }

    @ParameterizedTest(name = "\"{0}\" — all counts ≥ 1")
    @MethodSource("positiveCountInputs")
    @DisplayName("All counts in output are positive integers ≥ 1")
    void testAllCountsPositive(String input) {
        String result = StringCompressor.compress(input);
        int i = 0;
        while (i < result.length()) {
            i++; // skip the character token
            StringBuilder num = new StringBuilder();
            while (i < result.length() && Character.isDigit(result.charAt(i))) {
                num.append(result.charAt(i++));
            }
            assertTrue(Integer.parseInt(num.toString()) >= 1,
                "Count must be ≥ 1 in output: " + result);
        }
    }

    // ─────────────────────────────────────────────────────────────────────────
    // 10. Performance / Stress
    // ─────────────────────────────────────────────────────────────────────────

    static Stream<Arguments> performanceCases() {
        return Stream.of(
            Arguments.of("a".repeat(500_000) + "b".repeat(500_000), "a500000b500000"),
            Arguments.of("a".repeat(1_000_000),                      "a1000000"),
            Arguments.of("ab".repeat(100),                            "a1b1".repeat(100))
        );
    }

    @ParameterizedTest(name = "large input => \"{1}\"")
    @MethodSource("performanceCases")
    @DisplayName("Performance — large inputs complete within 2 seconds")
//    @Timeout(2)
    void testPerformance(String input, String expected) {
        assertEquals(expected, StringCompressor.compress(input));
    }
}