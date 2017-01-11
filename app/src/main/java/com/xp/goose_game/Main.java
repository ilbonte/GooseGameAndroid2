package com.xp.goose_game;


import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        GameEngine engine = new GameEngine();
        while (true) {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            engine.action(input);
            System.out.println(engine.state());
        }
    }
}
