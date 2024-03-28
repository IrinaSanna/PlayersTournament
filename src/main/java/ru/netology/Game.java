package ru.netology;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public Player register(Player player) { //  метод регистрации игрока
        players.add(player);
        return player;
    }

    private int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок: " + playerName1 + "не зарегистрирован"
            );
        }

        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок: " + playerName2 + "не зарегистрирован"
            );
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }


    public Player findByName(String names) { // поиск информации об игроке
        for (Player player : players) {
            if (player.getName().equals(names)) {
                return player;
            }
        }
        return null;
    }
}