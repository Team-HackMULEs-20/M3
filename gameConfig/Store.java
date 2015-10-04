package gameConfig;

public class Store {

    public int foodCost;
    public int foodQuantity;
    public int energyCost;
    public int energyQuantity;
    public int smithCost;
    public int smithQuantity;
    public int crysCost;
    public int crysQuantity;
    public int muleCost;
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
    public void setFoodQuantity(boolean buy, Player customer) {
        if (buy && foodQuantity == 0) {
            System.out.println("Not enough Food in the store.");
        } else {
            if (buy) {
                foodQuantity--;
                customer.addSubMoney(-foodCost);
                foodCost += 2;
            } else {
                foodQuantity++;
                customer.addSubMoney(foodCost-5);
                foodCost -= 2;
            }
        }
    }

    // ENERGY: initial q-c = 16-25
    // with each sold / bought, price changes by $2
    // sold to the store at $5 less than they cost
    public void setEnergyQuantity(boolean buy, Player customer) {
        if (buy && energyQuantity == 0) {
            System.out.println("Not enough Energy in the store.");
        } else {
            if (buy) {
                energyQuantity--;
                customer.addSubMoney(-energyCost);
                energyCost += 2;
            } else {
                energyQuantity++;
                customer.addSubMoney(energyCost-5);
                energyCost -= 2;
            }
        }
    }

    // Smithore: initial q-c = 0-50
    // with each sold / bought, price changes by $5 (only for greater than 1)
    // sold to the store at $8 less than they cost
    public void setSmithQuantity(boolean buy, Player customer) {
        if (buy && smithQuantity == 0) {
            System.out.println("Not enough Smithore in the store.");
        } else {
            if (buy) {
                smithQuantity--;
                customer.addSubMoney(-smithCost);
                if (smithQuantity == 0) {
                    smithCost = 50;
                } else {
                    smithCost += 5;
                }
            } else {
                smithQuantity++;
                customer.addSubMoney(smithCost-8);
                if (smithQuantity == 0) {
                    smithCost = 50;
                } else {
                    smithCost -= 5;
                }
            }
        }
    }

    // CHRYSTITE: initial q-c = 0-100
    // with each sold / bought, price changes by $10 (only for greater than 1)
    // sold to the store at $15 less than they cost
    public void setChrysQuantity(boolean buy, Player customer) {
        if (buy && crysQuantity == 0) {
            System.out.println("Not enough Chrystite in the store.");
        } else {
            if (buy) {
                crysQuantity--;
                customer.addSubMoney(-crysCost);
                if (crysQuantity == 0) {
                    crysCost = 100;
                } else {
                    crysCost += 10;
                }
            } else {
                crysQuantity++;
                customer.addSubMoney(crysCost-15);
                if (crysQuantity == 0) {
                    crysCost = 100;
                } else {
                    crysCost -= 10;
                }
            }
        }
    }

    // MULE: initial q-c = 25-100
    // with each sold / bought, price changes by $0
    // sold to the store at $15 less than they cost
    public void setMuleQuantity(boolean buy, Player customer) {
        if (buy && muleQuantity == 0) {
            System.out.println("Not enough Mules in the store.");
        } else {
            if (buy) {
                this.muleQuantity--;
            } else {
                this.muleQuantity++;
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
    }



}
