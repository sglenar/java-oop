package com.epam.rd.at.data_handling;

public class StringDataHandling {

    // task 1
    public static String toBinaryCode(int number) {
            StringBuffer buffer = new StringBuffer();
            String result;
            int reminder;
            if (number == 0) {
                result = String.valueOf(0);
            } else {
                while(number !=0 ) {
                    reminder = number%2;
                    buffer.append(reminder);
                    number = number/2;
                }
                result = String.valueOf(buffer.reverse());
            }

            return result;
    }

    // task 2
    public static String hexColorToString(String hex) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 3
    public static String changeCase(String string) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 4
    public static String roundByScale(double number, int scale) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 5
    public static String joinBySemicolon(String... strings) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    // task 6
    public static void printXElementsPerLine(int[] array, int x) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
