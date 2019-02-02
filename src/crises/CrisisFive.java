package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisFive extends Crisis {
    public CrisisFive(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("There is a problem in the mine. A lot of resources had been cut off by a cave-in. The only way to get to " +
                "them is to plant a dynamite.\nYou have to choose who will plant the charges. The smarter the worker, the better the " +
                "results will be.\nBut the worker won't be able to produce this turn. Pick a worker: ");
        String mrDynamite = new Scanner(System.in).nextLine();
        switch (mrDynamite) {
            case "Farmer":
                if (workers.get(0).getBrainPowerProduction() > 2.5) {
                    System.out.println("Effects are spectacular. Not only resources had been freed, but you have discovered a new " +
                            "rich vain.\nYour mineral production rises permanently.");
                    resources.setMineralFactor(resources.getMineralFactor() + 0.25);
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(0).getBrainPowerProduction() > 1.8) {
                    System.out.println("Dynamite did it's job. Resources had been freed.");
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Oops. That wasn't a good blast. The mine was permanently damaged, and your mineral " +
                            "production drops.");
                    resources.setMineralFactor(resources.getMineralFactor() - 0.25);
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Miner":
                if (workers.get(1).getBrainPowerProduction() > 2.5) {
                    System.out.println("Effects are spectacular. Not only resources had been freed, but you have discovered a new " +
                            "rich vain.\nYour mineral production rises permanently.");
                    resources.setMineralFactor(resources.getMineralFactor() + 0.25);
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(1).getBrainPowerProduction() > 1.8) {
                    System.out.println("Dynamite did it's job. aplicationCore.Resources had been freed.");
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Oops. That wasn't a good blast. The mine was permanently damaged, and your mineral " +
                            "production drops.");
                    resources.setMineralFactor(resources.getMineralFactor() - 0.25);
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Banker":
                if (workers.get(2).getBrainPowerProduction() > 2.5) {
                    System.out.println("Effects are spectacular. Not only resources had been freed, but you have discovered a new " +
                            "rich vain.\nYour mineral production rises permanently.");
                    resources.setMineralFactor(resources.getMineralFactor() + 0.25);
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(2).getBrainPowerProduction() > 1.8) {
                    System.out.println("Dynamite did it's job. aplicationCore.Resources had been freed.");
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Oops. That wasn't a good blast. The mine was permanently damaged, and your mineral " +
                            "production drops.");
                    resources.setMineralFactor(resources.getMineralFactor() - 0.25);
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Slave":
                if (workers.get(3).getBrainPowerProduction() > 2.5) {
                    System.out.println("Effects are spectacular. Not only resources had been freed, but you have discovered a new " +
                            "rich vain.\nYour mineral production rises permanently.");
                    resources.setMineralFactor(resources.getMineralFactor() + 0.25);
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(3).getBrainPowerProduction() > 1.8) {
                    System.out.println("Dynamite did it's job. aplicationCore.Resources had been freed.");
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Oops. That wasn't a good blast. The mine was permanently damaged, and your mineral " +
                            "production drops.");
                    resources.setMineralFactor(resources.getMineralFactor() - 0.25);
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(4).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            default:
                System.out.println("You must enter: Farmer, Miner, Banker or Slave.");
                break;
        }
    }
}
