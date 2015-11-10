package gameConfig;

import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    private Player p;
    private Player p2;
    private Store s;
    private final int[] DataBuyFood = new int[4];
    private final int[] DataBuyFood2 = new int[4];
    private final int[] DataSellFood = new int[4];
    private final int[] DataSellFood2 = new int[4];

    private final int[] TestData = new int[4];

    @Before
    public void setUp() throws Exception {
        Controller.level = "Beginner";
        p = new Player("Jess", Player.Race.BONZOID, Color.BROWN.toString());
        p2 = new Player("Kaley", Player.Race.BONZOID, Color.PURPLE.toString());
        p2.addSubMoney(-1000);
        p2.addSubFood(-8);
        s = new Store();

        int pm = p.getMoney();
        int pf = p.getFood();
        int pe = p.getEnergy();
        int fq = s.getFoodQuantity();
        int fc = s.getFoodCost();
        int eq = s.getEnergyQuantity();
        int ec = s.getEnergyCost();

        //BUYING
        //perfect
        pm -= fc;
        DataBuyFood[0] = pm;
        pf++;
        DataBuyFood[1] = pf;
        fq--;
        DataBuyFood[2] = fq;
        fc += 2;
        DataBuyFood[3] = fc;

        //foodQuantity == 0
        for (int i = 1; i <= 15; i++) {
            pm -= fc;
            DataBuyFood2[0] = pm;
            pf++;
            DataBuyFood2[1] = pf;
            fq--;
            DataBuyFood2[2] = fq;
            fc += 2;
            DataBuyFood2[3] = fc;
        }
        fc = 30;
        DataBuyFood2[3] = fc;

        //foodQuantity == 1
        pm += (fc - 5);
        DataSellFood[0] = pm;
        pf--;
        DataSellFood[1] = pf;
        fq++;
        DataSellFood[2] = fq;
        DataSellFood[3] = fc;

        //perfect
        pm += (fc - 5);
        DataSellFood2[0] = pm;
        pf--;
        DataSellFood2[1] = pf;
        fq++;
        DataSellFood2[2] = fq;
        fc -= 2;
        DataSellFood2[3] = fc;
    }

    @Test
    public void testBuySellFood() throws Exception {
        //BUYING
        //perfect
        s.buySellFood(true,p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = s.getFoodQuantity();
        TestData[3] = s.getFoodCost();
        assertArrayEquals(TestData, DataBuyFood);

        //not enough money
        try {
            s.buySellFood(true, p2);
        }
        catch(ExceptionInInitializerError e) {
        }

        //foodQuantity == 0
        for (int i = 1; i <= 15; i++) {
            s.buySellFood(true, p);
        }
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = s.getFoodQuantity();
        TestData[3] = s.getFoodCost();
        assertArrayEquals(TestData, DataBuyFood2);

        //not enough food
        try {
            s.buySellFood(true, p);
        }
        catch(NoClassDefFoundError e) {
        }

        //SELLING
        //foodQuantity == 1
        s.buySellFood(false,p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = s.getFoodQuantity();
        TestData[3] = s.getFoodCost();
        assertArrayEquals(TestData, DataSellFood);

        //perfect
        s.buySellFood(false,p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = s.getFoodQuantity();
        TestData[3] = s.getFoodCost();
        assertArrayEquals(TestData, DataSellFood2);

        //none of the item to sell
        try {
            s.buySellFood(false,p2);
        }
        catch(NoClassDefFoundError e) {
        }
    }

}