package com.platzi.javatests.util;

public class StringUtil {

    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        return String.valueOf(str).repeat(Math.max(0, times));
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }
}
