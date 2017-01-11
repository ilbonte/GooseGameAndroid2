package com.xp.goose_game;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AcceptanceTest {

    private GameEngine engine;

    @Before
    public void setUp() throws Exception {
        engine = new GameEngine();
    }

    @Test
    public void
    adds_two_players() throws Exception {

        engine.action("aggiungi giocatore Pippo");

        assertEquals("Giocatori: Pippo", engine.state());

        engine.action("aggiungi giocatore Pluto");

        assertEquals("Giocatori: Pippo, Pluto", engine.state());
    }

    @Test
    public void
    adds_repeating_player() throws Exception {

        engine.action("aggiungi giocatore Pippo");

        assertEquals("Giocatori: Pippo", engine.state());

        engine.action("aggiungi giocatore Pippo");

        assertEquals("Pippo: giocatore già presente", engine.state());
    }

    
}