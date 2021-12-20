package edu1;

public class StateSmoothRoad implements ChangeableDistance {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("Oohh, it is smooth road, we are at max speed!");
        if (seiler.getSpeed() < seiler.getMaxSpeed()) {
            seiler.setSpeed(seiler.getMaxSpeed());
        }
        if (distance -seiler.getSpeed() <= 0) {
            distance = 0;
        } else {
            distance = distance - seiler.getSpeed();
        }
        return distance;
    }
}
