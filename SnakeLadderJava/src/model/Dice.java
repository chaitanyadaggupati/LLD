package model;

import java.util.Random;

public class Dice {
    Integer start=1;
    Integer end=6;

    public Integer rollDIce() {
        Random random = new Random();
        return random.nextInt(end-start)+start;
    }
}
