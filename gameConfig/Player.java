package gameConfig;

public class Player {

    private int number;
    private String name;
    private int race;
    private String color;
    private int location; //figure out

    private int money;
    private int food;
    private int energy;
    private int ore;

    public Player (int number, String name, int race, String color) {
        this.number = number;
        this.name = name;
        this.race = race; //how to import?
        this.color = color;

//say beginner/standard/tournament
    }

    public enum Race {
        FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
    }

    public enum Location {

    }

    public String getName() {
        return name;
    }

    public String getColor(){
        return color;
    }


}
