package com.ocr.mlenoir;

class Order {
    /**
     * Display all available menus in the restaurant.
     */
    void displayAvailableMenu() {
        System.out.println("Choix menu");
        System.out.println("1 - Poulet");
        System.out.println("2 - Boeuf");
        System.out.println("3 - Végétarien");
        System.out.println("Que souhaitez-vous comme menu ?");
    }

    /**
     * Display a selected menu.
     * 
     * @param nbMenu The selected menu.
     */
    void displaySelectedMenu(int nbMenu) {
        System.out.println("Vous avez choisi le menu " + nbMenu);
    }
}
