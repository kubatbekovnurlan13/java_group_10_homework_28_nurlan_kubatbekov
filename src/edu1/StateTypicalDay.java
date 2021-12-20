package edu1;

public class StateTypicalDay implements ChangeableDistance {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("Typical day nothing happened.");
        if (distance - seiler.getSpeed() <= 0) {
            distance = 0;
        } else {
            distance = distance - seiler.getSpeed();
        }
        return distance;
    }
}
