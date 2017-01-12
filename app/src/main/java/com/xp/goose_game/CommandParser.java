package com.xp.goose_game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XPeppers on 11/01/2017.
 */

public class CommandParser {

    private static final String ADD_PLAYER_COMMAND = "aggiungi giocatore \\w+";

    private static final String MOVE_PLAYER_COMMAND = "muovi (\\w+) (\\d), (\\d)";
    private final Command command;

    private String parsedName;
    private int parsedDiceValues [] = null;

    public CommandParser(String command){
        this.command = this.parse(command);
    }

    public Command parse(String input) {

        if(input.matches(ADD_PLAYER_COMMAND)) {
            this.parsedName = input.replace("aggiungi giocatore ", "");

            return Command.addPlayer;
        }

        if(input.matches(MOVE_PLAYER_COMMAND)) {
            this.parsedName = parseNameFromMoveCommand(input);
            this.parsedDiceValues = parseDiceFromMoveCommand(input);
            return Command.movePlayer;
        }

        return Command.invalid;
    }

    private int[] parseDiceFromMoveCommand(String input) {
        Pattern p = Pattern.compile(MOVE_PLAYER_COMMAND);
        Matcher m = p.matcher(input);
        m.find();
        return new int[]{Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))};
    }

    private String parseNameFromMoveCommand(String input) {
        Pattern p = Pattern.compile(MOVE_PLAYER_COMMAND);
        Matcher m = p.matcher(input);
        m.find();
        return m.group(1);
    }


    public Command getCommand() {
        return command;
    }

    public String parseName() {
        return this.parsedName;
    }

    public int[] parseDice() {
        return this.parsedDiceValues;
    }
}
