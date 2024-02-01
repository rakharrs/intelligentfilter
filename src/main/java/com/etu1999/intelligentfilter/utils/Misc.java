package com.etu1999.intelligentfilter.utils;

import java.util.regex.Pattern;

public class Misc {
    public static boolean isStringNumeric(String str) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return str == null ? false : pattern.matcher(str).matches();
    }
}
