package com.trycloud.utilities;

import com.github.javafaker.Faker;

public class BrowserUtil {

    public static void waitFor(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

    }
    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }


}
