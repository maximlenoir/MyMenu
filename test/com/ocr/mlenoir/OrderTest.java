package com.ocr.mlenoir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    void Given_Nothing_When_DisplayAvailableMenu_Then_ShouldDisplayAvailableMenu() {
        this.order.displayAvailableMenu();

        assertFalse(outContent.toString().isEmpty());
    }
    
    @Test
    void Given_Vegetarian_When_AskForMenuSelected_Then_ShouldDisplayCorrectSentence() {
        this.order.displaySelectedMenu(3);

        assertEquals("Vous avez choisi le menu 3\n", outContent.toString().replace("\r\n", "\n"));
    }
}
