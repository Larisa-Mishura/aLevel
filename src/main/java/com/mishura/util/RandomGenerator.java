package com.mishura.util;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();

    public int generateRandomInt(){
        return random.nextInt(10);
    }
}
