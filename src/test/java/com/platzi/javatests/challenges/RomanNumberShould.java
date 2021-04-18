package com.platzi.javatests.challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanNumberShould {

    @Test
    void return_proper_romans_conversion_table() {
        assertEquals("I", RomanNumber.arabicToRoman(1));
        assertEquals("V", RomanNumber.arabicToRoman(5));
        assertEquals("X", RomanNumber.arabicToRoman(10));
        assertEquals("L", RomanNumber.arabicToRoman(50));
        assertEquals("C", RomanNumber.arabicToRoman(100));
        assertEquals("D", RomanNumber.arabicToRoman(500));
        assertEquals("M", RomanNumber.arabicToRoman(1000));
    }

    @Test
    void return_I_when_number_is_one() {
        assertEquals("I", RomanNumber.arabicToRoman(1));
    }

    @Test
    void return_II_when_number_is_two() {
        assertEquals("II", RomanNumber.arabicToRoman(2));
    }

    @Test
    void return_III_when_number_is_three() {
        assertEquals("III", RomanNumber.arabicToRoman(3));
    }

    @Test
    void return_IV_when_number_is_four() {
        assertEquals("IV", RomanNumber.arabicToRoman(4));
    }

    @Test
    void return_V_when_number_is_five() {
        assertEquals("V", RomanNumber.arabicToRoman(5));
    }

    @Test
    void return_VI_when_number_is_six() {
        assertEquals("VI", RomanNumber.arabicToRoman(6));
    }

    @Test
    void return_VI_when_number_is_seven() {
        assertEquals("VII", RomanNumber.arabicToRoman(7));
    }

    @Test
    void return_VI_when_number_is_eight() {
        assertEquals("VIII", RomanNumber.arabicToRoman(8));
    }

    @Test
    void return_VI_when_number_is_nine() {
        assertEquals("IX", RomanNumber.arabicToRoman(9));
    }

    @Test
    void return_X_when_number_is_ten() {
        assertEquals("X", RomanNumber.arabicToRoman(10));
    }

    @Test
    void return_XI_when_number_is_eleven() {
        assertEquals("XI", RomanNumber.arabicToRoman(11));
    }

    @Test
    void return_XIV_when_number_is_fourteen() {
        assertEquals("XIV", RomanNumber.arabicToRoman(14));
    }

    @Test
    void return_XV_when_number_is_fifteen() {
        assertEquals("XV", RomanNumber.arabicToRoman(15));
    }

    @Test
    void return_XVI_when_number_is_sixteen() {
        assertEquals("XVI", RomanNumber.arabicToRoman(16));
    }

    @Test
    void return_XXIV_when_number_is_twentyfour() {
        assertEquals("XXIV", RomanNumber.arabicToRoman(24));
    }

    @Test
    void return_XLIX_when_number_is_fourtynine() {
        assertEquals("XLIX", RomanNumber.arabicToRoman(49));
    }

    @Test
    void return_LI_when_number_is_fiftyone() {
        assertEquals("LI", RomanNumber.arabicToRoman(51));
    }

    @Test
    void return_LVI_when_number_is_fiftysix() {
        assertEquals("LVI", RomanNumber.arabicToRoman(56));
    }

    @Test
    void return_LX_when_number_is_sixty() {
        assertEquals("LX", RomanNumber.arabicToRoman(60));
    }

    @Test
    void return_LXX_when_number_is_seventy() {
        assertEquals("LXX", RomanNumber.arabicToRoman(70));
    }

    @Test
    void return_LXXX_when_number_is_eighty() {
        assertEquals("LXXX", RomanNumber.arabicToRoman(80));
    }

    @Test
    void return_LXXXI_when_number_is_eightyone() {
        assertEquals("LXXXI", RomanNumber.arabicToRoman(81));
    }

    @Test
    void return_LXXXI_when_number_is_eightyfive() {
        assertEquals("LXXXV", RomanNumber.arabicToRoman(85));
    }

    @Test
    void return_LXXXVI_when_number_is_eightysix() {
        assertEquals("LXXXVI", RomanNumber.arabicToRoman(86));
    }

    @Test
    void return_XC_when_number_is_ninety() {
        assertEquals("XC", RomanNumber.arabicToRoman(90));
    }

    @Test
    void return_XCV_when_number_is_ninetyfive() {
        assertEquals("XCV", RomanNumber.arabicToRoman(95));
    }

    @Test
    void return_XCIX_when_number_is_ninetynine() {
        assertEquals("XCIX", RomanNumber.arabicToRoman(99));
    }

    @Test
    void return_CXXVI_when_number_is_onehundredandtwentysix() {
        assertEquals("CXXVI", RomanNumber.arabicToRoman(126));
    }

    @Test
    void return_CD_when_number_is_fourhundred() {
        assertEquals("CD", RomanNumber.arabicToRoman(400));
    }

    @Test
    void return_CM_when_number_is_ninehundred() {
        assertEquals("CM", RomanNumber.arabicToRoman(900));
    }

    @Test
    void return_MMDVII_when_number_is_twothousandandfivehundredandseven() {
        assertEquals("MMDVII", RomanNumber.arabicToRoman(2507));
    }

    @Test
    void thorw_runtimeexception_when_number_is_lower_or_equal_than_0_or_greater_or_equal_than_4000() {
        assertThrows(RuntimeException.class, () -> RomanNumber.arabicToRoman(0));
        assertThrows(RuntimeException.class, () -> RomanNumber.arabicToRoman(4000));
    }
}