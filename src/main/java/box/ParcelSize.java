package box;

import java.math.BigDecimal;

public enum ParcelSize {

    SMALLBOX(380,640,80,25,new BigDecimal("12.99")),
    MEDIUMBOX(380,640,190,25,new BigDecimal("13.99")),
    LARGEBOX(340,640,410,25,new BigDecimal("15.49"));


    private final double width;
    private final double height;
    private final double weight;
    private final double deep;
    private final BigDecimal price;

    ParcelSize(double width, double height, double deep, double weight, BigDecimal price) {
        this.width = width;
        this.height = height;
        this.deep = deep;
        this.weight = weight;
        this.price = price;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getDeep() {
        return deep;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
