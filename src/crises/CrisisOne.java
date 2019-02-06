package crises;


import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;



public class CrisisOne extends Crisis {
    public CrisisOne(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        do {
            System.out.println("Your farm has been flooded by heavy rainstorms. You need to send somebody strong to " +
                    "drain the land or loose all food production this turn. Who do you send?");
            String landDrainer = new Scanner(System.in).nextLine();

            switch (landDrainer) {
                case "Farmer":
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(0).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                    if (workers.get(0).getMineralProduction() > 3) {
                        workers.get(0).setMineralProduction(workers.get(0).getMineralProduction() * 1.2);
                        System.out.println("Your " + landDrainer + " did a good job, and improved his strength and produces more minerals.");
                    } else {
                        System.out.println("Your " + landDrainer + " has failed at his task.");
                    }
                    break;
                case "Miner":
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(0).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                    if (workers.get(1).getMineralProduction() > 3) {
                        workers.get(1).setMineralProduction(workers.get(0).getMineralProduction() * 1.2);
                        System.out.println("Your " + landDrainer + " did a good job, and improved his strength and produces more minerals.");
                    } else {
                        System.out.println("Your " + landDrainer + " has failed at his task.");
                    }
                    break;
                case "Banker":
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(0).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                    if (workers.get(2).getMineralProduction() > 3) {
                        workers.get(2).setMineralProduction(workers.get(0).getMineralProduction() * 1.2);
                        System.out.println("Your " + landDrainer + " did a good job, and improved his strength and produces more minerals.");
                    } else {
                        System.out.println("Your " + landDrainer + " has failed at his task.");
                    }
                    break;
                case "Slave":
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(0).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                    if (workers.get(3).getMineralProduction() > 3) {
                        workers.get(3).setMineralProduction(workers.get(0).getMineralProduction() * 1.2);
                        System.out.println("Your " + landDrainer + " did a good job, and improved his strength and produces more minerals.");
                    } else {
                        System.out.println("Your " + landDrainer + " has failed at his task.");
                    }
                    break;
                default:
                    System.out.println("Enter: Farmer, Miner, Banker or Slave.");
            }
        } while (!isCrisisResolvedThisTurn);

    }
}
