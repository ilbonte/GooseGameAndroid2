package com.xp.goose_game;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameEngineTest {
    @Test
    public void add_player_to_game() throws Exception {
        GameEngine engine = new GameEngine();

        engine.action("aggiungi giocatore Pippo");

        assertEquals("Giocatori: Pippo", engine.state());
    }
}