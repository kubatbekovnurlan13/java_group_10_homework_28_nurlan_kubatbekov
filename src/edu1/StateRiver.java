package edu1;

public class StateRiver implements ChangeableDistance{
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("I spent the whole day looking for a ford.");
        return distance;
    }
}
