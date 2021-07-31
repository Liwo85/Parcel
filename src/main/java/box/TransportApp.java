package box;

import java.math.BigDecimal;
import java.util.Scanner;

public class TransportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Przedmiot składa się z trzech wymiarów. Wymiary można podawać w dowolnej kolejności.");
        System.out.println("Podaj pierszy wymiar przedmiotu: ");
        double h = scanner.nextDouble();
        System.out.println("Podaj drugi wymiar przedmiotu: ");
        double w= scanner.nextDouble();
        System.out.println("Podaj trzeci wymiar przedmiotu: ");
        double d = scanner.nextDouble();
        System.out.println("Podaj wagę przedmiotu w kilogramach: ");
        double weight = scanner.nextDouble();
        System.out.println("Podaj cenę przedmiotu: ");
        BigDecimal price = scanner.nextBigDecimal();
        PurchasedItem purchasedItem = new PurchasedItem(h,w,d,weight,price);
        System.out.println(purchasedItem.finalAnswer() + purchasedItem.price());

    }
}
