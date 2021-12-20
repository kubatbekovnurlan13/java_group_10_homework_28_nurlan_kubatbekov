package edu1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        System.out.println();
        Seiler seiler = getSeiler();
        Cities randomCity = getRandomCity();
        int distance = getDistance();
        System.out.println("");

        System.out.println("We are going to: " + randomCity);
        System.out.println("Initial Distance: " + distance);

        boolean checker = true;
        int i = 1;
        while (checker) {

            Random rnd = new Random();
            int random = rnd.nextInt(9) + 1;
            System.out.println("--------------------------------------");
            System.out.println("Day: " + i);
            switch (random) {
                case 1:
                    distance = new StateTypicalDay().startMethod(distance, seiler);
                    break;
                case 2:
                    distance = new StateRain().startMethod(distance, seiler);
                    break;
                case 3:
                    distance = new StateSmoothRoad().startMethod(distance, seiler);
                    break;
                case 4:
                    distance = new StateWheelBroken().startMethod(distance, seiler);
                    break;
                case 5:
                    distance = new StateRiver().startMethod(distance, seiler);
                    break;
                case 6:
                    distance = new StateMetLocal().startMethod(distance, seiler);
                    break;
                case 7:
                    distance = new StateRobbers().startMethod(distance, seiler);
                    break;
                case 8:
                    distance = new StateRoadsideInn().startMethod(distance, seiler);
                    break;
                case 9:
                    distance = new StateProductGotBad().startMethod(distance, seiler);
                    break;
            }

            if (distance == 0) {
                checker = false;
            }
            System.out.println("Distance: " + distance);
            i++;
        }
        System.out.println("-----------End of journey!-----------");
        int addedPrice = 0;
        int soldMoney = 0;
        Random rnd = new Random();
        for (int j = 0; j < seiler.getProductList().size(); j++) {
            System.out.println("Name of product; " + seiler.getProductList().get(j).getTypeOfProduct());
            System.out.println("Arrived price: " + seiler.getProductList().get(j).getStartPrice());
            int addPrice = rnd.nextInt(3000) + 2000;
            System.out.println("Sold Price: " + (seiler.getProductList().get(j).getStartPrice() + addPrice));

            soldMoney = soldMoney + seiler.getProductList().get(j).getStartPrice() + addPrice;
            System.out.println("====================================================");

        }

        System.out.println("Start money was: " + seiler.getInitialMoney());
        System.out.println("Sold money is: " + soldMoney);
        System.out.println("Earned: " + (soldMoney - seiler.getInitialMoney()));
    }

    public static int startMoney() {
        Random rnd = new Random();
        int startMoney = rnd.nextInt(100000) + 200000;
        return startMoney;
    }

    public static Seiler getSeiler() {
        int startMoney = startMoney();
        int liftingCapacity = 25;
        int speed = 5;
        Seiler seiler = new Seiler(liftingCapacity, speed, startMoney);
        List<Product> productList = buyProducts(seiler);
        seiler.setProductList(productList);
        return seiler;
    }

    public static List<Product> buyProducts(Seiler seiler) {
        Random rnd = new Random();
        List<Product> productList = getIninialProducts();
        List<Product> seilerProducts = new ArrayList<>();

        boolean checker = true;
        while (checker) {
            int random = rnd.nextInt(productList.size());
            Product product = productList.get(random);
            if (
                    seiler.getStartMoney() >= product.getStartPrice() &&
                            seiler.getLiftingCapacity() >= product.getWeght()
            ) {
                seilerProducts.add(product);

                int remainingMoney = seiler.getStartMoney() - product.getStartPrice();
                seiler.setStartMoney(remainingMoney);
                int remainingLiftingCapacity = seiler.getLiftingCapacity() - product.getWeght();
                seiler.setLiftingCapacity(remainingLiftingCapacity);
            } else {
                System.out.println("Shopping is over. You bougth " + seilerProducts.size() + " things.");
                checker = false;
            }
        }
        return seilerProducts;
    }

    public static int getDistance() {
        Random rnd = new Random();
        return rnd.nextInt(50) + 50;
    }

    public static Cities getRandomCity() {
        City city = new City();
        return city.getCity();
    }

    public static List<Product> getIninialProducts() {
        List<Product> productList = null;
        try {
            productList = JsonSerializer.getProducts();
            List<ProductQuality> productQualityList = JsonSerializer.getProductQuality();
            for (Product p : productList) {
                p.setProductQuality(productQualityList.get(0));
            }
            return productList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}