package ru.whitek0t.xo.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCoordinateReader implements ICoordinateReader{

    private final Scanner in = new Scanner(System.in);

    @Override
    public int nextInt(final String coordinateName) {
        System.out.printf("Please input %s:", coordinateName);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("olololo!!!");
            in.next();
            return nextInt(coordinateName);
        }
    }

    @Override
    public String next() {
        return in.next();
    }
}
