package com.xp.goose_game;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameEngine {

    private List<Player> players;

    private String state;

    public GameEngine() {
        this.players = new ArrayList<>();
    }

    public void action(String input) {
        CommandParser commandParser = new CommandParser(input);
        Command command = commandParser.parse(input);

        switch (command){
            case addPlayer:
                Player player = new Player (commandParser.parseName());
                if(players.contains(player)){
                    this.state = player.getName()+": giocatore già presente";
                }else{
                    players.add(player);
                    this.state = "Giocatori:" + printPlayers();
                }
                break;
            case movePlayer:
                Player player2 = getPlayerFromName(commandParser.parseName());
                int diceValues [] = commandParser.parseDice();
                player2.move(diceValues[0], diceValues[1]);
                String lastMovesText="";
                if(player2.getPosition()==63){
                    lastMovesText = " "+player2.getName()+" vince!";
                }
                this.state = "Pippo tira "+ diceValues[0]+", "+ diceValues[1]+". Pippo muove da "+player2.getPreviousPosition()+" a "+player2.getPosition()+"."+lastMovesText;
                break;
            case invalid:
                break;
        }

    }

    private Player getPlayerFromName(String name) {
        Player foundPlayer = null;
        for(Player player : players){
            if(player.getName().equals(name)){
                foundPlayer = player;
                break;
            }
        }
        return foundPlayer;
    }



    public String state() {
        return this.state;
    }

    private String printPlayers() {
        String playerList= "";
        for (Player player: players){
            playerList+=" "+player.getName()+",";
        }
        return playerList.substring(0, playerList.length()-1);
    }
}
