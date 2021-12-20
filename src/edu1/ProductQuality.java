package edu1;

public class ProductQuality {
    private String qualityName;
    private double value;

    public ProductQuality(String qualityName, double value) {
        this.qualityName = qualityName;
        this.value = value;
    }

    public String getCoefName() {
        return qualityName;
    }

    public double getValue() {
        return value;
    }
}
