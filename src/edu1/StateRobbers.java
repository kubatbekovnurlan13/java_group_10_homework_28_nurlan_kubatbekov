package edu1;

import java.io.IOException;
import java.util.List;

public class StateRobbers implements ChangeableDistance, ChangeableProducts, ChangeableMoney {
    @Override
    public int startMethod(int distance, Seiler seiler) {
        changeMoney(seiler);
        return changeDistance(distance, seiler);
    }

    @Override
    public int changeDistance(int distance, Seiler seiler) {
        System.out.println("Barely bought off the robbers.");
        return distance;
    }

    @Override
    public void changeMoney(Seiler seiler) {
        if (seiler.getStartMoney() > 0) {
            seiler.setStartMoney(0);
            System.out.println("Huu, bought off the robbers, " +
                    "gave all the money that I have.");
        } else {
            changeProducts(seiler);
        }
    }

    @Override
    public void changeProducts(Seiler seiler) {
        for (int i = 0; i < seiler.getProductList().size(); i++) {
            try {
                List<ProductQuality> productQualityList = JsonSerializer.getProductQuality();
                double bestQuality = productQualityList.get(0).getValue();
                if (seiler.getProductList().get(i).getProductQuality().getValue() == bestQuality) {
                    System.out.println("Bought off, give them: " + seiler.getProductList().get(i).getTypeOfProduct());
                    seiler.getProductList().remove(i);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
