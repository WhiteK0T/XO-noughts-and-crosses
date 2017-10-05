package ru.whitek0t.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String inputValue = "Lexa";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actualValue = player.getName();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getFigure() throws Exception {
        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);
    }

}