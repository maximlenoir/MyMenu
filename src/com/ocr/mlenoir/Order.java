package com.ocr.mlenoir;

import java.util.Scanner;

class Order {
    /**
     * Run asking process for a menu.
     */
    void runMenu() {
        Scanner sc = new Scanner(System.in);
        int nbMenu;

        this.displayAvailableMenu();

        nbMenu = sc.nextInt();

        this.displaySelectedMenu(nbMenu);
    }

    /**
     * Display all available menus in the restaurant.
     */
    private void displayAvailableMenu() {
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
        String selectedMenuSentence = "Vous avez choisi comme menu : ";

        switch (nbMenu) {
            case 1:
                System.out.println(selectedMenuSentence + "Poulet");

                break;
            case 2:
                System.out.println(selectedMenuSentence + "Boeuf");

                break;
            case 3:
                System.out.println(selectedMenuSentence + "Végétarien");

                break;
            default:
                System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");

                break;
        }
    }

    /**
     * Display a selected side depending on all sides enable or not.
     *
     * - All sides     =  Vegetables, fries or rice.
     * - No all sides  =  Rice or not.
     *
     * @param enableAllSides  Enable display for all side or not.
     * @param selectedSide    The selected side.
     */
    void displaySelectedSide(boolean enableAllSides, int selectedSide) {
        String selectedSideSentence = "Vous avez choisi comme accompagnement : ";
        String errorSentence = "Vous n'avez pas choisi d'accompagnement parmi les choix proposés";

        if (enableAllSides) {
            switch (selectedSide) {
                case 1:
                    System.out.println(selectedSideSentence + "Légumes frais");

                    break;
                case 2:
                    System.out.println(selectedSideSentence + "Frites");

                    break;
                case 3:
                    System.out.println(selectedSideSentence + "Riz");

                    break;
                default:
                    System.out.println(errorSentence);

                    break;
            }
        } else {
            switch (selectedSide) {
                case 1:
                    System.out.println(selectedSideSentence + "Riz");

                    break;
                case 2:
                    System.out.println("Vous avez choisi de ne pas prendre d'accompagnement");

                    break;
                default:
                    System.out.println(errorSentence);

                    break;
            }
        }
    }

    /**
     * Display a selected drink.
     *
     * @param selectedDrink The selected drink.
     */
    void displaySelectedDrink(int selectedDrink) {
        String selectedDrinkSentence = "Vous avez choisi comme boisson : ";

        switch (selectedDrink) {
            case 1:
                System.out.println(selectedDrinkSentence + "Eau");

                break;
            case 2:
                System.out.println(selectedDrinkSentence + "Eau gazeuse");

                break;
            case 3:
                System.out.println(selectedDrinkSentence + "Soda");

                break;
            default:
                System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");

                break;
        }
    }
}
