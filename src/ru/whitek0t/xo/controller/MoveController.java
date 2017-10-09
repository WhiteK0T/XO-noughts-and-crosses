package ru.whitek0t.xo.controller;

import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;
import ru.whitek0t.xo.model.exceptions.AlreadyOccupiedException;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field , final Figure figure , final Point point) throws AlreadyOccupiedException,
                                                                                                InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
