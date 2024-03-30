package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldFirstPlayerNotRegistered() {
        Game games = new Game();
        Player player = new Player(1, "Master", 10);

        games.register(player);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Den", "Monster");
        });
    }

    @Test
    public void shouldSecondPlayerNotRegistered() {
        Game games = new Game();

        Player player = new Player(1, "Master", 10);
        Player player1 = new Player(2, "Sergio", 50);

        games.register(player);
        games.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Sergio", "Piter");
        });
    }

    @Test
    public void shouldWinnerFirstPlayer() { // победитель первый игрок
        Game games = new Game();

        Player player1 = new Player(2, "Sergio", 50);
        Player player2 = new Player(3, "Monster", 30);

        games.register(player1);
        games.register(player2);

        int expected = 1;
        int actual = games.round("Sergio", "Monster");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinnerSecondPlayer() { // победитель второй игрок
        Game games = new Game();

        Player player1 = new Player(2, "Sergio", 50);
        Player player2 = new Player(3, "Monster", 100);

        games.register(player1);
        games.register(player2);

        int expected = 2;
        int actual = games.round("Sergio", "Monster");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayersHaveDraw() { // у игроков ничья
        Game games = new Game();

        Player player1 = new Player(2, "Sergio", 100);
        Player player2 = new Player(3, "Monster", 100);

        games.register(player1);
        games.register(player2);

        int expected = 0;
        int actual = games.round("Sergio", "Monster");

        Assertions.assertEquals(expected, actual);
    }
}