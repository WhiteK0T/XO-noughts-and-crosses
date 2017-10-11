package ru.whitek0t.xo.model;

import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final int fieldSize;

    private final Figure[][] field;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
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
        return cheakCoordinate(point.x, field.length) && cheakCoordinate(point.y, field[point.x].length);
    }

    private boolean cheakCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
