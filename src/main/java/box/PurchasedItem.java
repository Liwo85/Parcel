package box;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class PurchasedItem {
//    private final double width;
//    private final double height;
//    private final double deep;

    List<Double> size = new LinkedList<>();

    private final double weight;
    private final BigDecimal price;
    private List<ParcelSize> sortedParcelList;


    public PurchasedItem(double width, double height, double deep, double weight, BigDecimal price) {
//        this.width = width;
//        this.height = height;
//        this.deep = deep;
        size.add(width);
        size.add(height);
        size.add(deep);
        size.sort(Comparator.comparing(Double::doubleValue));
//        Collections.sort(size);
        this.weight = weight;
        this.price = price;
    }

//    public double getWidth() {
//        return width;
//    }
//
//    public double getHeight() {
//        return height;
//    }

    public double getWeight() {
        return weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double longestDimension() {
        return size.get(2);
    }

    public double shortestDimension() {
        return size.get(0);
    }

    public double middleDimension() {
        return size.get(1);
    }

//    private boolean isForSmallBox() {
//        return ParcelSize.SMALLBOX.longestDimension() >= longestDimension()
//                && ParcelSize.SMALLBOX.middleDimension() >= middleDimension()
//                && ParcelSize.SMALLBOX.shortestDimension() >= shortestDimension();
//    }
//
//    private boolean isForMediumBox() {
//        return ParcelSize.MEDIUMBOX.longestDimension() >= longestDimension()
//                && ParcelSize.MEDIUMBOX.middleDimension() >= middleDimension()
//                && ParcelSize.MEDIUMBOX.shortestDimension() >= shortestDimension();
//    }
//
//    private boolean isForLargeBox() {
//        return ParcelSize.LARGEBOX.longestDimension() >= longestDimension()
//                && ParcelSize.LARGEBOX.middleDimension() >= middleDimension()
//                && ParcelSize.LARGEBOX.shortestDimension() >= shortestDimension();
//    }

    public List<ParcelSize> sizeParcelEngine() {
        return getParcelSize().stream()
                .filter(this::sizeCheck)
                .collect(Collectors.toList());

//        if (isForSmallBox()) {
//            return 1;
//        } else {
//            if (isForMediumBox()) {
//                return 2;
//            } else {
//                if (isForLargeBox()) {
//                    return 3;
//                } else {
//                    return 0;
//                }
//            }
//        }
    }

    private boolean sizeCheck(ParcelSize p) {
        if (p.shortestDimension() < shortestDimension()) {
            return false;
        } else if (p.middleDimension() < middleDimension()) {
            return false;
        } else if (p.longestDimension() < longestDimension()) {
            return false;
        }
        return true;
    }

    public List<ParcelSize> weightCheck() {
        return getParcelSize().stream()
                .filter(p -> p.getWeight() >= getWeight())
                .collect(Collectors.toList());
//        if (ParcelSize.SMALLBOX.getWeight() >= getWeight()) {
//            return 1;
//        } else {
//            if (ParcelSize.MEDIUMBOX.getWeight() >= getWeight()) {
//                return 2;
//            } else {
//                if (ParcelSize.LARGEBOX.getWeight() >= getWeight()) {
//                    return 3;
//                } else {
//                    return 0;
//                }
//            }
//        }
    }

    private List<ParcelSize> getParcelSize() {
        if (sortedParcelList == null) {
            sortedParcelList = Arrays.stream(ParcelSize.values())
                    .sorted(Comparator.comparing(ParcelSize::getPrice))
                    .collect(Collectors.toList());
        }
        return sortedParcelList;
    }

    public ParcelSize findCheapestParcel() throws Exception {
        List<ParcelSize> parcelSizes = sizeParcelEngine();

        List<ParcelSize> weights = weightCheck();

        if (parcelSizes.isEmpty() && weights.isEmpty()) {
            throw new Exception("Nie można przesłać przedmiotu, zbyt duża waga " + getWeight() + "kg, a jego wymiary przekraczają maksymalny rozmiar.");
        }

        if (weights.isEmpty()) {
            throw new Exception("Nie można przesłać przedmiotu, zbyt duża waga " + getWeight() + "kg. ");
        }

        if (parcelSizes.isEmpty()) {
            throw new Exception("Przedmiot jest za duży. Nie mieści się do żadnego opakowania.");
        }

        var common = new LinkedList<>(parcelSizes);
        common.retainAll(weights);
        if (common.isEmpty()) {
            throw new Exception("Nie ma odpowiedniej paczki nie spełniono kryterium wagowego albo rozmiarowego");
        }

        return common.get(0);


//        if ((weightCheck() == 0 || weightCheck() > 3) && (sizeParcelEngine() == 0 || sizeParcelEngine() > 3)) {
//            return "Nie można przesłać przedmiotu, zbyt duża waga " + getWeight() + "kg, a jego wymiary przekraczają maksymalny rozmiar. ";
//        }else {
//            if (sizeParcelEngine() == 0 || sizeParcelEngine() > 3) {
//                return "Przedmiot jest za duży. Nie mieści się do żadnego opakowania.";
//            }else{
//                if (weightCheck() == 0 || weightCheck() > 3) {
//                    return "Nie można przesłać przedmiotu, zbyt duża waga " + getWeight() + "kg. ";
//                }
//            }
//        }
//        if (weightCheck() == 1 && sizeParcelEngine() == 1) {
//            return "Paczka typu Smallbox. ";
//        } else {
//            if (weightCheck() <= 2 && weightCheck() > 0 && sizeParcelEngine() == 2) {
//                return "Paczka typu Mediumbox. ";
//            } else {
//                if (weightCheck() <= 3 && weightCheck() > 0 && sizeParcelEngine() == 3) {
//                    return "Paczka typu Largebox. ";
//                }
//            }
//        }
//        return "";
    }

//    public BigDecimal price() {
//        if (weightCheck() == 1 && sizeParcelEngine() == 1) {
//            return ParcelSize.SMALLBOX.getPrice().add(getPrice());
//        } else {
//            if (weightCheck() <= 2 && weightCheck() > 0 && sizeParcelEngine() == 2) {
//                return ParcelSize.MEDIUMBOX.getPrice().add(getPrice());
//            } else {
//                if (weightCheck() <= 3 && weightCheck() > 0 && sizeParcelEngine() == 3) {
//                    return ParcelSize.LARGEBOX.getPrice().add(getPrice());
//                }
//            }
//        }
//        return BigDecimal.ZERO;
//    }
}