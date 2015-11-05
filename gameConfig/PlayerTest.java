package gameConfig;

import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.*;

// JUnit by Carlos

public class PlayerTest {

    @Test
    public void testGamble() throws Exception {
        Controller.level = "Beginner";
        Player p = new Player("Carlos", Player.Race.BUZZITE, Color.AQUA.toString());

        Turns.rounds = 1;
        int time = 10;
        boolean money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 2;
        time = 15;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 3;
        time = 29;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 4;
        time = 8;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 5;
        time = 20;
        money = (p.gamble(time) <= 250);
        assertTrue(money);

        Turns.rounds = 6;
        time = 30;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 7;
        time = 28;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 8;
        time = 11;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 9;
        time = 24;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 10;
        time = 12;
        money = (p.gamble(time) <= 250);
        assertTrue(money);

        Turns.rounds = 11;
        time = 25;
        money = (p.gamble(time) > 250);
        assertFalse(money);

        Turns.rounds = 12;
        time = 37;
        money = (p.gamble(time) > 250);
        assertFalse(money);


    }
}
