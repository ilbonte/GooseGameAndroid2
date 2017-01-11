package com.xp.goose_game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by XPeppers on 11/01/2017.
 */
public class CommandParserTest {
    @Test
    public void add_player_input_returns_add_player_command() throws Exception {
        CommandParser commandParser = new CommandParser();
        String userInput = "aggiungi giocatore Pippo";

        assertEquals(Command.addPlayer,commandParser.parse(userInput));
    }
}