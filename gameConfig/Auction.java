package gameConfig;

import javafx.stage.Stage;

/**
 * Created by findleyck on 10/6/15.
 */
public class Auction {

    public Stage auctionStage;
    public static int startingBid;
    public static int landNotTaken;
    public static int numBids;
    public static Land[] auctionLand;
    public static Player bidWinner;
    public static int currentLand;

    public Auction() {
        startingBid = Land.getBuyPrice() / 2;
        numBids = 0;
        landNotTaken = 44;
    }

    // AUCTIONING
    public boolean isAuctionTime() {
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

    public void startAuction() {
        auctionStage = new Stage();
        auctionStage.setScene(Launcher.auctionScene);
        for (Player p: Controller.players) {
            auctionStage.setTitle(p.getName() + "'s Turn");
            auctionStage.showAndWait();
        }
    }

    public void placeBid(Player p, int bidAmount) {
        Land plot = getCurrentLandAuction();
        if (bidAmount > startingBid && p.getMoney() > bidAmount) {
            startingBid = bidAmount;
            GameController.currentBidLabel.setText("Current Bid is: " + startingBid);
            numBids++;
            plot.setBidder(p);
        }
    }

    public static Player getLastBidder() {
        return Land.latestBidder;
    }

    public static void giveLandToBidder(Land plot, Player p) {
        bidWinner = p;
        plot.buyLand(bidWinner);
    }

    public static Land getCurrentLandAuction() {
        return auctionLand[currentLand - 1];
    }
}
