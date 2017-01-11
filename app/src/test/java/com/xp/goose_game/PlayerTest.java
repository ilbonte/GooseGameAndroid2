package com.xp.goose_game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by XPeppers on 11/01/2017.
 */
public class PlayerTest {

    @Test
    public void can_create_a_player() throws Exception {
        Player player = new Player("Pippo");
        assertEquals("Pippo", player.getName());
        assertEquals(0, player.getPosition());
    }

    @Test
    public void players_with_same_name_is_the_same_player() throws Exception {
        Player player = new Player("Pippo");
        Player clone = new Player("Pippo");
        assertEquals(true, player.equals(clone));
    }

    @Test
    public void players_with_different_name_are_different_players() throws Exception {
        Player player = new Player("Pippo");
        Player player2 = new Player("Pluto");
        assertEquals(false, player.equals(player2));
    }

    @Test
    public void move_player_from_starting_position() throws Exception {
        Player player = new Player("Pippo");
        player.move(4,2);
        assertEquals(6, player.getPosition());
    }

    @Test
    public void move_player_from_a_position_to_another_position() throws Exception {
        Player player = new Player("Pippo");
        player.move(4,2);
        player.move(4,2);
        assertEquals(12, player.getPosition());
    }

    @Test
    public void get_previous_position_as_text() throws Exception {
        Player player = new Player("Pippo");
        player.move(4,2);
        assertEquals("Partenza", player.getPreviousPosition());
    }
}