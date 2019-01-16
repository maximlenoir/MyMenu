package com.ocr.mlenoir;

import java.util.Scanner;

class Order {
    private Scanner sc = new Scanner(System.in);

    /**
     * Run asking process for several menus.
     */
    void runMenus() {
        int menuQuantity;

        System.out.println("Combien de menu souhaitez-vous commander ?");

        menuQuantity = this.sc.nextInt();

        for (int i = 0; i < menuQuantity; i++) {
            this.runMenu();
        }
    }

    /**
     * Run asking process for a menu.
     */
    void runMenu() {
        int selectedMenu, selectedSide, selectedDrink;

        this.displayAvailableMenu();

        do {
            selectedMenu = this.sc.nextInt();

            this.displaySelectedMenu(selectedMenu);

            switch (selectedMenu) {
                case 1:
                    this.displayAvailableSide(true);

                    do {
                        selectedSide = this.sc.nextInt();

                        this.displaySelectedSide(true, selectedSide);
                    } while (selectedSide < 1 || selectedSide > 3);

                    this.displayAvailableDrink();

                    do {
                        selectedDrink = this.sc.nextInt();

                        this.displaySelectedDrink(selectedDrink);
                    } while (selectedDrink < 1 || selectedDrink > 3);

                    break;
                case 2:
                    this.displayAvailableSide(true);

                    do {
                        selectedSide = this.sc.nextInt();

                        this.displaySelectedSide(true, selectedSide);
                    } while (selectedSide < 1 || selectedSide > 3);

                    break;
                case 3:
                    this.displayAvailableSide(false);

                    do {
                        selectedSide = this.sc.nextInt();

                        this.displaySelectedSide(false, selectedSide);
                    } while (selectedSide < 1 || selectedSide > 2);

                    this.displayAvailableDrink();

                    do {
                        selectedDrink = this.sc.nextInt();

                        this.displaySelectedDrink(selectedDrink);
                    } while (selectedDrink < 1 || selectedDrink > 3);

                    break;
                default:
                    break;
            }
        } while (selectedMenu < 1 || selectedMenu > 3);
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

    /**
     * Display a question about a category in the standard input, get response and display it.
     *
     * @param category   The category of the question.
     * @param responses  Available responses.
     */
    void askSomething(String category, String[] responses) {
        int choice;
        boolean responseIsFalse = true;
        boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));

        System.out.println("Choix " + category);

        for (int i = 0; i < responses.length; i++) {
            System.out.println((i + 1) + " - " + responses[i]);
        }

        System.out.println("Que souhaitez-vous comme " + category + " ?");

        do {
            choice = this.sc.nextInt();

            if (choice >= 1 && choice <= responses.length) {
                responseIsFalse = false;

                System.out.println("Vous avez choisi comme " + category + " : " + responses[choice - 1]);
            } else {
                System.out.println("Vous n'avez pas choisi d" + (isVowel ? "' " : "e ") + category + " parmi les choix proposés");
            }
        } while (responseIsFalse);
    }
}
