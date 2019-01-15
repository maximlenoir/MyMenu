package com.ocr.mlenoir;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Scanner sc = new Scanner(System.in);

        order.displayAvailableMenu();

        int nb = sc.nextInt();

        order.displaySelectedMenu(nb);
    }
}
