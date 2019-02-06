package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisSix extends Crisis {
    public CrisisSix(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("There is an asteroid going towards your resource depot. You can send a one man mission to redirect " +
                "the asteroid,\nbut the worker you will send won't be able to produce this turn. Pick your worker:");
        String asteroidBuster = new Scanner(System.in).nextLine();
        switch (asteroidBuster) {
            case "Farmer":
                System.out.println("Mission was successful. Your worker gained some experience and improved his mining skills.");
                workers.get(0).setExhaustionStatus(true);
                workers.get(0).setMineralProduction(workers.get(0).getMineralProduction() * 1.25);
                crises.get(5).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Miner":
                System.out.println("Mission was successful. Your worker gained some experience and improved his mining skills.");
                workers.get(1).setExhaustionStatus(true);
                workers.get(1).setMineralProduction(workers.get(0).getMineralProduction() * 1.25);
                crises.get(5).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Banker":
                System.out.println("Mission was successful. Your worker gained some experience and improved his mining skills.");
                workers.get(2).setExhaustionStatus(true);
                workers.get(2).setMineralProduction(workers.get(0).getMineralProduction() * 1.25);
                crises.get(5).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Slave":
                System.out.println("Your slave betrayed you and failed his mission. Asteroid hit your resource depot\n" +
                        "and destroyed half of your minerals.");
                resources.setMineralResources(resources.getMineralResources() * 0.5);
                workers.get(3).setExhaustionStatus(true);
                crises.get(5).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            default:
                System.out.println("You must enter: Farmer, Miner, Banker or Slave.");
                break;
        }
    }
}
