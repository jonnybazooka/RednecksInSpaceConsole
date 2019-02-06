package aplicationCore;

import java.util.Scanner;

public class Introduction {

    public static void introduction() {
        System.out.println("                     REDNECKS IS SPACE");
        System.out.println();
        System.out.println("Spaceship full of workers has crashed on a distant unknown planet.");
        System.out.println("Only four of them survived. There is no hope for rescue. Their only");
        System.out.println("chance is to rebuild their spaceship with scarce resources, which the");
        System.out.println("planet reluctantly provides, before they starve to death, or run out");
        System.out.println("of money.");
        System.out.println();
        System.out.println("Your workers have 3 main characteristics that describe their capacity to");
        System.out.println("be useful to your efforts:");
        System.out.println("FARMING - ability to produce food. Very important for Farmer. He will be");
        System.out.println("        the one that produces food each turn, unless for some reason, he");
        System.out.println("        is not able to. In that case a worker with highest farming skill will");
        System.out.println("        replace him for that turn.");
        System.out.println("MINERAL PRODUCTION - ability to produce minerals. Very important for Miner.");
        System.out.println("        He will be the one that produces minerals each turn, unless for some");
        System.out.println("        reason, he is not able to. In that case a worker with highest mineral");
        System.out.println("        production skill will replace him for that turn.");
        System.out.println("BRAIN POWER - ability to produce money, use advanced buildings and cope with");
        System.out.println("        unusual situations. Very important for Banker. He will be the one");
        System.out.println("        that produces money each turn, unless for some reason, he is not");
        System.out.println("        able to. In that case a worker with highest brain power will replace");
        System.out.println("        him for that turn.");
        System.out.println();
        System.out.println("VICTORY CONDITIONS:");
        System.out.println("To win the game you must repair your spaceship. Each turn you can take one action");
        System.out.println("to do some repairs. It will cost you 5 minerals and will provide 5 points of");
        System.out.println("progress. You must get 50 points of progress to complete the repair.");
        System.out.println();
        System.out.println("DEFEAT CONDITIONS:");
        System.out.println("Your workers need food to survive and money to work. If either of this resources");
        System.out.println("drop below zero at the end of your turn, you will loose the game.");
        System.out.println("The resources are limited, and your production is not enough to sustain your");
        System.out.println("workers in the long run. To make things worse, each turn a random event will");
        System.out.println("probably worsen your situation. Your only chance is to build proper buildings");
        System.out.println("that will increase your survival capacity. But remember - each building cost");
        System.out.println("some additional upkeep each turn, so choose wisely.");
        System.out.println();
        System.out.println("GOOD LUCK !");
        System.out.println();

        boolean contiunue = false;
        do {
            System.out.println("Type 'C' to continue.");
            String c = new Scanner(System.in).nextLine();
            if (c.toUpperCase().equals("C")) {
                contiunue = true;
            }
        } while (!contiunue);
    }
}
