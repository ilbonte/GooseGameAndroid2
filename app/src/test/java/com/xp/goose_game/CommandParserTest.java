package com.xp.goose_game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by XPeppers on 11/01/2017.
 */
public class CommandParserTest {
    @Test
    public void add_player_input_returns_add_player_command() throws Exception {
        String userInput = "aggiungi giocatore Pippo";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals(Command.addPlayer,commandParser.getCommand());
    }

    @Test
    public void move_player_input_returns_move_player_command() throws Exception {
        String userInput = "muovi Pippo 4, 2";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals(Command.movePlayer,commandParser.getCommand());
    }

    @Test
    public void invalid_command_is_detected() throws Exception {
        String userInput = "invalid command";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals(Command.invalid,commandParser.getCommand());
    }

    @Test
    public void can_extract_name_from_add_player_command() throws Exception {
        String userInput = "aggiungi giocatore Pippo";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals("Pippo",commandParser.parseName());
    }

    @Test
    public void can_extract_name_from_move_player_command() throws Exception {
        String userInput = "muovi Pippo 4, 2";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals("Pippo",commandParser.parseName());
    }

    @Test
    public void can_extract_dice_from_move_command() throws Exception {
        String userInput = "muovi Pippo 4, 2";
        CommandParser commandParser = new CommandParser(userInput);

        assertEquals(4,commandParser.parseDice()[0]);
        assertEquals(2,commandParser.parseDice()[1]);

    }

}