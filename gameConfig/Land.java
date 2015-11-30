package gameConfig;

import java.io.Serializable;

import javafx.scene.shape.Rectangle;

public class Land implements Serializable {
	private Player owner;
	private boolean owned;
	private final int row;
	private final int col;
	private Mule.Type muleType;
	public static boolean landBuyEnable = false;
	public static boolean landSellEnable = false;

	private boolean hasMule;
	public static Player latestBidder;
	private LandType type;
	private boolean muleBuyEnable;

	private Rectangle color;

	private int crystite;



	// private hasMule //TODO
	// private numMule //If a mule is on the property when sold, it is lost
	//randomNum = minimum + (int)(Math.random()*maximum);

	public Land(int col, int row) {
		this.row = row;
		this.col = col;
		this.owned = false;
		this.hasMule = false;
		this.owner = null;
		this.muleBuyEnable = true;
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

	private int getSellPrice() {
		return 400 + (int)(Math.random() * (200 + 1));
	}

	public void setRectangle(Rectangle rec) {
		color = rec;
	}

	public Rectangle getRectangle() {return color;}

	public void setCrystite(int c) {
		this.crystite = c;
	}

	public int getCrystite() {return crystite;}

	public static int[] getCPlots() {
		int[] cPlots = new int[3];
		cPlots[0] = (int)(Math.random() * 43);
		cPlots[1] = cPlots[0] + (int)(Math.random() * (44 - cPlots[0]));
		cPlots[2] = cPlots[1] + (int)(Math.random() * (45 - cPlots[1]));
		for (int i = 0; i < 3; i++) {
			while (cPlots[i] > 19 && cPlots[i] < 25)
				cPlots[i]++;
		}
		if (cPlots[0] == cPlots[1]) {
			if (cPlots[1] == cPlots[2]) {
				cPlots[2] += 2;
			}
			cPlots[1]++;
		}
		if (cPlots[1] == cPlots[2])
			cPlots[2]++;
		
		int[] retPlots = new int[45];
		retPlots[cPlots[0]] = 3;
		retPlots[cPlots[1]] = 3;
		retPlots[cPlots[2]] = 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 45; j++) {
				if (j == cPlots[i] - 6 || j == cPlots[i] - 1 || j == cPlots[i] + 4 ||
					j == cPlots[i] - 5 ||                       j == cPlots[i] + 5 ||
					j == cPlots[i] - 4 || j == cPlots[i] + 1 || j == cPlots[i] + 6) {
					if (retPlots[j] < 2) 
						retPlots[j] = 2;
				}
			}
		}
		
		retPlots[20] = 0;
		retPlots[21] = 0;
		retPlots[22] = 0;
		retPlots[23] = 0;
		retPlots[24] = 0;
		
		return retPlots;	
	}
	
	/*
	 *  0,  1,  2,  3,  4,  5,  6,  7,  8
	 *  9, 10, 11, 12, 13, 14, 15, 16, 17
	 * 18, 19, 20, 21, 22, 23, 24, 25, 26
	 * 27, 28, 29, 30, 31, 32, 33, 34, 35
	 * 36, 37, 38, 39, 40, 41, 42, 43, 44 
	 */

	public void setOwner(Player p) {
		this.owner = p;
		this.owned = true;
	}

	public void setMuleBuyEnable(boolean newEnable) {
		this.muleBuyEnable = newEnable;
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
			GameController.errorMessageBox("This land is already owned");
		}
	}

	public void sellLand() {
		owner.addSubMoney(getSellPrice());
		owner = null;
		owned = false;
	}

	public boolean hasMule() {return hasMule;}

	public void setHasMule(boolean mule) {hasMule = mule;}

	public boolean isOwned() {return owned;}

	public boolean equals(Land land) {
		return (land.getRow() == this.row && land.getCol() == this.getCol()); 
	}

}
