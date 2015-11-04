package gameConfig;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Abigail on 11/4/15.
 */
public class IsAuctionTimeTest {

    private Boolean[] auctionTest;
    private Boolean[] auctionCheck;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Controller.landPlots = new Land[0][0];
        Controller.numPlayer = 2;

        auctionTest = new Boolean[2];

        Auction.landNotTaken = 0;
        auctionTest[0] = Auction.isAuctionTime();

        Auction.landNotTaken = 3;
        auctionTest[1] = Auction.isAuctionTime();

        auctionCheck = new Boolean[2];
        auctionCheck[0] = true;
        auctionCheck[1] = false;

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void isAuctionTime() throws Exception {
        assertArrayEquals(auctionCheck, auctionTest);
    }
}
