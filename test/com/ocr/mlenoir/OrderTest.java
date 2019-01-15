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
}
