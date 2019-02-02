package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisThirteen extends Crisis {
    public CrisisThirteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your Slave revolts! Somebody have to force him into submission. Choose who?");
        String slavemaster = new Scanner(System.in).nextLine();
        switch (slavemaster) {
            case "Farmer":
                workers.get(0).setExhaustionStatus(true);
                workers.get(3).setFoodProduction(workers.get(3).getFoodProduction() * 0.75);
                workers.get(3).setMineralProduction(workers.get(3).getMineralProduction() * 0.75);
                workers.get(3).setBrainPowerProduction(workers.get(3).getBrainPowerProduction() * 0.75);
                crises.get(12).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Miner":
                workers.get(1).setExhaustionStatus(true);
                workers.get(3).setFoodProduction(workers.get(3).getFoodProduction() * 0.75);
                workers.get(3).setMineralProduction(workers.get(3).getMineralProduction() * 0.75);
                workers.get(3).setBrainPowerProduction(workers.get(3).getBrainPowerProduction() * 0.75);
                crises.get(12).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Banker":
                workers.get(2).setExhaustionStatus(true);
                workers.get(3).setFoodProduction(workers.get(3).getFoodProduction() * 0.75);
                workers.get(3).setMineralProduction(workers.get(3).getMineralProduction() * 0.75);
                workers.get(3).setBrainPowerProduction(workers.get(3).getBrainPowerProduction() * 0.75);
                crises.get(12).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter: Farmer, Miner or Banker.");
                break;
        }
    }
}
