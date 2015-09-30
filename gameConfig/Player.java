package gameConfig;

import javafx.scene.paint.Color;

public class Player {

    private int number;
    private String name;
    private Race race;
    private Color color;

    private int money;
    private int food;
    private int energy;
    private int ore;

    //array of Land owned?
    public int landGrants;
    private int numLand;
    private int score;

    private int turnsTaken; //TODO

    public Player (int number, String name, Race race, Color color) {
        this.number = number;
        this.name = name;
        this.race = race;
        this.color = color;

        turnsTaken = 0;
        landGrants = 2;

        if (Controller.level.equals("Beginner")){
            food = 8;
            energy = 4;
        } else {
            food = 4;
            energy = 2;
        }

        if (this.race.equals(Race.FLAPPER)) {
            money = 1600;
        } else if (this.race.equals(Race.HUMAN)) {
            money = 600;
        } else {
            money = 1000;
        }

    }

    public enum Race {
        FLAPPER, BONZOID, UGAITE, BUZZITE, HUMAN
    }

    public int getNumber() {return number;}
    public String getName() {return name;}
    public Race getRace() {return race;}
    public int getLandGrants() {return landGrants;}


    public Color getColor() {return color;}

    public int getScore() {
        score = money + (500 * numLand) + (30 * food) + (25 * energy) + (50 * ore);
        return score;
    }

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

    public void gamble(int timeLeft) {
        System.out.println(name + " has chosen to gamble at the Pub with " + timeLeft + " seconds left.");
        int r = Turns.rounds;

        int rb = 0; // round bonus
        if (r <= 3) { // rounds 1 - 3
            rb = 50;
        } else if (r <= 7) { // rounds 4 - 7
            rb = 100;
        } else if (r <= 11) { // rounds 5 - 11
            rb = 150;
        } else { // round 12
            rb = 200;
        }
        System.out.println("Round Bonus: " + rb);

        int tb = 0; //time bonus
        if (timeLeft < 12) { // time left = 0-11 seconds
            tb = 50;
        } else if (timeLeft < 25) { // time left = 12-24 seconds
            tb = 100;
        } else if (timeLeft < 37) { // time left = 25-36 seconds
            tb = 150;
        } else { // time left = 37-50 seconds
            tb = 200;
        }
        System.out.println("Time Bonus: " + tb);

        //money bonus = round bonus * random(0 to timebonus)
        //randomNum = minimum + (int)(Math.random()*maximum);
        int mb = rb * ((int)(Math.random() * tb)); //money bonus
        if (mb > 250) {
            mb = 250;
        }
        System.out.println("Money Bonus: " + mb);
        money += mb;
    }
    
}
