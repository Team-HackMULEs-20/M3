package gameConfig;

import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by findleyck on 11/3/15.
 */
public class TurnsTest {

    private Player[] playersBefore;
    private Player[] playersByScore;
    private static final int TIMEOUT = 200;

    @Before
    public void setUp() throws Exception {
        Controller.level = "Beginner";
        playersBefore = new Player[4];
        playersBefore[0] = new Player("Kaley", Player.Race.BUZZITE, Color.AQUA);
        playersBefore[1] = new Player("Chris", Player.Race.BONZOID, Color.BLUE);
        playersBefore[2] = new Player("Jess", Player.Race.FLAPPER, Color.BROWN);
        playersBefore[3] = new Player("Abby", Player.Race.HUMAN, Color.CRIMSON);
        Turns turns = new Turns(playersBefore);
        playersByScore = new Player[4];
        playersByScore[0] = playersBefore[3];
        playersByScore[1] = playersBefore[1];
        playersByScore[2] = playersBefore[0];
        playersByScore[3] = playersBefore[2];
    }

    @Test
    public void testSortByScore() throws Exception {
        Turns.sortByScore();
        assertArrayEquals(playersByScore, playersBefore);
    }
}