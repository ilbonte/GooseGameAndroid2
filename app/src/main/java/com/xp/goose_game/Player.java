package com.xp.goose_game;

/**
 * Created by XPeppers on 11/01/2017.
 */

class Player {

    private final String name;

    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return name != null ? name.equals(player.name) : player.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int firstDistance, int secondDistance) {
        this.position+=firstDistance+secondDistance;
    }
}