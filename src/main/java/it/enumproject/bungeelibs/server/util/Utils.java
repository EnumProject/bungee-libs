package it.enumproject.bungeelibs.server.util;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static int chance() {
        return random.nextInt(100) + 10;
    }

}