package gameConfig;

import java.io.Serializable;

public class Store implements Serializable {

	private int foodCost;
    private int foodQuantity;
    private int energyCost;
    private int energyQuantity;
    private int smithCost;
    private int smithQuantity;
    private int crysCost;
    private int crysQuantity;
    private final int muleCost;
    private final int oreQuantity;
    public int muleQuantity;

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
            this.oreQuantity = 0;
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
            this.oreQuantity = 8;
        }
    }

    // buy is to determine when player is selling or buying
    //only one item is be purchased/sold at a time, prices increase with each purchase,
    // and decrease with each sell.

    //FOOD: initial q-c = 16-30
    // with each food sold / bought, price changes by $2
    // food sold to the store at $5 less than they cost

    /**
     *
     * @param buy boolean if the item is bought
     * @param customer the player buying or selling
     */
    public void buySellFood(boolean buy, Player customer) {
        if (buy && foodQuantity == 0) {
            GameController.errorMessageBox("Not enough Food in the store");
        } else {
            if (buy) {
                if (customer.getMoney() >= foodCost) {
                    foodQuantity--;
                    customer.addSubMoney(-foodCost);
                    customer.addSubFood(1);
                    if (foodQuantity == 0) {
                        foodCost = 30;
                    } else {
                        foodCost += 2;
                    }
                } else {
                    GameController.errorMessageBox("You do not have enough money for this item.");
                }
            } else {
                if (customer.getFood() >= 1) {
                    customer.addSubMoney(foodCost - 5);
                    if (foodQuantity == 0) {
                        foodCost = 30;
                    } else {
                        foodCost -= 2;
                    }
                    customer.addSubFood(-1);
                    foodQuantity++;
                } else {
                    GameController.errorMessageBox("You do not have any of this item to sell");
                }
            }
        }
    }

    // ENERGY: initial q-c = 16-25
    // with each sold / bought, price changes by $2
    // sold to the store at $5 less than they cost

    /**
     *
     * @param buy boolean if the item is bought
     * @param customer the customer buying or selling
     */
    public void buySellEnergy(boolean buy, Player customer) {
        if (buy && energyQuantity == 0) {
            GameController.errorMessageBox("Not enough Energy in the store");
        } else {
            if (buy) {
                if (customer.getMoney() >= energyCost) {
                    energyQuantity--;
                    customer.addSubMoney(-energyCost);
                    customer.addSubEnergy(1);
                    if (energyQuantity == 0) {
                        energyCost = 25;
                    } else {
                        energyCost += 2;
                    }
                } else {
                    GameController.errorMessageBox("You do not have enough money for this item");
                }
            } else {
                if (customer.getEnergy() >= 1) {
                    customer.addSubMoney(energyCost - 5);
                    if (energyQuantity == 0) {
                        energyCost = 25;
                    } else {
                        energyCost -= 2;
                    }
                    customer.addSubEnergy(-1);
                    energyQuantity++;
                } else {
                    GameController.errorMessageBox("You do not have any of this item to sell");
                }
            }
        }
    }

    // Smithore: initial q-c = 0-50
    // with each sold / bought, price changes by $5 (only for greater than 1)
    // sold to the store at $8 less than they cost

    /**
     *
     * @param buy boolean if bought
     * @param customer player buying or selling
     */
    public void buySellSmithore(boolean buy, Player customer) {
        if (buy && smithQuantity == 0) {
            GameController.errorMessageBox("Not enough Smithore in the store");
        } else {
            if (buy) {
                if (customer.getMoney() >= smithCost) {
                    customer.addSubMoney(-smithCost);
                    customer.addSubOre(1);
                    smithQuantity--;
                    if (smithQuantity == 0) {
                        smithCost = 50;
                    } else {
                        smithCost += 5;
                    }
                } else {
                    GameController.errorMessageBox("You do not have enough money for this item");
                }
            } else {
                if (customer.getOre() >= 1) {
                    customer.addSubMoney(smithCost-8);
                    if (smithQuantity == 0) {
                        smithCost = 50;
                    } else {
                        smithCost -= 5;
                    }
                    customer.addSubOre(-1);
                    smithQuantity++;
                } else {
                    GameController.errorMessageBox("You do not have any of this item to sell");
                }
            }
        }
    }

    // CHRYSTITE: initial q-c = 0-100
    // with each sold / bought, price changes by $10 (only for greater than 1)
    // sold to the store at $15 less than they cost

    /**
     *
     * @param buy boolean if bought
     * @param customer player buying or selling
     */
    public void buySellChrystite(boolean buy, Player customer) {
        if (buy && crysQuantity == 0) {
            GameController.errorMessageBox("Not enough Crystite in the store.");
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
                    GameController.errorMessageBox("You do not have enough money for this item");
                }
            } else {
                if (customer.getCrystite() >= 1) {
                    customer.addSubMoney(crysCost-15);
                    if (crysQuantity == 0) {
                        crysCost = 100;
                    } else {
                        crysCost -= 10;
                    }
                    customer.addSubCrystite(-1);
                    crysQuantity++;
                } else {
                    GameController.errorMessageBox("You do not have enough money for this item");
                }
            }
        }
    }

    /**
     *
     * @return foodCost the cost of food
     */
    public int getFoodCost() {
        return foodCost;
    }
    /**
     *
     * @return foodQuantity the quantity of food
     */
    public int getFoodQuantity() {
        return foodQuantity;
    }
    /**
     *
     * @return energyCost the cost of energy
     */
    public int getEnergyCost() {
        return energyCost;
    }
    /**
     *
     * @return energyQuantity the quantity of energy
     */
    public int getEnergyQuantity() {
        return energyQuantity;
    }
    /**
     *
     * @return smithCost the cost of smithore
     */
    public int getSmithCost() {
        return smithCost;
    }
    /**
     *
     * @return smithQuantity the quantity of smithore
     */
    public int getSmithQuantity() {
        return smithQuantity;
    }
    /**
     *
     * @return crysCost the cost of crystite
     */
    public int getCrysCost() {
        return crysCost;
    }
    /**
     *
     * @return crysQuantity the quantity of crystite
     */
    public int getCrysQuantity() {
        return crysQuantity;
    }
    /**
     *
     * @return muleQuantity the quantity of mule
     */
    public int getMuleQuantity() {
        return muleQuantity;
    }
    /**
     *
     * @return muleCost the cost of mule
     */
    public int getMuleCost() {
        return muleCost;
    }

}
