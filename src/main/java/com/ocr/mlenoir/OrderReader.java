package com.ocr.mlenoir;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class OrderReader {
    public static void main(String[] args) {
        OrderReader orderReader = new OrderReader();
        orderReader.read();
    }

    private void read() {
        String[] menus = {"Menu Poulet", "Menu Boeuf", "Menu Végétarien"};
        String[] sides = {" avec des légumes frais", " avec des frites", " avec du riz"};
        String[] vegetarianSides = {" avec du riz", " sans riz"};
        String[] drinks = {" et avec de l'eau plate", " et avec de l'eau gazeuse", " et avec du soda"};

        try {
            Reader orderFileReader = new FileReader("order.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(orderFileReader);

            for (CSVRecord record : records) {
                int selectedMenu = Integer.valueOf(record.get("menu"));
                int selectedSide = Integer.valueOf(record.get("side"));
                int selectedDrink = Integer.valueOf(record.get("drink"));

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
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Impossible de trouver le fichier de commandes 'order.csv'.");
        } catch (IOException e) {
            System.out.println("Oops! Une erreur est survenue durant la lecture du fichier de commandes 'order.csv'.");
        }
    }
}
