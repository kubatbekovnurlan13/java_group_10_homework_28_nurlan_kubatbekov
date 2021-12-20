package edu1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class StateRoadsideInn implements ChangeableDistance, ChangeableMoney, ChangeableProducts {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        changeMoney(seiler);
        return distance;
    }

    @Override
    public void changeMoney(Seiler seiler) {
        int lodgingMoney = 2000;
        if (seiler.getStartMoney() > lodgingMoney) {
            System.out.println("We spend part of the money on food and accommodation.");
            int currentMoney = seiler.getStartMoney();
            seiler.setStartMoney(currentMoney - lodgingMoney);
            changeProducts(seiler);
        } else {
            System.out.println("We are rested but not staying, no money.");
        }
    }

    @Override
    public void changeProducts(Seiler seiler) {

        Random rnd = new Random();
        if (rnd.nextInt(2) + 1 == 1) {
            int randomProductNumber = rnd.nextInt(seiler.getProductList().size());
            int price = seiler.getProductList().get(randomProductNumber).getStartPrice();
            double soldPrice = price * seiler.getProductList().get(randomProductNumber).getProductQuality().getValue();
            int currentMoney = seiler.getStartMoney();
            seiler.setStartMoney((int) (currentMoney + soldPrice));
            System.out.println("Sold the product: " + seiler.getProductList().get(randomProductNumber).getTypeOfProduct());
            seiler.getProductList().remove(randomProductNumber);
        } else {
            try {
                List<Product> productList = JsonSerializer.getProducts();
                int randomProductNumber = rnd.nextInt(productList.size());
                Product product = productList.get(randomProductNumber);
                if (seiler.getStartMoney() >= product.getStartPrice() && seiler.getLiftingCapacity() >= product.getWeght()) {
                    seiler.getProductList().add(product);
                    System.out.println("You bought: " + product.getTypeOfProduct());
                } else {
                    System.out.println("Shopping is over.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
