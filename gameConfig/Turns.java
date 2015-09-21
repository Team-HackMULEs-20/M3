package gameConfig;

public class Turns {
    public static Player[] players;
    public static int rounds;
    public static int timeOfTurn;

    public Turns(Player[] players) {
        this.players = players;
        rounds = 1;
    }

    public static Player getNextTurn() {
        return players[0];
    }

    public static int timeForTurn(Player player) {
        int foodCount = player.getFood();
        if (foodCount == 0) {
            timeOfTurn = 5;
        } else {
            if (rounds >= 1 && rounds <= 4) {
                if (foodCount < 3) {
                    timeOfTurn = 30;
                } else {
                    timeOfTurn = 50;
                }
            } else if (rounds >= 5 && rounds <= 8) {
                if (foodCount < 4) {
                    timeOfTurn = 30;
                } else {
                    timeOfTurn = 50;
                }
            } else if (rounds >= 9 && rounds <= 12) {
                if (foodCount < 5) {
                    timeOfTurn = 30;
                } else {
                    timeOfTurn = 50;
                }
            }
        }
        System.out.println(timeOfTurn);
        return timeOfTurn;
    }

}
