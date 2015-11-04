package gameConfig;

import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    private Player p;
    private Store s;
    private int[] Data = new int[7];
    private int[] DataBuyFood = new int[7];
    private int[] DataSellFood = new int[7];
    private int[] DataBuyEnergy = new int[7];
    private int[] DataSellEnergy = new int[7];

    private int[] TestData = new int[7];

    @Before
    public void setUp() throws Exception {
        Controller.level = "Beginner";
        p = new Player("Jess", Player.Race.BONZOID, Color.BROWN);
        s = new Store();

        int pm = p.getMoney();
        int pf = p.getFood();
        int pe = p.getEnergy();
        int fq = s.getFoodQuantity();
        int fc = s.getFoodCost();
        int eq = s.getEnergyQuantity();
        int ec = s.getEnergyCost();

        Data[0] = pm;
        Data[1] = pf;
        Data[2] = pe;
        Data[3] = fq;
        Data[4] = fc;
        Data[5] = eq;
        Data[6] = ec;

        pm -= fc;
        DataBuyFood[0] = pm;
        pf++;
        DataBuyFood[1] = pf;
        DataBuyFood[2] = pe;
        fq--;
        DataBuyFood[3] = fq;
        fc += 2;
        DataBuyFood[4] = fc;
        DataBuyFood[5] = eq;
        DataBuyFood[6] = ec;

        pm += (fc - 5);
        DataSellFood[0] = pm;
        pf--;
        DataSellFood[1] = pf;
        DataSellFood[2] = pe;
        fq++;
        DataSellFood[3] = fq;
        fc -= 2;
        DataSellFood[4] = fc;
        DataSellFood[5] = eq;
        DataSellFood[6] = ec;

        pm = p.getMoney();
        pf = p.getFood();
        pe = p.getEnergy();
        fq = s.getFoodQuantity();
        fc = s.getFoodCost();
        eq = s.getEnergyQuantity();
        ec = s.getEnergyCost();

        pm -= ec;
        DataBuyEnergy[0] = pm;
        DataBuyEnergy[1] = pf;
        pe++;
        DataBuyEnergy[2] = pe;
        DataBuyEnergy[3] = fq;
        DataBuyEnergy[4] = fc;
        eq--;
        DataBuyEnergy[5] = eq;
        ec += 2;
        DataBuyEnergy[6] = ec;

        pm += (ec - 5);
        DataSellEnergy[0] = pm;
        DataSellEnergy[1] = pf;
        pe--;
        DataSellEnergy[2] = pe;
        DataSellEnergy[3] = fq;
        DataSellEnergy[4] = fc;
        eq++;
        DataSellEnergy[5] = eq;
        ec -= 2;
        DataSellEnergy[6] = ec;
    }

    @Test
    public void testBuySellFood() throws Exception {
        s.buySellFood(true,p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = p.getEnergy();
        TestData[3] = s.getFoodQuantity();
        TestData[4] = s.getFoodCost();
        TestData[5] = s.getEnergyQuantity();
        TestData[6] = s.getEnergyCost();
        assertArrayEquals(TestData, DataBuyFood);

        s.buySellFood(false,p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = p.getEnergy();
        TestData[3] = s.getFoodQuantity();
        TestData[4] = s.getFoodCost();
        TestData[5] = s.getEnergyQuantity();
        TestData[6] = s.getEnergyCost();
        assertArrayEquals(TestData, DataSellFood);
    }

    @Test
    public void testBuySellEnergy() throws Exception {
        s.buySellEnergy(true, p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = p.getEnergy();
        TestData[3] = s.getFoodQuantity();
        TestData[4] = s.getFoodCost();
        TestData[5] = s.getEnergyQuantity();
        TestData[6] = s.getEnergyCost();
        assertArrayEquals(TestData, DataBuyEnergy);

        s.buySellEnergy(false, p);
        TestData[0] = p.getMoney();
        TestData[1] = p.getFood();
        TestData[2] = p.getEnergy();
        TestData[3] = s.getFoodQuantity();
        TestData[4] = s.getFoodCost();
        TestData[5] = s.getEnergyQuantity();
        TestData[6] = s.getEnergyCost();
        assertArrayEquals(TestData, DataSellEnergy);

    }

}