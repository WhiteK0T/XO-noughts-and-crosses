package ru.whitek0t.xo;

import ru.whitek0t.xo.model.Field;
import ru.whitek0t.xo.model.Figure;
import ru.whitek0t.xo.model.Game;
import ru.whitek0t.xo.model.Player;
import ru.whitek0t.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        String name1 = "Леша";
        String name2 = "Таня";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game gameXO = new Game(players, new Field(3, 3, 3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }
}
