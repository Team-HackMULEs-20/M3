package sample;

public class Player {

    int number;
    String name;
    int race;
    String color;

    public Player (int number, String name, int race, String color) {
        this.number = number;
        this.name = name;
        //this.race = race;
        this.color = color;
    }

    public enum Race {
        FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
    }

    public String getName() {
        return name;
    }

    public String getColor(){
        return color;
    }


}
