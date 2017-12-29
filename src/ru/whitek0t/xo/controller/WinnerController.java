package ru.whitek0t.xo.controller;

import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    private Figure winnerFigure;

    final IPointGenerator column = p -> new Point(p.x, p.y + 1);
    final IPointGenerator row = p -> new Point(p.x + 1, p.y);
    final IPointGenerator diag1 = p -> new Point(p.x + 1, p.y + 1);
    final IPointGenerator diag2 = p -> new Point(p.x + 1, p.y - 1);

    public Figure getWinner(final Field field) {
        for (int x = 0; x < field.getSizeX(); x++) {
            if (check(field, new Point(x, 0), column))
                return winnerFigure;
            if (check(field, new Point(x, 0), diag1))
                return winnerFigure;
            if (check(field, new Point(x, field.getSizeY() - 1), diag2))
                return winnerFigure;
        }
        for (int y = 0; y < field.getSizeY(); y++) {
            if (check(field, new Point(0, y), row))
                return winnerFigure;
            if (check(field, new Point(0, y), diag1))
                return winnerFigure;
            if (check(field, new Point(0, field.getSizeY() - 1 - y), diag2))
                return winnerFigure;
        }
        return null;
    }

    boolean check(final Field field, final Point beginPoint, final IPointGenerator pointGenerator) {
        if (field == null && beginPoint ==null && pointGenerator == null) {
            throw new RuntimeException();
        }
        Point nextPoint = pointGenerator.next(beginPoint);
        if (beginPoint.x == nextPoint.x && beginPoint.y == nextPoint.y) {
            throw new RuntimeException();
        }

        Figure currentFigure;
        Figure nextFigure;
        Point currentPoint = beginPoint;
        int countFigure = 1;
        int numWinnerFigure = field.getNumWinnerFigure();
        final int endNum = Math.max(field.getSizeX(), field.getSizeY());

        for (int i = 0; i < endNum; i++) {
            try {
                currentFigure = field.getFigure(currentPoint);
                nextFigure = field.getFigure(nextPoint);
                if (currentFigure == null && nextFigure == null) {
                    countFigure = 1;
                    continue;
                }
                if (currentFigure == nextFigure) {
                    countFigure++;
                }else {
                    countFigure = 1;
                }
                if (countFigure == numWinnerFigure) {
                    winnerFigure = currentFigure;
                    return true;
                }
                currentPoint = nextPoint;
                nextPoint = pointGenerator.next(currentPoint);
            } catch (final InvalidPointException e) {
                return false;
            }
        }
        return false;
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }

}
