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

	/**
	 *
	 * @param col columns of land
	 * @param row rows of land
	 */
	public Land(int col, int row) {
		this.row = row;
		this.col = col;
		this.owned = false;
		this.hasMule = false;
		this.owner = null;
	}

	/**
	 *
	 * @return row the row index of land
	 */
	public int getRow() {return row;}

	/**
	 *
	 * @return col the column index of land
	 */
	public int getCol() {return col;}

	/**
	 *
	 * @return owner the player that owns the land
	 */
	public Player getOwner() {return owner;}

	/**
	 *
	 * @return type the land type
	 */
	public LandType getType() {
		return type;
	}

	/**
	 *
	 * @param newType the new land type the plot is set to
	 */
	public void setType(LandType newType) {
		this.type = newType;
	}

	/**
	 *
	 * @return int of the buy price of the land
	 */
	//randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));
	public static int getBuyPrice() {return 300 + (Turns.rounds * (int)(Math.random() * (100 + 1))); }
	public int getSellPrice() {
		return 400 + (int)(Math.random() * (200 + 1));
	}

	/**
	 *
	 * @param p the player to set the owner to
	 */
	public void setOwner(Player p) {
		this.owner = p;
		this.owned = true;
	}

	/**
	 *
	 * @param type the mule type to set the mule to
	 */
	public void setMuleType(Mule.Type type) {
		this.muleType = type;
	}

	/**
	 *
	 * @return muleType the type of mule
	 */
	public Mule.Type getMuleType() {
		return muleType;
	}

	/**
	 *
	 * @param p the player the bidder represents
	 */
	public void setBidder(Player p) {
		latestBidder = p;
	}

	/**
	 *
	 * @param p the player to buy land from
	 */
	public void buyLand(Player p) {
		if (!isOwned()) {
			this.setOwner(p);
			this.owner.addSubMoney(getBuyPrice());
		} else {
			GameController.errorMessageBox("This land is already owned");
		}
	}

	 public void sellLand() { //TODO unused method
	 	if (isOwned()) {
	 		owner.addSubMoney(getSellPrice());
	 		owner = null;
	 		owned = false;
	 	} else {
			GameController.errorMessageBox("This land is not owned to sell");
	 	}
	 }

	/**
	 *
	 * @return hasMule whether there is a mule or not
	 */
	public boolean hasMule() {return hasMule;}
	/**
	 *
	 * @param mule the mule to set true or not
	 */
	public void setHasMule(boolean mule) {hasMule = mule;}

	/**
	 *
	 * @return owned the boolean determining if the mule if owned or not
	 */
	public boolean isOwned() {return owned;}

	/**
	 *
	 * @param land the land plot to check if equals
	 * @return boolean if the land plots are the same
	 */
	public boolean equals(Land land) {
		return (land.getRow() == this.row && land.getCol() == this.getCol()); 
	}
	
}
