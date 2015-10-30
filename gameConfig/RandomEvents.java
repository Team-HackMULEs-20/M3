package gameConfig;

import java.util.HashMap;
import java.util.Map;

public class RandomEvents {
//    Map<Integer, String> re;
//
//    public RandomEvents() {
//        re = new HashMap<>();
//        re.put(1, "YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
//        re.put(2, "A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
//        re.put(3, "THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + 8 * calculateM() + ".");
//        re.put(4, "YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + 2 * calculateM() + ".");
//        re.put(5, "FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + 4 * calculateM() + ".");
//        re.put(6, "MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
//        re.put(7, "YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + 6 * calculateM() + " TO CLEAN IT UP.");
//
//    }

    //randomNum = Min + (int)(Math.random() * ((Max - Min) + 1));

    public void determineRandomEvent(Player p){

        int chance = (int)(Math.random() * 100);
        if (chance <= 100) {
            int chooseRE = (int)(Math.random() * 7) + 1;
            if (chooseRE == 1) {
                System.out.println("YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.");
                p.addSubFood(3);
                p.addSubEnergy(2);

            } else if (chooseRE == 2) {
                System.out.println("A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.");
                p.addSubOre(2);

            } else if (chooseRE == 3) {
                int m = 8 * calculateM();
                System.out.println("THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $" + m + ".");
                p.addSubMoney(m);

            } else if (chooseRE == 4) {
                int m = 2 * calculateM();
                System.out.println("YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $" + m + ".");
                p.addSubMoney(m);

            } else if (chooseRE == 5) {
                int m = 4 * calculateM();
                System.out.println("FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $" + m + ".");
                p.addSubMoney(-m);

            } else if (chooseRE == 6) {
                System.out.println("MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.");
                int f = p.getFood();
                p.addSubFood(-(f/2));

            } else {
                int m = 6 * calculateM();
                System.out.println("YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $" + m + " TO CLEAN IT UP.");
                p.addSubMoney(-m);
            }
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
