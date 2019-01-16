package com.ocr.mlenoir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Order order = new Order();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(this.outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void Given_Chicken_When_DisplaySelectedMenu_Then_DisplayChickenSentence() {
        this.order.displaySelectedMenu(1);

        assertEquals("Vous avez choisi comme menu : Poulet\n", this.outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_Beef_When_DisplaySelectedMenu_Then_DisplayBeefSentence() {
        this.order.displaySelectedMenu(2);

        assertEquals("Vous avez choisi comme menu : Boeuf\n", this.outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_Vegetarian_When_DisplaySelectedMenu_Then_DisplayVegetarianSentence() {
        this.order.displaySelectedMenu(3);

        assertEquals("Vous avez choisi comme menu : Végétarien\n", this.outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_TooBigValue_When_DisplaySelectedMenu_Then_DisplayErrorSentence() {
        this.order.displaySelectedMenu(5);

        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", this.outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_NegativeValue_When_DisplaySelectedMenu_Then_DisplayErrorSentence() {
        this.order.displaySelectedMenu(-6);

        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", this.outContent.toString().replace("\r\n", "\n"));
    }

    @Test
    void Given_AllSidesEnabledAndVegetables_When_DisplaySelectedSide_Then_DisplayVegetablesSentence() {
        this.order.displaySelectedSide(true, 1);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme accompagnement : Légumes frais\n", output);
    }

    @Test
    void Given_AllSidesEnabledAndFries_When_DisplaySelectedSide_Then_DisplayFriesSentence() {
        this.order.displaySelectedSide(true, 2);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme accompagnement : Frites\n", output);
    }

    @Test
    void Given_AllSidesEnabledAndRice_When_DisplaySelectedSide_Then_DisplayRiceSentence() {
        this.order.displaySelectedSide(true, 3);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme accompagnement : Riz\n", output);
    }

    @Test
    void Given_AllSidesEnabledAndBadValue_When_DisplaySelectedSide_Then_DisplayErrorSentence() {
        this.order.displaySelectedSide(true, 5);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés\n", output);
    }

    @Test
    void Given_AllSidesDisabledAndRice_When_DisplaySelectedSide_Then_DisplayRiceSentence() {
        this.order.displaySelectedSide(false, 1);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme accompagnement : Riz\n", output);
    }

    @Test
    void Given_AllSidesDisabledAndNoSide_When_DisplaySelectedSide_Then_DisplayNotRiceSentence() {
        this.order.displaySelectedSide(false, 2);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi de ne pas prendre d'accompagnement\n", output);
    }

    @Test
    void Given_AllSidesDisabledAndBadValue_When_DisplaySelectedSide_Then_DisplayErrorSentence() {
        this.order.displaySelectedSide(false, 5);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés\n", output);
    }

    @Test
    void Given_Water_When_DisplaySelectedDrink_Then_DisplayWaterSentence() {
        this.order.displaySelectedDrink(1);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme boisson : Eau\n", output);
    }

    @Test
    void Given_SparklingWater_When_DisplaySelectedDrink_Then_DisplaySparklingWaterSentence() {
        this.order.displaySelectedDrink(2);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme boisson : Eau gazeuse\n", output);
    }

    @Test
    void Given_Soda_When_DisplaySelectedDrink_Then_DisplaySodaSentence() {
        this.order.displaySelectedDrink(3);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous avez choisi comme boisson : Soda\n", output);
    }

    @Test
    void Given_BadValue_When_DisplaySelectedDrink_Then_DisplayErrorSentence() {
        this.order.displaySelectedDrink(5);

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertEquals("Vous n'avez pas choisi de boisson parmi les choix proposés\n", output);
    }

    @Test
    void Given_ChickenWithFriesAndSodaInStandardInput_When_RunMenu_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("1\n2\n3\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Poulet", output[5]);
        assertEquals("Vous avez choisi comme accompagnement : Frites", output[11]);
        assertEquals("Vous avez choisi comme boisson : Soda", output[17]);
    }

    @Test
    void Given_BeefWithVegetablesInStandardInput_When_RunMenu_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("2\n1\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Boeuf", output[5]);
        assertEquals("Vous avez choisi comme accompagnement : Légumes frais", output[11]);
    }

    @Test
    void Given_VegetarianWithNoSideAndSparklingWaterInStandardInput_When_RunMenu_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("3\n2\n2\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Végétarien", output[5]);
        assertEquals("Vous avez choisi de ne pas prendre d'accompagnement", output[10]);
        assertEquals("Vous avez choisi comme boisson : Eau gazeuse", output[16]);
    }

    @Test
    void Given_OneMenu_ChickenWithFriesAndSoda_InStandardInput_When_RunMenus_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("1\n1\n2\n3\n".getBytes()));

        this.order = new Order();
        this.order.runMenus();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Poulet", output[6]);
        assertEquals("Vous avez choisi comme accompagnement : Frites", output[12]);
        assertEquals("Vous avez choisi comme boisson : Soda", output[18]);
    }

    @Test
    void Given_TwoMen_BeefWithVegetables_VegetarianWithNoSideAndSparklingWater_InStandardInput_When_RunMenus_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("2\n2\n1\n3\n2\n2\n".getBytes()));

        this.order = new Order();
        this.order.runMenus();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Boeuf", output[6]);
        assertEquals("Vous avez choisi comme accompagnement : Légumes frais", output[12]);
        assertEquals("Vous avez choisi comme menu : Végétarien", output[18]);
        assertEquals("Vous avez choisi de ne pas prendre d'accompagnement", output[23]);
        assertEquals("Vous avez choisi comme boisson : Eau gazeuse", output[29]);
    }

    @Test
    void Given_BadMenu_When_RunMenu_Then_ReAskMenu() {
        System.setIn(new ByteArrayInputStream("4\n1\n2\n3\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés", output[5]);
        assertEquals("Vous avez choisi comme menu : Poulet", output[6]);
    }

    @Test
    void Given_ChickenWithBadSideAndBadDrink_When_RunMenu_Then_ReAskSideAndDrink() {
        System.setIn(new ByteArrayInputStream("1\n4\n2\n-1\n3\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Poulet", output[5]);
        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés", output[11]);
        assertEquals("Vous avez choisi comme accompagnement : Frites", output[12]);
        assertEquals("Vous n'avez pas choisi de boisson parmi les choix proposés", output[18]);
        assertEquals("Vous avez choisi comme boisson : Soda", output[19]);
    }

    @Test
    void Given_BeefWithBadSide_When_RunMenu_Then_ReAskSide() {
        System.setIn(new ByteArrayInputStream("2\n4\n2\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Boeuf", output[5]);
        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés", output[11]);
        assertEquals("Vous avez choisi comme accompagnement : Frites", output[12]);
    }

    @Test
    void Given_VegetarianWithBadSideAndBadDrink_When_RunMenu_Then_ReAskSideAndDrink() {
        System.setIn(new ByteArrayInputStream("3\n3\n2\n-1\n3\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Végétarien", output[5]);
        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés", output[10]);
        assertEquals("Vous avez choisi de ne pas prendre d'accompagnement", output[11]);
        assertEquals("Vous n'avez pas choisi de boisson parmi les choix proposés", output[17]);
        assertEquals("Vous avez choisi comme boisson : Soda", output[18]);
    }

    @Test
    void Given_BadResponseAndResponse1_When_AskAboutCarWithThreeResponses_Then_DisplayErrorAndGoodResponse() {
        System.setIn(new ByteArrayInputStream("5\n1\n".getBytes()));

        this.order = new Order();

        String[] responses = {"BMW", "Audi", "Mercedes"};

        this.order.askSomething("voiture", responses);

        String[] output = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertTrue(output[0].contains("voiture"));
        assertEquals("Vous n'avez pas choisi de voiture parmi les choix proposés", output[5]);
        assertEquals("Vous avez choisi comme voiture : BMW", output[6]);
    }

    @Test
    void Given_Chicken_When_AskAboutMenu_Then_DisplayChickenChoice() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        this.order = new Order();
        this.order.askMenu();

        String output[] = this.outContent.toString().replace("\r\n", "\n").split("\n");

        assertEquals("Vous avez choisi comme menu : Poulet", output[5]);
    }
}
