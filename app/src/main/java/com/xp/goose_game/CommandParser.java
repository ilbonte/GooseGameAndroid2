package com.xp.goose_game;

/**
 * Created by XPeppers on 11/01/2017.
 */

public class CommandParser {

    public static final String ADD_PLAYER_COMMAND = "aggiungi giocatore \\w+";

    public static final String MOVE_PLAYER_COMMAND = "muovi \\w+ \\d, \\d";

    public Command parse(String input) {
        if(input.matches(ADD_PLAYER_COMMAND)) {
            return Command.addPlayer;
        }

        if(input.matches(MOVE_PLAYER_COMMAND)) {
            return Command.movePlayer;
        }



        return Command.invalid;
    }
}
