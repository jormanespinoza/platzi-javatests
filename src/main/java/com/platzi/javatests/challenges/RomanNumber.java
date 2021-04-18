package com.platzi.javatests.challenges;

public class RomanNumber {

    public static String arabicToRoman(int n) {
        if (n <= 0 || n >= 4000) {
            throw new RuntimeException("Sólo se permiten números posivitos entre 1 y 4000");
        }

        int arabicNumberSize = String.valueOf(n).length();
        String arabicNumber = String.valueOf(n);

        String romanNumber = "";
        for (int i = 0; i < String.valueOf(n).length(); i++) {
            int arabic = Integer.parseInt(arabicNumber.substring(i, i + 1));
            String actualRoman = getRoman(arabic, arabicNumberSize);

            if (actualRoman.equals("") && arabic <= 3) {
                actualRoman = getIes(arabicNumberSize, arabic, actualRoman);
            }

            if (actualRoman.equals("") && arabic == 4) {
                actualRoman += getRoman(1, arabicNumberSize) + getRoman(5, arabicNumberSize);
            }

            if (actualRoman.equals("") && arabic >= 4 && arabic <= 8) {
                actualRoman += getRoman(5, arabicNumberSize) + getIes(arabicNumberSize, arabic % 5, actualRoman);
            }

            if (actualRoman.equals("") && arabic == 9) {
                actualRoman += getIes(arabicNumberSize, 1, actualRoman) + getRoman(1, arabicNumberSize + 1);
            }

            romanNumber += actualRoman;

            arabicNumberSize--;
        }

        return romanNumber;
    }

    private static String getIes(int arabicNumberSize, int times, String actualRoman) {
        for (int j = 0; j < times; j++) {
            actualRoman += getRoman(1, arabicNumberSize);
        }

        return actualRoman;
    }

    private static String getRoman(int n, int arabicSize) {
        String roman = "";

        if (arabicSize > 1) {
            n *= Math.pow(10, arabicSize - 1);
        }

        switch (n) {
            case 1: {
                roman += "I";
                break;
            }
            case 5: {
                roman += "V";
                break;
            }
            case 10: {
                roman += "X";
                break;
            }
            case 50: {
                roman += "L";
                break;
            }
            case 100: {
                roman += "C";
                break;
            }
            case 500: {
                roman += "D";
                break;
            }
            case 1000: {
                roman += "M";
            }
        }

        return roman;
    }
}
