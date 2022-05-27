package com.epam.rd.at.java_collections.dynamic_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicArrayTest {

    @Test
    void addElement() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 2);
        array.addElement(4);
        String s = array.toString();
        assertEquals("[1, 2, 2, 4]", s);
    }

    @Test
    void addElementAtIndex() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        array.addElement(4, 2);
        String s = array.toString();
        assertEquals("[1, 2, 4, 3]", s);
    }

    @Test
    void addElementAtIndexNegative() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> array.addElement(4, 10));
        assertTrue(exception.getMessage().contains("10"));
    }

    @Test
    void setElement() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.addElement(1);
        array.addElement(2);
        array.setElement(3, 1);
        String s = array.toString();
        assertEquals("[1, 3]", s);
    }

    @Test
    void setElementAtIndexNegative() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> array.setElement(4, 10));
        assertTrue(exception.getMessage().contains("10"));
    }

    @Test
    void getElement() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        Integer element = array.getElement(2);
        assertEquals(3, element);
    }

    @Test
    void getElementAtIndexNegative() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> array.getElement(10));
        assertTrue(exception.getMessage().contains("10"));
    }

    @Test
    void removeElement() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5, 6);
        array.removeElement(1);
        String s = array.toString();
        assertEquals("[1, 3, 4, 5, 6]", s);
    }

    @Test
    void containsElementTrue() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5, 6);
        boolean result = array.containsElement(5);
        assertTrue(result);
    }

    @Test
    void containsElementFalse() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5, 6);
        boolean result = array.containsElement(7);
        assertFalse(result);
    }

    @Test
    void containsElementAfterAdding() {
        DynamicArray<Integer> array = new DynamicArray<>();
        array.addElement(3);
        boolean result = array.containsElement(3);
        assertTrue(result);
    }

    @Test
    void containsElementAfterRemove() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3, 4, 5, 6);
        array.removeElement(3);
        boolean result = array.containsElement(4);
        assertFalse(result);
    }

    @Test
    void getSize() {
        DynamicArray<Integer> array = new DynamicArray<>();
        assertEquals(0, array.getSize());
    }

    @Test
    void getSizeMany() {
        DynamicArray<Integer> array = new DynamicArray<>(1, 2, 3);
        assertEquals(3, array.getSize());
    }

    @Test
    void equalsTrue() {
        DynamicArray<Integer> array1 = new DynamicArray<>(5);
        array1.addElement(1);
        array1.addElement(2);
        DynamicArray<Integer> array2 = new DynamicArray<>(5);
        array2.addElement(1);
        array2.addElement(2);
        DynamicArray<Integer> array3 = new DynamicArray<>(1, 2);
        assertEquals(array1, array2);
        assertEquals(array2, array3);
        assertEquals(array1, array3);
    }

    @Test
    void equalsDifferentSize() {
        DynamicArray<Integer> array1 = new DynamicArray<>(1, 2);
        DynamicArray<Integer> array2 = new DynamicArray<>(1, 2, 3);
        assertNotEquals(array1, array2);
    }

    @Test
    void equalsDifferentContent() {
        DynamicArray<Integer> array1 = new DynamicArray<>(1, 2);
        DynamicArray<Integer> array2 = new DynamicArray<>(1, 3);
        assertNotEquals(array1, array2);
    }
}