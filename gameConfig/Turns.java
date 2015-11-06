package GameConfig;

import java.io.Serializable;

public class Turns implements Serializable {
    private static Player[] players;
    public static int rounds;
    public static int timeOfTurn;
    public static int playerTurn;

    public Turns(Player[] players) {
        Turns.players = players;
        rounds = 1;
        playerTurn = 1;
    }

    public void setRounds(int round) {
        rounds = round;
    }

    /**
     *
     * @return player whose turn it is
     */
    public static Player getTurn() {
        if (playerTurn > players.length) {
            rounds++;
            if (Auction.numBids == 1) {
                System.out.println("one bid on current plot");
                Player p = Auction.getLastBidder();
                Auction.giveLandToBidder(Auction.auctionLand[Auction.currentLand], p);
            }
            Auction.numBids = 0;
            if (GameController.numPasses != players.length) {
                GameController.numPasses = 0;
            }
            playerTurn = 1;
            Turns.sortByScore();
            System.out.println("Next Round");
        }
        return players[playerTurn - 1];
    }

    public static void sortByScore() {
        for (int i = 0; i < players.length; i++) {
            int min = i;
            for (int j = i + 1; j < players.length; j++) {
                if (players[min].getScore() > players[j].getScore()) {
                    min = j;
                } else if (players[min].getScore() == players[j].getScore()) {
                    min = j;
                }
            }
            Player temp = players[i];
            players[i] = players[min];
            players[min] = temp;
        }
    }

    /**
     *
     * @param player the player whose turn it is
     * @return timeOfTurn the int representing the time of turn
     */
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
