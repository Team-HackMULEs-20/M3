package gameConfig;

public class Land {
    private Player owner;
    private boolean owned;
    private int row;
    private int col;

    public Land(int row, int col) {
        this.row = row;
        this.col = col;
        owned = false;
    }

    public int getRow() {return row;}
    public int getCol() {return col;}

    public Player getOwner() {return owner;}

    public void buyLand(Player p) {

        owner = p;
        owned = true;

        /*
        The land office buys and sells property. If a player wishes to sell a property during their turn, they may enter the land office and offer a property to sell. If a mule is on the property when sold, it is lost. The selling price is 400 + random(0-200). You may also buy property if any is available from the land office. The buying price is 300 + round * random(0-100).
         */
    }

    public void sellLand() {

        owner = null;
        owned = false;
    }

    public boolean isOwned() {return owned;}
}
