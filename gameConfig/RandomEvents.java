package gameConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jessicahoffman on 10/19/15.
 */
public class RandomEvents {
    Map<Integer, String> re;

    public RandomEvents() {
        re = new HashMap<>();
        re.put(1, "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
        re.put(2, "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
        re.put(3, "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + 8 * calculateM() + ".");
        re.put(4, "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + 2 * calculateM() + ".");
        re.put(5, "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + 4 * calculateM() + ".");
        re.put(6, "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
        re.put(7, "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + 6 * calculateM() + " TO CLEAN IT UP.");

    }

    public void determineRandomEvent(){
        //randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));
        int chance = (int)(Math.random()*100);
        if (chance <= 27) {
            int chooseRE = (int)(Math.random()*7);
        }

    }

    public static int calculateM(){
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
