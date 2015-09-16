package gameConfig;

import javafx.scene.paint.Color;

public class Player {

    private int number;
    private String name;
    private Race race;
    private Color color;
    private int location; //figure out

    private int money;
    private int food;
    private int energy;
    private int ore;

    public Player (int number, String name, Race race, Color color) {
        this.number = number;
        this.name = name;
        this.race = race;
        this.color = color;

//say beginner/standard/tournament
    }

    public enum Race {
        FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
    }

    //public enum Location {}

    public String getName() {
        return name;
    }

    public Color getColor(){
        return color;
    }


}
