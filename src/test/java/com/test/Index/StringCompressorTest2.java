package com.test.Index;

import com.index.dev.StringCompressor;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
 *  - Special characters
 *  - Whitespace
 *  - Single-character groups throughout
 *  - All-same characters
 */
@DisplayName("StringCompressor Unit Tests")
class StringCompressorTest2 {

    // ─────────────────────────────────────────────
    // 1. Basic Functionality
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Classic example: aabcccccaaa → a2b1c5a3")
    void testClassicExample() {
        assertEquals("a2b1c5a3", StringCompressor.compress("aabcccccaaa"));
    }

    @Test
    @DisplayName("Two-char groups across all positions")
    void testTwoCharGroups() {
        assertEquals("a2b2c2", StringCompressor.compress("aabbcc"));
    }

    @Test
    @DisplayName("Alternating single characters: abcabc → a1b1c1a1b1c1")
    void testAlternatingSingleChars() {
        assertEquals("a1b1c1a1b1c1", StringCompressor.compress("abcabc"));
    }

    @Test
    @DisplayName("All characters same: aaaaa → a5")
    void testAllSameCharacters() {
        assertEquals("a5", StringCompressor.compress("aaaaa"));
    }

    @Test
    @DisplayName("Single repeated group at start and end")
    void testRepeatAtStartAndEnd() {
        assertEquals("a3b1a3", StringCompressor.compress("aaabaaaa".substring(0, 7)));
        // "aaabaaaa".substring(0,7) = "aaabaaaa" → wait, let's be explicit:
        assertEquals("a3b1a3", StringCompressor.compress("aaabaaa"));
    }

    // ─────────────────────────────────────────────
    // 2. Edge Cases
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Null input returns null")
    void testNullInput() {
        assertNull(StringCompressor.compress(null));
    }

    @Test
    @DisplayName("Empty string returns empty string")
    void testEmptyString() {
        assertEquals("", StringCompressor.compress(""));
    }

    @Test
    @DisplayName("Single character: a → a1")
    void testSingleCharacter() {
        assertEquals("a1", StringCompressor.compress("a"));
    }

    @Test
    @DisplayName("Single character repeated once: aa → a2")
    void testSingleCharRepeatedTwice() {
        assertEquals("a2", StringCompressor.compress("aa"));
    }

    @Test
    @DisplayName("Two different single characters: ab → a1b1")
    void testTwoDifferentCharacters() {
        assertEquals("a1b1", StringCompressor.compress("ab"));
    }

    // ─────────────────────────────────────────────
    // 3. No-Compression Benefit (all unique chars)
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("All unique: abcd → a1b1c1d1 (longer than original)")
    void testAllUniqueCharsOutputLonger() {
        String result = StringCompressor.compress("abcd");
        assertEquals("a1b1c1d1", result);
        // Output is longer than input — valid per problem statement
        assertTrue(result.length() > "abcd".length());
    }

    @Test
    @DisplayName("Unique chars - single char string always yields char+1")
    void testUniqueCharFormat() {
        assertEquals("z1", StringCompressor.compress("z"));
    }

    // ─────────────────────────────────────────────
    // 4. Large Counts (two-digit and above)
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("10 same characters: aaaaaaaaaa → a10")
    void testTenSameCharacters() {
        assertEquals("a10", StringCompressor.compress("aaaaaaaaaa"));
    }

    @Test
    @DisplayName("100 same characters: a × 100 → a100")
    void testHundredSameCharacters() {
        assertEquals("a100", StringCompressor.compress("a".repeat(100)));
    }

    @Test
    @DisplayName("Mixed large and small groups")
    void testMixedLargeAndSmallGroups() {
        // 12 a's + 1 b + 8 c's
        String input = "a".repeat(12) + "b" + "c".repeat(8);
        assertEquals("a12b1c8", StringCompressor.compress(input));
    }

    @Test
    @DisplayName("Multiple two-digit groups")
    void testMultipleTwoDigitGroups() {
        String input = "a".repeat(11) + "b".repeat(22);
        assertEquals("a11b22", StringCompressor.compress(input));
    }

    // ─────────────────────────────────────────────
    // 5. Case Sensitivity
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Uppercase and lowercase treated as different: aAaA → a1A1a1A1")
    void testCaseSensitivity() {
        assertEquals("a1A1a1A1", StringCompressor.compress("aAaA"));
    }

    @Test
    @DisplayName("Same letter different case in groups: aaaAAA → a3A3")
    void testSamLetterDifferentCaseGroups() {
        assertEquals("a3A3", StringCompressor.compress("aaaAAA"));
    }

    @Test
    @DisplayName("All uppercase: AAABBB → A3B3")
    void testAllUppercase() {
        assertEquals("A3B3", StringCompressor.compress("AAABBB"));
    }

    // ─────────────────────────────────────────────
    // 6. Digits in Input
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Digits are treated as regular characters: 111222 → 131213")
    void testDigitCharacters() {
        // '1' x3, '2' x3 → note output contains digit chars followed by counts
        assertEquals("13" + "23", StringCompressor.compress("111222"));
    }

    @Test
    @DisplayName("Single digit character: 5 → 51")
    void testSingleDigitChar() {
        assertEquals("51", StringCompressor.compress("5"));
    }

    // ─────────────────────────────────────────────
    // 7. Special Characters
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Special characters compressed correctly: !!!@@ → !3@2")
    void testSpecialCharacters() {
        assertEquals("!3@2", StringCompressor.compress("!!!@@"));
    }

    @Test
    @DisplayName("Space characters: '   ab' → ' 3a1b1'")
    void testSpaceCharacters() {
        assertEquals(" 3a1b1", StringCompressor.compress("   ab"));
    }

    @Test
    @DisplayName("Newline characters treated as regular chars")
    void testNewlineCharacters() {
        assertEquals("\n2a1", StringCompressor.compress("\n\na"));
    }

    // ─────────────────────────────────────────────
    // 8. Patterns
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Repeating two-char pattern: ababab → a1b1a1b1a1b1")
    void testRepeatingTwoCharPattern() {
        assertEquals("a1b1a1b1a1b1", StringCompressor.compress("ababab"));
    }

    @Test
    @DisplayName("Long alternating sequence has no compression benefit")
    void testLongAlternatingNoCompression() {
        String input = "abcde";
        String result = StringCompressor.compress(input);
        assertEquals("a1b1c1d1e1", result);
    }

    @Test
    @DisplayName("Pattern with group, then single, then group")
    void testGroupSingleGroup() {
        assertEquals("a3b1a3", StringCompressor.compress("aaabaaa"));
    }

    // ─────────────────────────────────────────────
    // 9. Parameterized: multiple inputs → expected
    // ─────────────────────────────────────────────

    @ParameterizedTest(name = "{0} → {1}")
    @DisplayName("Parameterized compression checks")
    @CsvSource({
        "aabcccccaaa,   a2b1c5a3",
        "aaabbb,        a3b3",
        "abcd,          a1b1c1d1",
        "aaaa,          a4",
        "a,             a1",
        "ab,            a1b1",
        "aab,           a2b1",
        "abb,           a1b2"
    })
    void testParameterized(String input, String expected) {
        assertEquals(expected.trim(), StringCompressor.compress(input.trim()));
    }

    // ─────────────────────────────────────────────
    // 10. Output Format Assertions
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("Output always alternates char and count tokens")
    void testOutputFormat() {
        String result = StringCompressor.compress("aabcccccaaa");
        // Must match pattern: (letter)(digits)+ repeating
        assertTrue(result.matches("([a-zA-Z]\\d+)+"),
            "Expected alternating char-count format, got: " + result);
    }

    @Test
    @DisplayName("Every group count in output is a positive integer ≥ 1")
    void testAllCountsPositive() {
        String result = StringCompressor.compress("aabcccccaaa");
        // Extract counts using simple parsing
        int i = 0;
        while (i < result.length()) {
            char ch = result.charAt(i++);
            assertTrue(Character.isLetter(ch), "Expected letter at index " + (i-1));
            StringBuilder num = new StringBuilder();
            while (i < result.length() && Character.isDigit(result.charAt(i))) {
                num.append(result.charAt(i++));
            }
            int count = Integer.parseInt(num.toString());
            assertTrue(count >= 1, "Count must be ≥ 1, got: " + count);
        }
    }

    @Test
    @DisplayName("Compressed length reflects actual character groups")
    void testCompressedGroupCount() {
        // "aabcccccaaa" has 4 groups: a2, b1, c5, a3
        String result = StringCompressor.compress("aabcccccaaa");
        // Count alternating letter blocks
        int groups = 0;
        for (int i = 0; i < result.length(); i++) {
            if (Character.isLetter(result.charAt(i))) groups++;
        }
        assertEquals(4, groups);
    }

    // ─────────────────────────────────────────────
    // 11. Null and Empty via JUnit 5 source
    // ─────────────────────────────────────────────

//    @ParameterizedTest
//    @NullAndEmptySource
//    @DisplayName("Null returns null, empty returns empty")
//    void testNullAndEmpty(String input) {
//        if (input == null) {
//            assertNull(StringCompressor.compress(null));
//        } else {
//            assertEquals("", StringCompressor.compress(input));
//        }
//    }
//
//    // ─────────────────────────────────────────────
//    // 12. Performance / Stress (sanity check)
//    // ─────────────────────────────────────────────
//
//    @Test
//    @DisplayName("Large input does not throw or timeout")
//    @Timeout(2) // JUnit 5: fails if method takes longer than 2 seconds
//    void testLargeInput() {
//        String input = "a".repeat(500_000) + "b".repeat(500_000);
//        String result = StringCompressor.compress(input);
//        assertEquals("a500000b500000", result);
//    }
}