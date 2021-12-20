package edu1;

import java.util.List;

public class Seiler {
    private int liftingCapacity;
    private int speed;
    private int startMoney;
    private int initialMoney;
    private List<Product> productList;
    private final int maxSpeed = 5;
    private final int minSpeed = 1;

    public Seiler(int liftingCapacity, int speed, int startMoney) {
        this.liftingCapacity = liftingCapacity;
        this.speed = speed;
        this.startMoney = startMoney;
        this.initialMoney = startMoney;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getInitialMoney() {
        return initialMoney;
    }

    public int getMinSpeed() {
        return minSpeed;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStartMoney() {
        return startMoney;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStartMoney(int startMoney) {
        this.startMoney = startMoney;
    }
}
