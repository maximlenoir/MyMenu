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
    void Given_ChickenInStandardInput_When_RunMenu_Then_DisplayCorrectProcess() {
        String comparison = "Vous avez choisi comme menu : Poulet\n";

        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        this.order = new Order();
        this.order.runMenu();

        String output = this.outContent.toString().replace("\r\n", "\n");

        assertTrue(output.endsWith(comparison));
        assertTrue(output.length() > comparison.length());
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
}
