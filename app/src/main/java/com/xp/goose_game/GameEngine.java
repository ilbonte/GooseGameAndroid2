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
        CommandParser commandParser = new CommandParser();
        Command command = commandParser.parse(input);

        switch (command){
            case addPlayer:
                Player player = new Player (parsePlayer(input));
                if(players.contains(player)){
                    this.state = player.getName()+": giocatore già presente";
                }else{
                    players.add(player);
                    this.state = "Giocatori:" + printPlayers();
                }
                break;
            case movePlayer:
                //TODO: player2 = getPlayerFromName()....
                Player player2 = getPlayerFromName(parseMoveCommand(input));
                int diceValues [] = parseDice(input);
                player2.move(diceValues[0], diceValues[1]);
                this.state = "Pippo tira "+ diceValues[0]+", "+ diceValues[1]+". Pippo muove da "+player2.getPreviousPosition()+" a "+player2.getPosition();
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

    private String parseMoveCommand(String input) {
        Pattern p = Pattern.compile("muovi (\\w+) (\\d), (\\d)");
        Matcher m = p.matcher(input);
        if (m.find()) {
            return m.group(1);
        } else {
            return null;

        }
    }

    private int[] parseDice(String input) {
        Pattern p = Pattern.compile("muovi \\w+ (\\d), (\\d)");
        Matcher m = p.matcher(input);
        if (m.find()) {
             return new int[]{Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))};
        } else {
            return null;
        }
    }

    private String parsePlayer(String input) {
        return input.replace("aggiungi giocatore ", "");
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
