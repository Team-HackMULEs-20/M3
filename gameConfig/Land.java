package gameConfig;

public class Land {
    private Player owner;
    private boolean owned;
    private int row;
    private int col;

    public static boolean landBuyEnable = false;
    
    // private hasMule //TODO
    // private numMule //If a mule is on the property when sold, it is lost
    //randomNum = minimum + (int)(Math.random()*maximum);

    public Land(int row, int col) {
        this.row = row;
        this.col = col;
        owned = false;
    }

    public int getRow() {return row;}
    public int getCol() {return col;}

    public Player getOwner() {return owner;}

    public static int getBuyPrice() {
        return 300 + Turns.rounds + (int)(Math.random() * 100);
    }
    public int getSellPrice() {
        return 400 + (int)(Math.random() * 200);
    }

    public void buyLand(Player p) {
        if (!isOwned()) {
            owner = p;
            owned = true;
            owner.addSubMoney(getBuyPrice());
        } else {
            System.out.println("This land is already owned"); //TODO
        }
    }

    public void sellLand() {
        if (isOwned()) {
            if (owner.getLocation() == Player.Location.LANDOFFICE) {
                owner.addSubMoney(getSellPrice());
                owner = null;
                owned = false;
            } else {
                System.out.println("Need to be in Land office"); //create error that says this? TODO
            }
        } else {
            System.out.println("This land is not owned to sell"); //TODO
        }
    }

    public boolean isOwned() {return owned;}
}