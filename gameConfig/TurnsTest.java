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
        playersBefore[3].getLandOwned().add(new Land(0, 0));
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
        Turns.sortByScore();
        assertArrayEquals(playersByScore, playersBefore);
    }

    /**
     *
     * @throws Exception
     */
    @Test(timeout = TIMEOUT)
    public void testTimeForTurn() throws Exception {
        playersBefore[0].addSubFood(-6);
        int time = Turns.timeForTurn(playersBefore[0]);
        assertEquals(30, time);
        assertEquals(50, Turns.timeForTurn(playersBefore[2]));
    }
}