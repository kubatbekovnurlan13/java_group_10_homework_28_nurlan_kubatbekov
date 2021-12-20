package edu1;

public class Product {
    private int startPrice;
    private String typeOfProduct;
    private int weght;
    private ProductQuality productQuality;
    private String desc;

    public Product(
            int startPrice,
            String typeOfProduct,
            int weght,
            String desc) {
        this.startPrice = startPrice;
        this.typeOfProduct = typeOfProduct;
        this.weght = weght;
        this.desc = desc;
    }

    public void setProductQuality(ProductQuality productQuality) {
        this.productQuality = productQuality;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public int getWeght() {
        return weght;
    }

    public ProductQuality getProductQuality() {
        return productQuality;
    }

    public String getDesc() {
        return desc;
    }
}