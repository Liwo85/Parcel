package box;

import java.math.BigDecimal;

public class PurchasedItem {
    private double width;
    private double height;
    private double weight;
    private double deep;
    private BigDecimal price;
    private double volume;

    public PurchasedItem(double width, double height, double deep, double weight, BigDecimal price) {
        this.width = width;
        this.height = height;
        this.deep = deep;
        this.weight = weight;
        this.price = price;
        this.volume = height * width * deep;
    }


    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDeep() {
        return deep;
    }

    public void setDeep(double deep) {
        this.deep = deep;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
