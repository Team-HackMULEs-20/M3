package gameConfig;

public class Store {

	public static int foodCost, foodQuantity,
	energyCost, energyQuantity,
	smithCost, smithQuantity,
	crysCost, crysQuantity,
	muleCost, muleQuantity;

    public Store() {
        if (Controller.level.equals("Beginner")) {
            this.foodQuantity = 16;
            this.foodCost = 30;
            this.energyQuantity = 16;
            this.energyCost = 25;
            this.smithQuantity = 0;
            this.smithCost = 50;
            this.crysQuantity = 0;
            this.crysCost = 100;
            this.muleQuantity = 25;
            this.muleCost = 100;
        } else {
            this.foodQuantity = 8;
            this.foodCost = 30;
            this.energyQuantity = 8;
            this.energyCost = 25;
            this.smithQuantity = 8;
            this.smithCost = 50;
            this.crysQuantity = 0;
            this.crysCost = 100;
            this.muleQuantity = 14;
            this.muleCost = 100;
        }
    }


//    public void setFoodQuantity(int amount, boolean buy) {
//        if (amount > foodQuantity && buy || buy && foodQuantity == 0) {
//            System.out.println("Not enough Food in the store.");
//        } else {
//            if (buy) {
//                this.foodQuantity -= amount;
//            } else {
//                this.foodQuantity += amount;
//            }
//        }
//    }

    // buy is to determine when player is selling or buying
    //only one item is be purchased/sold at a time, prices increase with each purchase,
    // and decrease with each sell.

    //FOOD: initial q-c = 16-30
    // with each food sold / bought, price changes by $2
    // food sold to the store at $5 less than they cost
    public void buySellFood(boolean buy, Player customer) {
        if (buy && foodQuantity == 0) {
            System.out.println("Not enough Food in the store.");
        } else {
            if (buy) {
                foodQuantity--;
                if (customer.getMoney() >= foodCost) {
                    customer.addSubMoney(-foodCost);
                    customer.addSubFood(1);
                    foodCost += 2;
                } else {
                    // make into error message? //TODO
                    System.out.println("You do not have enough money for this item");
                }
            } else {
                if (customer.getFood() >= 1) {
                    foodQuantity++;
                    customer.addSubMoney(foodCost-5);
                    customer.addSubFood(-1);
                    foodCost -= 2;
                } else {
                    // make into error message? //TODO
                    System.out.println("You do not have any of this item to sell");
                }
            }
        }
    }

    // ENERGY: initial q-c = 16-25
    // with each sold / bought, price changes by $2
    // sold to the store at $5 less than they cost
    public void buySellEnergy(boolean buy, Player customer) {
        if (buy && energyQuantity == 0) {
            System.out.println("Not enough Energy in the store.");
        } else {
            if (buy) {
                energyQuantity--;
                if (customer.getMoney() >= energyCost) {
                    customer.addSubMoney(-energyCost);
                    customer.addSubEnergy(1);
                    energyCost += 2;
                } else {
                    System.out.println("You do not have enough money for this item");
                }
            } else {
                if (customer.getEnergy() >= 1) {
                    energyQuantity++;
                    customer.addSubMoney(energyCost-5);
                    customer.addSubEnergy(-1);
                    energyCost -= 2;
                } else {
                    System.out.println("You do not have any of this item to sell");
                }
            }
        }
    }

    // Smithore: initial q-c = 0-50
    // with each sold / bought, price changes by $5 (only for greater than 1)
    // sold to the store at $8 less than they cost
    public void buySellSmithore(boolean buy, Player customer) {
        if (buy && smithQuantity == 0) {
            System.out.println("Not enough Smithore in the store.");
        } else {
            if (buy) {
                smithQuantity--;
                if (customer.getMoney() >= smithCost) {
                    customer.addSubMoney(-smithCost);
                    customer.addSubOre(1);
                    if (smithQuantity == 0) {
                        smithCost = 50;
                    } else {
                        smithCost += 5;
                    }
                } else {
                    System.out.println("You do not have enough money for this item");
                }
            } else {
                if (customer.getOre() >= 1) {
                    smithQuantity++;
                    customer.addSubMoney(smithCost-8);
                    customer.addSubOre(-1);
                    if (smithQuantity == 0) {
                        smithCost = 50;
                    } else {
                        smithCost -= 5;
                    }
                } else {
                    System.out.println("You do not have any of this item to sell");
                }
            }
        }
    }

    // CHRYSTITE: initial q-c = 0-100
    // with each sold / bought, price changes by $10 (only for greater than 1)
    // sold to the store at $15 less than they cost
    public void buySellChrystite(boolean buy, Player customer) {
        if (buy && crysQuantity == 0) {
            System.out.println("Not enough Chrystite in the store.");
        } else {
            if (buy) {
                crysQuantity--;
                if (customer.getMoney() >= crysCost) {
                    customer.addSubMoney(-crysCost);
                    customer.addSubCrystite(1);
                    if (crysQuantity == 0) {
                        crysCost = 100;
                    } else {
                        crysCost += 10;
                    }
                } else {
                    System.out.println("You do not have enough money for this item");
                }
            } else {
                if (customer.getCrystite() >= 1) {
                    crysQuantity++;
                    customer.addSubMoney(crysCost-15);
                    customer.addSubCrystite(-1);
                    if (crysQuantity == 0) {
                        crysCost = 100;
                    } else {
                        crysCost -= 10;
                    }
                } else {
                    System.out.println("You do not have enough money for this item");
                }
            }
        }
    }

    // MULE: initial q-c = 25-100
    // with each sold / bought, price changes by $0
    // sold to the store at $15 less than they cost
    // TODO
    public void buySellMule(boolean buy, Player customer) {
        if (buy && muleQuantity == 0) {
            System.out.println("Not enough Mules in the store.");
        } else {
            if (buy) {
                muleQuantity--;
            } else {
                muleQuantity++;
            }
        }
    }

    public int getFoodCost() {
        return foodCost;
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public int getEnergyQuantity() {
        return energyQuantity;
    }

    public int getSmithCost() {
        return smithCost;
    }

    public int getSmithQuantity() {
        return smithQuantity;
    }

    public int getCrysCost() {
        return crysCost;
    }

    public int getCrysQuantity() {
        return crysQuantity;
    }

    public int getMuleQuantity() {
        return muleQuantity;
    } //also cost //TODO

}
