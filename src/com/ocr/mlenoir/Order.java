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
        String selectedMenuSentence = "Vous avez choisi le menu : ";

        if (nbMenu == 1) {
            System.out.println(selectedMenuSentence + "Poulet");
        } else if (nbMenu == 2) {
            System.out.println(selectedMenuSentence + "Boeuf");
        } else if (nbMenu == 3) {
            System.out.println(selectedMenuSentence + "Végétarien");
        } else {
            System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
        }
    }
}
