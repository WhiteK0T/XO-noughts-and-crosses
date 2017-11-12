package ru.whitek0t.xo.model;

import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final int numWinnerFigure;

    private final int fieldSizeX;

    private final int fieldSizeY;

    private final Figure[][] field;

    public Field(int fieldSizeX, int fieldSizeY, int numWinnerFigure) {
        this.fieldSizeX = fieldSizeX < 3 ? 3 : fieldSizeX;
        this.fieldSizeY = fieldSizeY < 3 ? 3 : fieldSizeY;
        this.numWinnerFigure = numWinnerFigure < 3 ? 3 : numWinnerFigure ;
        this.field = new Figure[this.fieldSizeX][this.fieldSizeY];
    }

    public int getSizeX() {
        return fieldSizeX;
    }

    public int getSizeY() {
        return fieldSizeY;
    }

    public int getNumWinnerFigure() {
        return numWinnerFigure;
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
        return cheakCoordinate(point.x, fieldSizeX) && cheakCoordinate(point.y, fieldSizeY);
    }

    private boolean cheakCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
