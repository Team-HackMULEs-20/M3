package gameConfig;

import javafx.scene.paint.Color;

public class Player {

    private int number;
    private String name;
    private Race race;
    private Color color;
    //private int location; //figure out

    private int money;
    private int food;
    private int energy;
    private int ore;

    private int turnsTaken;

    public Player (int number, String name, Race race, Color color) {
        this.number = number;
        this.name = name;
        this.race = race;
        this.color = color;

        turnsTaken = 0;

//say beginner/standard/tournament
    }

    public enum Race {
        FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
    }

    //public enum Location {}

    public int getNumber() {return number;}

    public String getName() {return name;}

    public Race getRace() {return race;}

    public Color getColor() {return color;}
    
    public int getMoney() {return money;}
    public void addSubMoney(int amount) {money += amount;}

    public int getFood() {return food;}
    public void addSubFood(int amount) {food += amount;}

    public int getEnergy() {return energy;}
    public void addSubEnergy(int amount) {energy += amount;}

    public int getOre() {return ore;}
    public void addSubOre(int amount) {ore += amount;}

    public int getTurnsTaken() {return turnsTaken;}
    public void incTurnsTaken() {turnsTaken++;}

}
