package ru.whitek0t.xo.model;

import org.junit.Test;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {
    @Test
    public void testGetSizeX() throws Exception {
        final Field field = new Field(3, 4, 3);

        assertEquals(3, field.getSizeX());
    }

    @Test
    public void testGetSizeY() throws Exception {
        final Field field = new Field(3, 4, 3);

        assertEquals(4, field.getSizeY());
    }

    @Test
    public void testGetNumWinnerFigure() throws Exception {
        final Field field = new Field(3, 4, 3);

        assertEquals(3, field.getNumWinnerFigure());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(field.getSizeX() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field(3, 4, 3);
        final Point inputPoint = new Point(0, field.getSizeY() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}