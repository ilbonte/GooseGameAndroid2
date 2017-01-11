package com.xp.goose_game;

public class GameEngine {

    private String players;

    public void action(String input) {
        if(players == null){
            players = parsePlayer(input);
        } else {
            players += ", " + parsePlayer(input);
        }
    }

    private String parsePlayer(String input) {
        return input.replace("aggiungi giocatore ", "");
    }

    public String state() {
        return "Giocatori: " + players;
    }
}
