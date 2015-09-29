package gameConfig;

public class Turns {
    public static Player[] players;
    public static int rounds;
    public static int timeOfTurn;
    public static int playerTurn;

    public Turns(Player[] players) {
        Turns.players = players;
        rounds = 1;
        playerTurn = 1;
    }

    public static Player getTurn() {
        if (playerTurn > players.length) {
            rounds++;
            /*if (GameController.numBids == 1) {
                Land.buyLand(players[playerTurn]);
            }*/
            GameController.numBids = 0;
            if (GameController.numPasses != players.length) {
                GameController.numPasses = 0;
            }
            playerTurn = 1;
            Turns.sortByScore();
            System.out.println("Next Round");
            if (GameController.isAuctionTime()) {
                GameController.startAuction();
            }
        }
        return players[playerTurn - 1];
    }

    public static void sortByScore() {
        for (int i = 0; i < players.length - 1; i++) {
            if (players[i].getScore() > players[i + 1].getScore()) {
                Player temp = players[i + 1];
                players[i + 1] = players[i];
                players[i] = temp;
            }
        }
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
        return timeOfTurn;
    }
}
