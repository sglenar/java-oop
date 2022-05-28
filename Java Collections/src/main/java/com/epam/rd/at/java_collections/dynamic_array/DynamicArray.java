package com.epam.rd.at.java_collections.dynamic_array;

import java.util.Arrays;

public class DynamicArray<T> {
    T[] array;
 //сколько реально элементов лежит в массиве


    public DynamicArray() {
        this.array = (T[])new Object[0];
    }

    /*public DynamicArray(int length) {
        this.array = (T[])new Object[length];
    }*/

    @SafeVarargs
    public DynamicArray(T... elements) {
        this.array = (T[])new Object[elements.length];
        if (this.getSize() >= 0) System.arraycopy(elements, 0, this.array, 0, this.getSize());
    }

    public void addElement(T element) {
        this.increaseSize();
        this.array[this.getSize()-1] = element;
    }

    public void addElement(T element, int index) {
        int iterator = 0;
        T[] result = (T[])new Object[this.getSize()+1];
        if (index > this.getSize()) {
            throw new IllegalArgumentException("Incorrect index: " + index);
        }
        while (iterator != index) {
            result[iterator] = this.array[iterator];
            iterator++;
        }
        result[index] = element;
        if (result.length - (index + 1) >= 0)
            System.arraycopy(this.array, index + 1 - 1, result, index + 1, result.length - (index + 1));
        this.array = result;

    }

    public void setElement(T element, int index) {
        if (index > this.getSize()) {
            throw new IllegalArgumentException("Incorrect index: " + index);
        }
        for (int i = 0; i < this.getSize(); i++) {
            if (i == index) {
                this.array[i] = element;
            }
        }
    }

    public T getElement(int index) {
        if (index > this.getSize()) {
            throw new IllegalArgumentException("Incorrect index: " + index);
        }
        T result = null;
        for (int i = 0; i < this.getSize(); i++) {
            if (i == index) {
                result = this.array[i];
            }
        }
        return result;
    }

    public void removeElement(int index) {
        T[] result = (T[])new Object[this.getSize()-1];
        if (index >= 0) System.arraycopy(this.array, 0, result, 0, index);
        if (result.length - index >= 0) System.arraycopy(this.array, index + 1, result, index, result.length - index);
        this.array = result;

    }

    public boolean containsElement(T element) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return this.array.length;
    }

    public void increaseSize() {
        this.array = Arrays.copyOf(this.array, this.getSize()+1);
    }

    public String toString() {
        StringBuilder result;
        result = new StringBuilder("[");
        for (int i = 0; i < this.getSize()-1; i++) {
            result.append(this.array[i]).append(", ");
        }
        result.append(this.array[getSize() - 1]).append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        DynamicArray<?> array1 = (DynamicArray<?>) o;
        if (this.getSize() != array1.getSize()) {
            return false;
        } else {
            for (int i = 0; i < this.getSize() ; i++) {
                if (this.array[i] != array1.array[i]) {
                    return false;
                }
            }
        } return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
