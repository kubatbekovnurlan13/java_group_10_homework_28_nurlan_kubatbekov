package edu1;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class StateRain implements ChangeableDistance, ChangeableQuality {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        changeQuality(seiler);
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("It's hard to go fast, raining.");
        int currentSpeed = seiler.getSpeed();
        seiler.setSpeed(currentSpeed - 2);
        if (distance - seiler.getSpeed() <= 0) {
            distance = 0;
        } else {
            distance = distance - seiler.getSpeed();
        }
        return distance;
    }

    @Override
    public void changeQuality(Seiler seiler) {
        Random rnd = new Random();
        int random = rnd.nextInt(10) + 1;
        if (random == 1 || random == 2 || random == 3) {
            int randomProductNumber = rnd.nextInt(seiler.getProductList().size());
            double currentQuality = seiler.getProductList().get(randomProductNumber).getProductQuality().getValue();

            try {
                List<ProductQuality> productQualityList = JsonSerializer.getProductQuality();
                for (int i = 0; i < productQualityList.size(); i++) {
                    if (i == productQualityList.size() - 1) {
                        System.out.println("It is already the worth quality!");
                    } else if (productQualityList.get(i).getValue() == currentQuality) {
                        seiler.getProductList().get(randomProductNumber).setProductQuality(productQualityList.get(i + 1));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}