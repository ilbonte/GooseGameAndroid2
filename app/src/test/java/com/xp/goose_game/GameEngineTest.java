package com.xp.goose_game;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class GameEngineTest {

    GameEngine engine;

    @Before
    public void setUp() throws Exception {
        engine= new GameEngine();
    }

    @Test
    public void add_player_to_game() throws Exception {
        addPlayer("Pippo");

        assertEquals("Giocatori: Pippo", engine.state());
    }

    @Test
    public void add_two_players_to_game() throws Exception {
        addPlayer("Pippo");
        addPlayer("Pluto");

        assertEquals("Giocatori: Pippo, Pluto", engine.state());
    }

    @Test
    public void adds_repeating_player() throws Exception {
        addPlayer("Pippo");
        addPlayer("Pippo");

        assertEquals("Pippo: giocatore già presente", engine.state());
    }

    @Test
    public void move_a_player_from_starting_position() throws Exception {
        addPlayer("Pippo");

        engine.action("muovi Pippo 4, 2");

        assertEquals("Pippo tira 4, 2. Pippo muove da Partenza a 6.", engine.state());
    }

    @Test
    public void move_a_player_from_a_position_to_another_position() throws Exception {
        addPlayer("Pippo");

        engine.action("muovi Pippo 4, 2");

        engine.action("muovi Pippo 2, 3");

        assertEquals("Pippo tira 2, 3. Pippo muove da 6 a 11.", engine.state());
    }

    @Test
    public void player_wins_if_lands_exactly_on_63() throws Exception {
        addPlayer("Pippo");
        engine.action("muovi Pippo 60, 0");

        engine.action("muovi Pippo 1, 2");
        assertEquals("Pippo tira 1, 2. Pippo muove da 60 a 63. Pippo vince!", engine.state());
    }

    private void addPlayer(String playerName){
        engine.action("aggiungi giocatore "+playerName);
    }

}