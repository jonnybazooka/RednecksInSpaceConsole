package crises;

import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class CrisisEight extends Crisis {
    public CrisisEight(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your miner has been attacked by venomous mountain snakes, and as a result he will suffer from " +
                "a brain damage.\nSomebody will have to give him a medical attention. Choose who: ");
        String medicalAttender = new Scanner(System.in).nextLine();
        switch (medicalAttender) {
            case "Farmer":
                if (workers.get(0).getBrainPowerProduction() > 1.9) {
                    System.out.println("Good job. Miner has been fully cured.");
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Bad job. Miner's brain has been damaged.");
                    workers.get(0).setExhaustionStatus(true);
                    workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 0.75);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Banker":
                if (workers.get(2).getBrainPowerProduction() > 1.9) {
                    System.out.println("Good job. Miner has been fully cured.");
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Bad job. Miner's brain has been damaged.");
                    workers.get(2).setExhaustionStatus(true);
                    workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 0.75);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Slave":
                if (workers.get(3).getBrainPowerProduction() > 1.9) {
                    System.out.println("Good job. Miner has been fully cured.");
                    workers.get(3).setExhaustionStatus(true);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Bad job. Miner's brain has been damaged.");
                    workers.get(3).setExhaustionStatus(true);
                    workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 0.75);
                    crises.get(7).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Miner":
                System.out.println("Miner cannot cure himself. You must choose somebody else.");
                crises.get(7).crisisResolution(crises, workers, resources);
                break;
            default:
                System.out.println("Enter Farmer, Banker or Slave.");
                break;
        }
    }
}
