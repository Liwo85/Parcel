package box;

import java.math.BigDecimal;
import java.util.Scanner;

public class TransportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rozmiar przedmiotu: ");
        double h = scanner.nextDouble();
        System.out.println("Podaj rozmiar przedmiotu: ");
        double w= scanner.nextDouble();
        System.out.println("Podaj rozmiar przedmiotu: ");
        double d = scanner.nextDouble();
        System.out.println("Podaj wagę przedmiotu: ");
        double weight = scanner.nextDouble();
        System.out.println("Podaj cenę przedmiotu: ");
        BigDecimal price = scanner.nextBigDecimal();
        PurchasedItem purchasedItem = new PurchasedItem(h,w,d,weight,price);
        System.out.println(purchasedItem.getPrice());





    }
}
