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

    @Test
    public void moves_a_player() throws Exception {

        engine.action("aggiungi giocatore Pippo");

        engine.action("muovi Pippo 4, 2");


        engine.action("muovi Pippo 2, 3");

        assertEquals("Pippo tira 2, 3. Pippo muove da 6 a 11.", engine.state());
    }

    @Test
    public void player_can_win() throws Exception {
        engine.action("aggiungi giocatore Pippo");
        engine.action("muovi Pippo 60, 0");

        engine.action("muovi Pippo 1, 2");
        assertEquals("Pippo tira 1, 2. Pippo muove da 60 a 63. Pippo vince!", engine.state());
    }

    @Test
    public void player_bounce_at_the_end_of_the_trail() throws Exception {
        engine.action("aggiungi giocatore Pippo");
        engine.action("muovi Pippo 60, 0");

        engine.action("muovi Pippo 3, 2");
        assertEquals("Pippo tira 3, 2. Pippo muove da 60 a 63. Pippo Rimbalza! Pippo torna a 61", engine.state());
    }
}