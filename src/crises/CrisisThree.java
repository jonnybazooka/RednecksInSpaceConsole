package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisThree extends Crisis {
    public CrisisThree(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your farmer got drunk and cannot work. He needs a medical attention. Who will care for your farmer?");
        String medic = new Scanner(System.in).nextLine();
        switch (medic) {
            case "Miner":
                if (workers.get(1).getBrainPowerProduction() > 2.2) {
                    System.out.println("Your miner did a good job. Your farmer can work again, and got a little bit smarter.");
                    workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 1.2);
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(2).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Your miner couldn't help farmer.");
                    workers.get(0).setExhaustionStatus(true);
                    crises.get(2).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Banker":
                if (workers.get(2).getBrainPowerProduction() > 2.2) {
                    System.out.println("Your banker did a good job. Your farmer can work again, and got a little bit smarter.");
                    workers.get(2).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 1.2);
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(2).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("Your banker couldn't help farmer.");
                    workers.get(2).setExhaustionStatus(true);
                    crises.get(2).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "Slave":
                System.out.println("Your slave is a bastard. He used the opportunity to permanently damage your farmer's ability to farm.");
                workers.get(0).setExhaustionStatus(true);
                workers.get(0).setFoodProduction(workers.get(0).getFoodProduction() * 0.75);
                crises.get(2).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("You must enter: Miner, Banker or Slave.");
                break;
        }
    }
}
