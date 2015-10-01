package gameConfig;
/**
 * Created by findleyck on 10/1/15.
 */
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

    // buy is to determine when player is selling or buying
    public void setFoodQuantity(int amount, boolean buy) {
        if (amount > foodQuantity && buy || buy && foodQuantity == 0) {
            System.out.println("Not enough Food in the store.");
        } else {
            if (buy) {
                this.foodQuantity -= amount;
            } else {
                this.foodQuantity += amount;
            }
        }
    }

    public void setEnergyQuantity(int amount, boolean buy) {
        if (amount > energyQuantity && buy || buy && energyQuantity == 0) {
            System.out.println("Not enough Energy in the store.");
        } else {
            if (buy) {
                this.energyQuantity -= amount;
            } else {
                this.energyQuantity += amount;
            }
        }
    }

    public void setSmithQuantity(int amount, boolean buy) {
        if (amount > smithQuantity && buy || buy && smithQuantity == 0) {
            System.out.println("Not enough Smithore in the store.");
        } else {
            if (buy) {
                this.smithQuantity -= amount;
            } else {
                this.smithQuantity += amount;
            }
        }
    }

    public void setChrysQuantity(int amount, boolean buy) {
        if (amount > crysQuantity && buy || buy && crysQuantity == 0) {
            System.out.println("Not enough Chrystite in the store.");
        } else {
            if (buy) {
                this.crysQuantity -= amount;
            } else {
                this.crysQuantity += amount;
            }
        }
    }

    public void setMuleQuantity(int amount, boolean buy) {
        if (amount > muleQuantity && buy || buy && muleQuantity == 0) {
            System.out.println("Not enough Mules in the store.");
        } else {
            if (buy) {
                this.muleQuantity -= amount;
            } else {
                this.muleQuantity += amount;
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
