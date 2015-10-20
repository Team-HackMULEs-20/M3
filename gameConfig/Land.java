package gameConfig;

public class Land {
	private Player owner;
	private boolean owned;
	private int row;
	private int col;
	private Mule.Type muleType;

	public static boolean landBuyEnable = false;

	private boolean hasMule;
	public static Player latestBidder;
	public LandType type;



	// private hasMule //TODO
	// private numMule //If a mule is on the property when sold, it is lost
	//randomNum = minimum + (int)(Math.random()*maximum);

	public Land(int col, int row) {
		this.row = row;
		this.col = col;
		this.owned = false;
		this.hasMule = false;
	}

	public int getRow() {return row;}
	public int getCol() {return col;}

	public Player getOwner() {return owner;}

	public LandType getType() {
		return type;
	}

	public void setType(LandType newType) {
		this.type = newType;
	}

	//randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));
	public static int getBuyPrice() {return 300 + (Turns.rounds * (int)(Math.random() * (100 + 1))); }
	public int getSellPrice() {
		return 400 + (int)(Math.random() * (200 + 1));
	}

	public void setOwner(Player p) {
		owner = p;
		owned = true;
	}

	public void setMuleType(Mule.Type type) {
		this.muleType = type;
	}

	public Mule.Type getMuleType() {
		return muleType;
	}

	public void setBidder(Player p) {
		latestBidder = p;
	}

	public void buyLand(Player p) {
		if (!isOwned()) {
			this.setOwner(p);
			this.owner.addSubMoney(getBuyPrice());
		} else {
			System.out.println("This land is already owned"); //TODO
		}
	}

	// public void sellLand() { //TODO unused method
	// 	if (isOwned()) {
	// 		owner.addSubMoney(getSellPrice());
	// 		owner = null;
	// 		owned = false;
	// 	} else {
	// 		System.out.println("This land is not owned to sell"); //TODO
	// 	}
	// }

	public boolean hasMule() {return hasMule;}
	
	public void setHasMule(boolean mule) {hasMule = mule;}
	
	public boolean isOwned() {return owned;}
	
	public boolean equals(Land land) {
		return (land.getRow() == this.row && land.getCol() == this.getCol()); 
	}
	
}
