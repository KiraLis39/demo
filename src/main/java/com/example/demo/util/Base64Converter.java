package com.example.demo.util;

import java.util.Base64;

public class Base64Converter {
    public static String encode(String originalMessage) {
        return Base64.getEncoder().encodeToString(originalMessage.getBytes());
    }
    public static String decode(String encodedMessage) {
        return new String(Base64.getDecoder().decode(encodedMessage));
    }
}

