package gameConfig;

import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
// Kaley's JUnit

public class TurnsTest {

    private Player[] playersBefore;
    private Player[] playersByScore;
    private static final int TIMEOUT = 200;

    /**
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Controller.level = "Beginner";
        playersBefore = new Player[4];
        playersBefore[0] = new Player("Kaley", Player.Race.BUZZITE, Color.AQUA.toString());
        playersBefore[1] = new Player("Chris", Player.Race.FLAPPER, Color.BLUE.toString());
        playersBefore[2] = new Player("Jess", Player.Race.BONZOID, Color.BROWN.toString());
        playersBefore[3] = new Player("Abby", Player.Race.HUMAN, Color.CRIMSON.toString());
        playersBefore[3].landOwned.add(new Land(0, 0));
        playersBefore[0].addSubFood(3);
        playersBefore[1].addSubEnergy(2);
        playersBefore[1].addSubOre(2);

        //player 0 -> 1000 + (500 * 0) + (30 * 11) + (25 * 4) + (50 * 0) = 1430
        //player 1 -> 1600 + (500 * 0) + (30 * 8) + (25 * 6) + (50 * 2) = 2090
        //player 2 -> 1000 + (500 * 0) + (30 * 8) + (25 * 4) + (50 * 0) = 1340
        //player 3 -> 600 + (500 * 1) + (30 * 8) + (25 * 4) + (50 * 0) = 1440
        Turns turns = new Turns(playersBefore);
        Turns.rounds = 2;
        playersByScore = new Player[4];
        playersByScore[0] = playersBefore[2];
        playersByScore[1] = playersBefore[0];
        playersByScore[2] = playersBefore[3];
        playersByScore[3] = playersBefore[1];
    }

    /**
     *
     * @throws Exception
     */
    @Test(timeout = TIMEOUT)
    public void testSortByScore() throws Exception {
        int p1Score = playersBefore[0].getScore();
        int p2Score = playersBefore[1].getScore();
        int p3Score = playersBefore[2].getScore();
        int p4Score = playersBefore[3].getScore();
        assertEquals(p1Score, 1430);
        assertEquals(p2Score, 2090);
        assertEquals(p3Score, 1340);
        assertEquals(p4Score, 1440);
        Turns.sortByScore();
        assertArrayEquals(playersByScore, playersBefore);

    }

    /**
     *
     * @throws Exception
     */
    @Test(timeout = TIMEOUT)
    public void testTimeForTurn() throws Exception {
        playersBefore[0].addSubFood(-9);
        int time = Turns.timeForTurn(playersBefore[0]);
        assertEquals(30, time);
        assertEquals(50, Turns.timeForTurn(playersBefore[2]));
    }
}