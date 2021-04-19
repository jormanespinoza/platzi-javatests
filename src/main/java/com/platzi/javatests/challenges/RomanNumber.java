package com.platzi.javatests.challenges;

public class RomanNumber {

    public static String arabicToRoman(int n) {
        if (n <= 0 || n >= 4000) {
            throw new IllegalArgumentException("Sólo se permiten números positivos entre 1 y 4000");
        }

        int actualArabicNumberSize = String.valueOf(n).length();
        String arabicNumber = String.valueOf(n);
        StringBuilder romanNumber = new StringBuilder();

        for (int i = 0; i < String.valueOf(n).length(); i++) {
            int actualArabicNumber = Integer.parseInt(arabicNumber.substring(i, i + 1));
            String actualRoman = getRoman(actualArabicNumber, actualArabicNumberSize);

            if (actualRoman.equals("") && actualArabicNumber <= 3) {
                actualRoman = getRepeatedLetters(actualArabicNumberSize, actualArabicNumber, actualRoman);
            }

            if (actualRoman.equals("") && actualArabicNumber == 4) {
                actualRoman += getRoman(1, actualArabicNumberSize) + getRoman(5, actualArabicNumberSize);
            }

            if (actualRoman.equals("") && actualArabicNumber >= 6 && actualArabicNumber <= 8) {
                actualRoman += getRoman(5, actualArabicNumberSize) + getRepeatedLetters(actualArabicNumberSize, actualArabicNumber % 5, actualRoman);
            }

            if (actualRoman.equals("") && actualArabicNumber == 9) {
                actualRoman += getRepeatedLetters(actualArabicNumberSize, 1, actualRoman) + getRoman(1, actualArabicNumberSize + 1);
            }

            romanNumber.append(actualRoman);
            actualArabicNumberSize--;
        }

        return romanNumber.toString();
    }

    private static String getRepeatedLetters(int arabicNumberSize, int times, String actualRoman) {
        return actualRoman + getRoman(1, arabicNumberSize).repeat(Math.max(0, times));
    }

    private static String getRoman(int n, int arabicSize) {
        n *= Math.pow(10, arabicSize - 1);

        switch (n) {
            case 1: {
                return "I";
            }
            case 5: {
                return "V";
            }
            case 10: {
                return "X";
            }
            case 50: {
                return "L";
            }
            case 100: {
                return "C";
            }
            case 500: {
                return "D";
            }
            case 1000: {
                return "M";
            }
            default:
                return "";
        }
    }
}
