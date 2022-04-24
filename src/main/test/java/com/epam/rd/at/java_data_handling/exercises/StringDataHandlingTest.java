package com.epam.rd.at.java_data_handling.exercises;

import com.epam.rd.at.data_handling.StringDataHandling;
import com.epam.rd.at.java_data_handling.utils.OutputHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringDataHandlingTest {

    @Test
    void toBinaryCode1() {
        int number = 11202;
        String result = StringDataHandling.toBinaryCode(number);
        assertEquals("10101111000010", result, "Result is incorrect for number: " + number);
    }

    @Test
    void toBinaryCode2() {
        int number = 0;
        String result = StringDataHandling.toBinaryCode(number);
        assertEquals("0", result, "Result is incorrect for number: " + number);
    }

    @Test
    void hexColorToString() {
        String colorHex1 = "#FB12F2";
        String colorRGB = StringDataHandling.hexColorToString(colorHex1);
        assertEquals("rgb(251, 18, 242)", colorRGB, "Result is incorrect for color: " + colorHex1);

        String colorHex2 = "FB12F2";
        String nullResult2 = StringDataHandling.hexColorToString(colorHex2);
        assertNull(nullResult2, "Result is incorrect for incorrectly-formatted color " + colorHex2);

        String colorHex3 = "#GA12F2";
        String nullResult3 = StringDataHandling.hexColorToString(colorHex3);
        assertNull(nullResult3, "Result is incorrect for incorrectly-formatted color " + colorHex3);
    }

    @Test
    void changeCase() {
        String string = "AbcDe 1234!";
        assertEquals("aBCdE 1234!", StringDataHandling.changeCase(string), "Result is incorrect for string: " + string);
    }

    @Test
    void roundByScale() {
        double number = 1.6666666666666;
        String result = StringDataHandling.roundByScale(number, 2);
        assertEquals("1.67", result, "Result is incorrect for number: " + number);
    }

    @Test
    void joinBySemicolon() {
        String result = StringDataHandling.joinBySemicolon("monday", "tuesday", "wednesday");
        String expectedResult = "monday;tuesday;wednesday";
        assertEquals(expectedResult, result, "Result is incorrect for joining strings");
    }

    @Test
    void printXElementsPerLine() {
        int[] array1 = new int[]{1, 1, 5, 5, 3, 2, 3, 4, 5};
        String[] output1 = OutputHelper.readOutput(() -> StringDataHandling.printXElementsPerLine(array1, 3));
        String[] expectedOutput1 = {"1, 1, 5", "5, 3, 2", "3, 4, 5"};
        assertArrayEquals(expectedOutput1, output1);

        int[] array2 = new int[]{1, 1, 5, 5, 3, 2, 3, 4, 5, 7, 2};
        String[] output2 = OutputHelper.readOutput(() -> StringDataHandling.printXElementsPerLine(array2, 3));
        String[] expectedOutput2 = {"1, 1, 5", "5, 3, 2", "3, 4, 5", "7, 2"};
        assertArrayEquals(expectedOutput2, output2);
    }
}