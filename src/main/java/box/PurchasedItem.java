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

    public double longestDimension() {
        return Math.max(this.height, Math.max(this.deep, this.width));
    }

    public double shortestDimension() {
        return Math.min(this.height, Math.min(this.deep, this.width));
    }

    public double middleDimension() {
        return Math.max(Math.min(this.height, this.deep), Math.min(Math.max(this.height, this.deep), this.width));
    }

    private boolean isForSmallBox() {
        return ParcelSize.SMALLBOX.longestDimension() >= longestDimension()
                && ParcelSize.SMALLBOX.middleDimension() >= middleDimension()
                && ParcelSize.SMALLBOX.shortestDimension() >= shortestDimension();
    }

    private boolean isForMediumBox() {
        return ParcelSize.MEDIUMBOX.longestDimension() >= longestDimension()
                && ParcelSize.MEDIUMBOX.middleDimension() >= middleDimension()
                && ParcelSize.MEDIUMBOX.shortestDimension() >= shortestDimension();
    }

    private boolean isForlargeBox() {
        return ParcelSize.LARGEBOX.longestDimension() >= longestDimension()
                && ParcelSize.LARGEBOX.middleDimension() >= middleDimension()
                && ParcelSize.LARGEBOX.shortestDimension() >= shortestDimension();
    }

    public int sizeParcelEngine() {
        if (isForSmallBox()) {
            return 1;
        } else {
            if (isForMediumBox()) {
                return 2;
            } else {
                if (isForlargeBox()) {
                    return 3;
                } else {
                    return 0;
                }
            }
        }
    }

    public int weightCheck() {
        if (ParcelSize.SMALLBOX.getWeight() >= this.weight) {
            return 1;
        } else {
            if (ParcelSize.MEDIUMBOX.getWeight() >= this.weight) {
                return 2;
            } else {
                if (ParcelSize.LARGEBOX.getWeight() >= this.weight) {
                    return 3;
                } else {
                    return 0;
                }
            }
        }
    }

    public String finalAnswer() {
        if (weightCheck() == 0) {
           return "Nie można przesłać przedmiotu, zbyt duża waga " + getWeight();
        }
        if(sizeParcelEngine() == 0){
            return "Przedmiot jest za duży. Nie mieści się do żadnego opakowania.";
        }

        if (weightCheck() == 1 && sizeParcelEngine() == 1) {
            return "Paczka typu Smallbox. ";
        } else {
            if (weightCheck() == 2 && sizeParcelEngine() == 2) {
                return "Paczka typu Mediumbox. ";
            } else {
                if (weightCheck() == 3 && sizeParcelEngine() == 3) {
                    return "Paczka typu Largebox. ";
                }
            }
        }
        return "";
    }

    public BigDecimal price() {
        if (weightCheck() == 1) {
            return ParcelSize.SMALLBOX.getPrice().add(getPrice());
        } else {
            if (weightCheck() == 2) {
                return ParcelSize.MEDIUMBOX.getPrice().add(getPrice());
            } else {
                if (weightCheck() == 3) {
                    return ParcelSize.LARGEBOX.getPrice().add(getPrice());
                }
            }

        }
        return null;
    }
}