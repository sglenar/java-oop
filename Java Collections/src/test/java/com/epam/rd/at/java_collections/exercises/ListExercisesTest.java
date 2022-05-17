package com.epam.rd.at.java_collections.exercises;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListExercisesTest {

    @Test
    void generateNumbers() {
        int x = 5;
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = ListExercises.generateNumbers(x);
        assertEquals(expected, result, "Result is incorrect for generateNumbers, x=" + x);
    }

    @Test
    void findMinDate() {
        LocalDate minDate = LocalDate.of(2020, Month.JANUARY, 1);
        List<LocalDate> list = Arrays.asList(
                LocalDate.of(2020, Month.JUNE, 11),
                minDate,
                LocalDate.of(2020, Month.APRIL, 19),
                LocalDate.of(2020, Month.JANUARY, 2));
        LocalDate actualMinDate = ListExercises.findMinDate(list);
        assertEquals(minDate, actualMinDate, "Result is incorrect for findMinDate with list " + list);
    }

    @Test
    void getOddElements() {
        List<Integer> originalList = Arrays.asList(1, 1, 5, 5, 3, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 5, 2, 4);
        List<Integer> evenElements = ListExercises.getOddElements(originalList);
        assertEquals(expected, evenElements, "Result is incorrect for getOddElements with list " + originalList);
    }

    @Test
    void getOnlyNumbers() {
        List<String> originalList = Arrays.asList("1", "a", "-2", "1.2", "hello", "", null);
        List<String> expected = Arrays.asList("1", "-2");
        List<String> onlyNumbers = ListExercises.getOnlyNumbers(originalList);
        assertEquals(expected, onlyNumbers, "Result is incorrect for getOnlyNumbers with list " + originalList);
    }

    @Test
    void checkNoNegativeValuesPositive() {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 10, 123);
        boolean result = ListExercises.checkNoNegativeValues(list);
        assertTrue(result, "Result is incorrect for checkNoNegativeValues with list " + list);
    }

    @Test
    void checkNoNegativeValuesNegative() {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 10, -1);
        boolean result = ListExercises.checkNoNegativeValues(list);
        assertFalse(result, "Result is incorrect for checkNoNegativeValues with list " + list);
    }

    @Test
    void sortByLengthDesc() {
        List<String> originalList = Arrays.asList("hello", "world!!", "11", "", "java");
        List<String> expected = Arrays.asList("world!!", "hello", "java", "11", "");
        ArrayList<String> list = new ArrayList<>(originalList);
        ListExercises.sortByLengthDesc(list);
        assertEquals(expected, list, "Result is incorrect for sortByLengthDesc with list " + originalList);
    }

    @Test
    void isSortedAlphabeticallyIgnoringCasePositive() {
        List<String> list = Arrays.asList("11", "hello", "Hyper", "zero");
        boolean result = ListExercises.isSortedAlphabeticallyIgnoringCase(list);
        assertTrue(result, "Result is incorrect for isSortedAlphabeticallyIgnoringCase with list " + list);
    }

    @Test
    void isSortedAlphabeticallyIgnoringCaseNegative() {
        List<String> list = Arrays.asList("Hello", "hello", "11", "22");
        boolean result = ListExercises.isSortedAlphabeticallyIgnoringCase(list);
        assertFalse(result, "Result is incorrect for isSortedAlphabeticallyIgnoringCase with list " + list);
    }

    @Test
    void checkBracketsPositive() {
        String sequence = "({}[]([]){{}[]})";
        boolean result = ListExercises.checkBrackets(sequence);
        assertTrue(result, "Result is incorrect for checkBrackets with sequence " + sequence);
    }

    @Test
    void checkBracketsNegative() {
        String sequence = "[{]}";
        boolean result = ListExercises.checkBrackets(sequence);
        assertFalse(result, "Result is incorrect for checkBrackets with sequence " + sequence);
    }
}