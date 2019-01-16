package com.ocr.mlenoir;

import java.util.Scanner;

class Order {
    private Scanner sc = new Scanner(System.in);

    /**
     * Run asking process for several menus.
     */
    void runMenus() {

    }

    /**
     * Run asking process for a menu.
     */
    void runMenu() {
        int selectedMenu, selectedSide, selectedDrink;

        this.displayAvailableMenu();

        selectedMenu = this.sc.nextInt();

        this.displaySelectedMenu(selectedMenu);

        switch (selectedMenu) {
            case 1:
                this.displayAvailableSide(true);

                selectedSide = this.sc.nextInt();

                this.displaySelectedSide(true, selectedSide);

                this.displayAvailableDrink();

                selectedDrink = this.sc.nextInt();

                this.displaySelectedDrink(selectedDrink);

                break;
            case 2:
                this.displayAvailableSide(true);

                selectedSide = this.sc.nextInt();

                this.displaySelectedSide(true, selectedSide);

                break;
            case 3:
                this.displayAvailableSide(false);

                selectedSide = this.sc.nextInt();

                this.displaySelectedSide(false, selectedSide);

                this.displayAvailableDrink();

                selectedDrink = this.sc.nextInt();

                this.displaySelectedDrink(selectedDrink);

                break;
            default:
                break;
        }
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
     * @param selectedMenu The selected menu.
     */
    void displaySelectedMenu(int selectedMenu) {
        String selectedMenuSentence = "Vous avez choisi comme menu : ";

        switch (selectedMenu) {
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
     * Display all available sides depending on all sides enable or not.
     *
     * - All sides = Vegetables, fries or rice.
     * - No all sides = Rice or not.
     *
     * @param enableAllSides Enable display for all side or not.
     */
    private void displayAvailableSide(boolean enableAllSides) {
        System.out.println("Choix accompagnement");

        if (enableAllSides) {
            System.out.println("1 - Légumes frais");
            System.out.println("2 - Frites");
            System.out.println("3 - Riz");
        } else {
            System.out.println("1 - Riz");
            System.out.println("2 - Aucun accompagnement");
        }

        System.out.println("Que souhaitez-vous comme accompagnement ?");
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
     * Display all available drinks in the restaurant.
     */
    private void displayAvailableDrink() {
        System.out.println("Choix boisson");
        System.out.println("1 - Eau plate");
        System.out.println("2 - Eau gazeuse");
        System.out.println("3 - Soda");
        System.out.println("Que souhaitez-vous comme boisson");
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
