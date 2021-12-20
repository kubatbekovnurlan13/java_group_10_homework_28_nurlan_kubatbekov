package edu1;

public class StateWheelBroken implements ChangeableDistance {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("The wheel broken, empty day, we are stuck.");
        return distance;
    }
}
