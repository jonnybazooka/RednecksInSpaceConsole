package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisNine extends Crisis {
    public CrisisNine(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("Great stock market crisis is coming. Your banker is doing good job but he will need some help to " +
                "make a lot of money.\nWho will help your banker?");
        String stockWizard = new Scanner(System.in).nextLine();
        switch (stockWizard) {
            case "Farmer":
                if (workers.get(0).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.9) {
                    resources.setMoneyResources(resources.getMoneyResources() *
                            (1 + workers.get(2).getBrainPowerProduction() / 9));
                    System.out.println("Good job. Your hav earned some $$$.");
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(0).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.2) {
                    System.out.println("You didn't earn anything, but you was able to avoid disaster.");
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("You have failed terribly. Crisis has taken 50% of your cash reserves.");
                    workers.get(0).setExhaustionStatus(true);
                    resources.setMoneyResources(resources.getMoneyResources() * 0.5);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Miner":
                if (workers.get(1).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.9) {
                    resources.setMoneyResources(resources.getMoneyResources() *
                            (1 + workers.get(2).getBrainPowerProduction() / 9));
                    System.out.println("Good job. Your hav earned some $$$.");
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(1).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.2) {
                    System.out.println("You didn't earn anything, but you was able to avoid disaster.");
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("You have failed terribly. Crisis has taken 50% of your cash reserves.");
                    workers.get(1).setExhaustionStatus(true);
                    resources.setMoneyResources(resources.getMoneyResources() * 0.5);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Slave":
                if (workers.get(3).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.9) {
                    resources.setMoneyResources(resources.getMoneyResources() *
                            (1 + workers.get(2).getBrainPowerProduction() / 9));
                    System.out.println("Good job. Your hav earned some $$$.");
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(3).getBrainPowerProduction() + workers.get(2).getBrainPowerProduction() > 5.2) {
                    System.out.println("You didn't earn anything, but you was able to avoid disaster.");
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("You have failed terribly. Crisis has taken 50% of your cash reserves.");
                    workers.get(3).setExhaustionStatus(true);
                    resources.setMoneyResources(resources.getMoneyResources() * 0.5);
                    crises.get(8).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Banker":
                System.out.println("Banker cannot deal with this crisis alone. Give him help.");
                crises.get(8).crisisResolution(crises, workers, resources);
                break;
            default:
                System.out.println("Enter: Farmer, Miner or Slave.");
                break;
        }
    }
}
