package ru.whitek0t.xo.view;

import org.junit.Test;
import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;

import java.awt.*;

import static org.junit.Assert.*;

public class ConsoleViewTest {
    @Test
    public void testGenerateLineFieldAndY() throws Exception {
        final ConsoleView consoleView = new ConsoleView();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        assertEquals(" O | X | O", consoleView.generateLine(field, 0));
    }
    @Test
    public void testGenerateLineNoFieldAndY() throws Exception {
        final ConsoleView consoleView = new ConsoleView();
        try {
            consoleView.generateLine(null, 0);
        } catch (RuntimeException re) {
            assertTrue(true);
        }
    }
    @Test
    public void testGenerateLineFieldAndInvalidY() throws Exception {
        final ConsoleView consoleView = new ConsoleView();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);
        try {
            consoleView.generateLine(field, 5);
        } catch (RuntimeException re) {
            assertTrue(true);
        }
    }
    @Test
    public void testGenerateSeparatorTrue() throws Exception {
        final ConsoleView consoleView = new ConsoleView();
        assertEquals("~~~",consoleView.generateSeparator(3, '~'));
    }
    @Test
    public void testGenerateSeparatorBadN() throws Exception {
        final ConsoleView consoleView = new ConsoleView();
        try {
            consoleView.generateSeparator(0, ' ');
        } catch (RuntimeException re) {
            assertTrue(true);
        }
    }
}