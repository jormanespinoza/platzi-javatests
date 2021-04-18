package com.platzi.javatests.util;

import org.junit.jupiter.api.Test;

import static com.platzi.javatests.util.PasswordUtil.SecurityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    void weakWhenHasLessThan8caracters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("develop"));
    }

    @Test
    void weakWhenHasOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("developer"));
    }

    @Test
    void mediumWhenHasLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("developer25"));
    }

    @Test
    void strongWhenHasLettersNumbersAnsSymbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("developer25!"));
    }
}