package com.xp.goose_game;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private List<String> players;

    public GameEngine() {
        this.players = new ArrayList<>();
    }

    public void action(String input) {
        String player = parsePlayer(input);
        players.add(player);
    }

    private String parsePlayer(String input) {
        return input.replace("aggiungi giocatore ", "");
    }

    public String state() {
        return "Giocatori: " + printPlayers();
    }

    private String printPlayers() {
        return players.toString().replace("[","").replace("]","");
    }
}
