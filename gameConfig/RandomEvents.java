package gameConfig;

/**
 * Created by jessicahoffman on 10/19/15.
 */
public class RandomEvents {


    public int caclulateM(){
        int r = Turns.rounds;
        int m;

        if (r <= 3) { // rounds 1 - 3
            m = 25;
        } else if (r <= 7) { // rounds 4 - 7
            m = 50;
        } else if (r <= 11) { // rounds 8 - 11
            m = 75;
        } else { // round 12
            m = 100;
        }
        return m;
    }

}
