package ru.whitek0t.xo.view;

import ru.whitek0t.xo.controller.CurrentMoveController;
import ru.whitek0t.xo.controller.MoveController;
import ru.whitek0t.xo.controller.WinnerController;
import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;
import ru.whitek0t.xo.model.Game;
import ru.whitek0t.xo.model.exceptions.AlreadyOccupiedException;
import ru.whitek0t.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    final String templateLine = "%2s | %s | %s";

    final Scanner in = new Scanner(System.in);

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();


    public void show(final Game game) {
        System.out.printf("Game name: %s\n", game.getName());
        final Field field = game.getField();
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0 )
                System.out.println(generateSeparator(11, '~'));
            System.out.println(generateLine(field, y));
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.printf("Winner is: %s\n", winner);
            return  false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.printf("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoit();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoit() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.printf("Please input %s:", coordinateName);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("olololo!!!");
            in.next();
            return askCoordinate(coordinateName);
        }
    }

    String generateLine(final Field field, final int y) {
        if ((y > field.getSize() - 1) | y < 0 | field == null) {
            throw new RuntimeException();
        }
        String[] figureArray = new String[field.getSize()];
        for (int x = 0; x < field.getSize(); x++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
                figureArray[x] = figure != null ? String.valueOf(figure) : " ";
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return String.format(templateLine, figureArray);
    }

    String generateSeparator(int n, char ch) {
        if (n < 1) {
            throw new RuntimeException();
        }
        StringBuilder result = new StringBuilder(n + 5);
        for (int i = 0; i < n; i++) {
            result.append(ch);
        }
        return result.toString();
    }
}
