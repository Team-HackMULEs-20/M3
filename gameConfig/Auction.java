package gameConfig;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Auction {

    public Stage auctionStage;
    private static int startingBid;
    public static int landNotTaken;
    public static int numBids;
    public static Land[] auctionLand;
    public static int currentLand;

    public Auction() {
        startingBid = Land.getBuyPrice() / 2;
        numBids = 0;
        landNotTaken = 44;
    }

    /**
     * @return auctionTime the boolean value if it is time to auction or not
     */
    // AUCTIONING
    public static boolean isAuctionTime() {
        boolean auctionTime = false;
        int count = 0;
        for (Land[] item : Controller.landPlots) {
            for (Land plot : item) {
                if (plot.isOwned()) {
                    landNotTaken--;
                    auctionLand[count] = plot;
                    count++;
                }
            }
        }
        if (landNotTaken < Controller.numPlayer) {
            auctionTime = true;
        }
        return auctionTime;
    }

    /**
     *
     */
    public void startAuction() {
        auctionStage = new Stage();
        try {
            Parent selectPhase = FXMLLoader.load(getClass().getResource("UIFiles/AuctionWindow.fxml"));
            Scene auctionScene = new Scene(selectPhase);
            auctionStage.setScene(auctionScene);
            auctionStage.setTitle(Turns.getTurn().getName());
            auctionStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Player p: Controller.players) {
            auctionStage.setTitle(p.getName() + "'s Turn");
            auctionStage.showAndWait();
        }
    }

    /**
     *
     * @param p the player to place bid one
     * @param bidAmount the amount to bid
     */
    public void placeBid(Player p, int bidAmount) {
        Land plot = getCurrentLandAuction();
        if (bidAmount > startingBid && p.getMoney() > bidAmount) {
            startingBid = bidAmount;
            GameController.currentBidLabel.setText("Current Bid is: " + startingBid);
            numBids++;
            plot.setBidder(p);
        }
    }

    /**
     *
     * @return Player that was the last bidder
     */
    public static Player getLastBidder() {
        return Land.latestBidder;
    }

    /**
     *
     * @param plot the land plot buy
     * @param p player that won the bid
     */
    public static void giveLandToBidder(Land plot, Player p) {
        plot.buyLand(p);
    }

    /**
     *
     * @return Land that is currently being auctioned
     */
    private static Land getCurrentLandAuction() {
        return auctionLand[currentLand - 1];
    }
}
