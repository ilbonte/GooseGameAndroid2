package com.xp.goose_game;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private List<String> players;

    private String state;

    public GameEngine() {
        this.players = new ArrayList<>();
    }

    public void action(String input) {
        String player = parsePlayer(input);
        if(players.contains(player)){
            this.state = player+": giocatore già presente";
        }else{
            players.add(player);
            this.state = "Giocatori: " + printPlayers();
        }


    }

    private String parsePlayer(String input) {
        return input.replace("aggiungi giocatore ", "");
    }

    public String state() {
        return this.state;
    }

    private String printPlayers() {
        return players.toString().replace("[","").replace("]","");
    }
}
