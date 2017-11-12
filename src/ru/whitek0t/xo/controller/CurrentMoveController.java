package ru.whitek0t.xo.controller;

import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;
import ru.whitek0t.xo.model.exceptions.XOCriticalException;

import java.awt.*;

public class CurrentMoveController {
    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int y = 0; y < field.getSizeY(); y++) {
            countFigure += countFigureInTheRow(field, y);
        }
        if (countFigure == field.getSizeX() * field.getSizeY())
            return null;
        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFigureInTheRow (final Field field, final int row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSizeX(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new XOCriticalException(e);
            }
        }
        return countFigure;
    }
}
