package com.platzi.javatests.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void testRepeat_threeTimes() {
        assertEquals("DevDevDev", StringUtil.repeat("Dev", 3));
    }

    @Test
    void testRepeat_oneTime() {
        assertEquals("Dev", StringUtil.repeat("Dev", 1));
    }

    @Test
    void testRepeat_zeroTimes() {
        assertEquals("", StringUtil.repeat("Dev", 0));
    }

    @Test
    void testRepeat_negativeTimes() {
        assertThrows(IllegalArgumentException.class, () -> StringUtil.repeat("Dev", -1));
    }

    @Test
    void testIsEmpty_whenNull() {
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    void testIsEmpty_whenBlankString() {
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    void testIsEmpty_whenStringContainsOnlySpaces() {
        assertTrue(StringUtil.isEmpty(" "));
    }

    @Test
    void testIsEmpty_whenStringIsNotEmpty() {
        assertFalse(StringUtil.isEmpty("develop"));
    }
}