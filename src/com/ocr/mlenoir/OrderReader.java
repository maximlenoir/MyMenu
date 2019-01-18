package com.ocr.mlenoir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OrderReader {
    public static void main(String[] args) {
        OrderReader orderReader = new OrderReader();
        orderReader.read();
    }

    private void read() {
        Path orderFilePath = Paths.get("order.csv");
        List<String> orderLines = null; // null mean no value by default

        try {
            orderLines = Files.readAllLines(orderFilePath);
        } catch (IOException e) {
            System.out.println("Oops! Impossible de lire le fichier des commandes.");
        }

        if (orderLines.size() < 2) {
            System.out.println("Il n'y a pas de commandes dans le fichier.");

            return;
        }

        String[] menus = {"Menu Poulet", "Menu Boeuf", "Menu Végétarien"};
        String[] sides = {" avec des légumes frais", " avec des frites", " avec du riz"};
        String[] vegetarianSides = {" avec du riz", " sans riz"};
        String[] drinks = {" et avec de l'eau plate", " et avec de l'eau gazeuse", " et avec du soda"};

        for (int i = 1; i < orderLines.size(); i++) {
            String[] split = orderLines.get(i).split(",");

            int selectedMenu = Integer.valueOf(split[0]);
            int selectedSide = Integer.valueOf(split[1]);
            int selectedDrink = Integer.valueOf(split[2]);

            String orderLine = menus[selectedMenu - 1];

            // Vegetarian menu
            if (selectedMenu == 3) {
                orderLine = orderLine.concat(vegetarianSides[selectedSide - 1]);
            } else {
                orderLine = orderLine.concat(sides[selectedSide - 1]);
            }

            if (selectedDrink == -1) {
                orderLine = orderLine.concat(" et sans boisson");
            } else {
                orderLine = orderLine.concat(drinks[selectedDrink - 1]);
            }

            System.out.println(orderLine);
        }
    }
}
