package com.ocr.mlenoir;

import java.util.InputMismatchException;
import java.util.Scanner;

class Order {
    String orderSummary = "";

    private Scanner sc = new Scanner(System.in);

    /**
     * Run asking process for several menus.
     */
    void runMenus() {
        this.orderSummary += "Résumé de votre commande :%n";

        int menuQuantity = 0;
        boolean responseIsFalse = true;

        System.out.println("Combien de menu souhaitez-vous commander ?");

        do {
            try {
                menuQuantity = this.sc.nextInt();

                responseIsFalse = false;
            } catch (InputMismatchException e) {
                sc.next();

                System.out.println("Vous devez saisir un nombre, correspondant au nombre de menus souhaités");
            }
        } while (responseIsFalse);

        for (int i = 0; i < menuQuantity; i++) {
            this.orderSummary = this.orderSummary.concat("Menu " + (i + 1)).concat(" :%n");

            this.runMenu();
        }

        System.out.printf(this.orderSummary);
    }

    /**
     * Run asking process for a menu.
     */
    void runMenu() {
        int choice = this.askMenu();

        switch (choice) {
            case 1:
                this.askSide(true);
                this.askDrink();

                break;
            case 2:
                this.askSide(true);

                break;
            case 3:
                this.askSide(false);
                this.askDrink();

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

    /**
     * Display a question about a category in the standard input, get response and display it.
     *
     * @param category   The category of the question.
     * @param responses  Available responses.
     *
     * @return The user's choice.
     */
    int askSomething(String category, String[] responses) {
        int choice = 0;
        boolean responseIsFalse = true;
        boolean isVowel = "aeiouy".contains(Character.toString(category.charAt(0)));

        System.out.println("Choix " + category);

        for (int i = 0; i < responses.length; i++) {
            System.out.println((i + 1) + " - " + responses[i]);
        }

        System.out.println("Que souhaitez-vous comme " + category + " ?");

        do {
            try {
                choice = this.sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }

            if (choice >= 1 && choice <= responses.length) {
                responseIsFalse = false;

                String choiceStr = "Vous avez choisi comme " + category + " : " + responses[choice - 1];

                this.orderSummary = this.orderSummary.concat(choiceStr).concat("%n");

                System.out.println(choiceStr);
            } else {
                System.out.println("Vous n'avez pas choisi d" + (isVowel ? "'" : "e ") + category + " parmi les choix proposés");
            }
        } while (responseIsFalse);

        return choice;
    }

    /**
     * Display a question about menu in standard input, get response and display it.
     *
     * @return The user's choice.
     */
    int askMenu() {
        String[] menus = {"Poulet", "Boeuf", "Végétarien"};

        return this.askSomething("menu", menus);
    }

    /**
     * Display a question about side in the standard input, get response and display it.
     *
     * @param enableAllSides Enable display for all side or not.
     */
    void askSide(boolean enableAllSides) {
        if (enableAllSides) {
            String[] sides = {"Légumes frais", "Frites", "Riz"};
            this.askSomething("accompagnement", sides);
        } else {
            String[] sides = {"Riz", "Pas d'accompagnement"};
            this.askSomething("accompagnement", sides);
        }
    }

    /**
     * Display a question about drink in the standard input, get response and display it.
     */
    void askDrink() {
        String[] drinks = {"Eau plate", "Eau gazeuse", "Soda"};

        this.askSomething("boisson", drinks);
    }
}
