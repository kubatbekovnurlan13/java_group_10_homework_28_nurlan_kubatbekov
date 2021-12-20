package edu1;

import java.util.Random;

public class StateMetLocal implements ChangeableDistance {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        Random rnd = new Random();
        int random = rnd.nextInt(3) + 1;
        if (random == 1) {
            distance = distance - seiler.getSpeed() - 3;
        } else if (random == 2) {
            distance = distance - seiler.getSpeed() - 4;
        } else {
            distance = distance - seiler.getSpeed() - 6;
        }
        if (distance <= 0) {
            distance = 0;
        }
        System.out.println("Met local so managed to cut off part of the path!");
        return distance;
    }
}
