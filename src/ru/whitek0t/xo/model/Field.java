package ru.whitek0t.xo.model;

import ru.whitek0t.xo.model.exceptions.AlreadyOccupiedException;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private static final int MIN_COORDINATE = 0;

    private static final int MAX_COORDINATE = FIELD_SIZE;

    private final Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return cheakCoordinate(point.x) && cheakCoordinate(point.y);
    }

    private boolean cheakCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}
