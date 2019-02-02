package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisFourteen extends Crisis {
    public CrisisFourteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your slave have found an alien device. Nobody knows how it works. Slave will use it on the " +
                "worker of your choice. Pick one.");
        String alienDeviceTarget = new Scanner(System.in).nextLine();
        switch (alienDeviceTarget) {
            case "Farmer":
                System.out.println("Slave's and Farmer's farming skills have swapped.");
                double farmingSkillRepository = workers.get(3).getFoodProduction();
                workers.get(3).setFoodProduction(workers.get(0).getFoodProduction());
                workers.get(0).setFoodProduction(farmingSkillRepository);
                System.out.println("Slave is exhausted after the exchange and cannot work this turn.");
                workers.get(3).setExhaustionStatus(true);
                crises.get(13).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Miner":
                System.out.println("Slave's and Miner's mineral production skills have swapped.");
                double miningSkillRepository = workers.get(3).getMineralProduction();
                workers.get(3).setMineralProduction(workers.get(1).getMineralProduction());
                workers.get(1).setMineralProduction(miningSkillRepository);
                System.out.println("Slave is exhausted after the exchange and cannot work this turn.");
                workers.get(3).setExhaustionStatus(true);
                crises.get(13).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Banker":
                System.out.println("Slave's and Banker's brain skills have swapped.");
                double brainSkillRepository = workers.get(3).getBrainPowerProduction();
                workers.get(3).setBrainPowerProduction(workers.get(2).getBrainPowerProduction());
                workers.get(2).setBrainPowerProduction(brainSkillRepository);
                System.out.println("Slave is exhausted after the exchange and cannot work this turn.");
                workers.get(3).setExhaustionStatus(true);
                crises.get(13).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter: Farmer, Miner or Banker.");
                break;
        }
    }
}
