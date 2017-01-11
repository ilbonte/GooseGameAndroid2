package com.xp.goose_game;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameEngineTest {

    @Test
    public void add_player_to_game() throws Exception {
        GameEngine engine = new GameEngine();

        engine.action("aggiungi giocatore Pippo");

        assertEquals("Giocatori: Pippo", engine.state());
    }

    @Test
    public void add_two_players_to_game() throws Exception {
        GameEngine engine = new GameEngine();

        engine.action("aggiungi giocatore Pippo");
        engine.action("aggiungi giocatore Pluto");

        assertEquals("Giocatori: Pippo, Pluto", engine.state());
    }


    @Test
    public void adds_repeating_player() throws Exception {
        GameEngine engine = new GameEngine();

        engine.action("aggiungi giocatore Pippo");
        engine.action("aggiungi giocatore Pippo");

        assertEquals("Pippo: giocatore già presente", engine.state());
    }
}