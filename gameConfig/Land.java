package gameConfig;

public class Land {
    private Player owner;
    private boolean owned;
    private int row;
    private int col;

    // private hasMule //TODO
    // private numMule //If a mule is on the property when sold, it is lost

    public Land(int row, int col) {
        this.row = row;
        this.col = col;
        owned = false;
    }

    public int getRow() {return row;}
    public int getCol() {return col;}

    public Player getOwner() {return owner;}

    public void buyLand(Player p) {
        int price = 300 + Turns.rounds;
        owner = p;
        owned = true;

        /*
        The selling price is 400 + random(0-200).
        You may also buy property if any is available from the land office. The buying price is 300 + round * random(0-100).
         */
    }

    public void sellLand() {
        if (owner.getLocation() == Player.Location.LANDOFFICE) {
            int sellPrice = 400 + (int)(Math.random() * 200); //randomNum = minimum + (int)(Math.random()*maximum);
            owner = null;
            owned = false;
        } else {
            System.out.println("Need to be in Land office"); //create error that says this? TODO
        }


    }

    public boolean isOwned() {return owned;}
}
