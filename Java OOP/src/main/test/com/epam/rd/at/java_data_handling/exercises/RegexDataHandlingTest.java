package com.epam.rd.at.java_data_handling.exercises;

import com.epam.rd.at.data_handling.RegexDataHandling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexDataHandlingTest {

    @Test
    void isNameAndLastNameStartFromTheSameLetter() {
        assertTrue(RegexDataHandling.isNameAndLastNameStartFromTheSameLetter("Sarah Smith"));
        assertFalse(RegexDataHandling.isNameAndLastNameStartFromTheSameLetter("John Smith"));
        assertFalse(RegexDataHandling.isNameAndLastNameStartFromTheSameLetter("hello hello"));
    }

    @Test
    void reverseWords() {
        String string = "keep calm and print hello world";
        assertEquals("peek mlac dna tnirp olleh dlrow", RegexDataHandling.reverseWords(string));
        String string2 = "hello world";
        assertEquals("olleh dlrow", RegexDataHandling.reverseWords(string2));
    }

    @Test
    void lowerCaseToUpperUnderscoreCase() {
        String lowerCase = "lowerCaseName";
        assertEquals("LOWER_CASE_NAME", RegexDataHandling.lowerCaseToUpperUnderscoreCase(lowerCase));
    }

    @Test
    void upperUnderscoreCaseToLowerCase() {
        String upperCaseName1 = "upperCaseName";
        assertEquals(upperCaseName1, RegexDataHandling.upperUnderscoreCaseToLowerCase("UPPER_CASE_NAME"));
        String upperCaseName2 = "upperUnderscoreCaseName";
        assertEquals(upperCaseName2, RegexDataHandling.upperUnderscoreCaseToLowerCase("UPPER_UNDERSCORE_CASE_NAME"));
    }

    @Test
    void findNames() {
        String string = "Robert Anna, Harry Asha-Linda Alex Alla";
        String[] names = RegexDataHandling.findNames(string);
        String[] expected = new String[]{"Anna", "Asha", "Alla"};
        assertArrayEquals(expected, names, "Result is incorrect for " + string);
    }

    @Test
    void findPairMatchingRegexFirstMatch() {
        String[] output = RegexDataHandling.findPairMatchingRegex("\\d+", "1", "2", "a", "3");
        String[] expected = {"1", "2"};
        assertArrayEquals(expected, output);
    }

    @Test
    void findPairMatchingRegexMiddleMatch() {
        String[] output = RegexDataHandling.findPairMatchingRegex("\\d+", "a", "2", "f", "3", "w", "e", "4", "w", "5");
        String[] expected = {"2", "3"};
        assertArrayEquals(expected, output);
    }

    @Test
    void findPairMatchingRegexLastMatch() {
        String[] output = RegexDataHandling.findPairMatchingRegex("\\d+", "a", "2", "f", "3", "w", "e", "4", "5");
        String[] expected = {"4", "5"};
        assertArrayEquals(expected, output);
    }

    @Test
    void findPairMatchingRegexNoneMatch() {
        String[] output = RegexDataHandling.findPairMatchingRegex("\\d+", "a", "a", "f", "b");
        assertNull(output);
    }

    @Test
    void findPairMatchingRegexOnlyOneMatch() {
        String[] output = RegexDataHandling.findPairMatchingRegex("\\d+", "a", "1", "f", "b");
        assertNull(output);
    }
}