package edu1;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public class City {
    private Cities city;

    public City() {
        setCity();
    }

    public Cities getCity() {
        return city;
    }

    public void setCity() {
        Random rnd = new Random();
        List<Cities> citiesList = new ArrayList<>(EnumSet.allOf(Cities.class));
        int random = rnd.nextInt(citiesList.size());
        this.city = citiesList.get(random);
    }
}
