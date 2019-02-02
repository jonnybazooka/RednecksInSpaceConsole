package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisSeven extends Crisis {
    public CrisisSeven(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your miner has found an alien power drill. He cannot wait to use it in his mine.\nWill you " +
                "let this idiot do this? Yes or No ");
        String acceptanceAlienDrill = new Scanner(System.in).nextLine();
        switch (acceptanceAlienDrill) {
            case "Yes":
                if (workers.get(1).getBrainPowerProduction() > 2.1) {
                    System.out.println("This is a spectacular tool. Mining has never been so easy. Efficiency increase 25%");
                    System.out.println("Your miner isn't so stupid after all. He can even work this turn.");
                    resources.setMineralFactor(resources.getMineralFactor() * 1.25);
                    crises.get(6).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else if (workers.get(1).getBrainPowerProduction() > 1.5) {
                    System.out.println("You are not smart enough to get everything from this tool. Still your efficiency" +
                            "rises by 10%.");
                    System.out.println("Trying this alien drill exhausted your miner for this turn.");
                    resources.setMineralFactor(resources.getMineralFactor() * 1.1);
                    crises.get(6).setCurrentCrisisResolutionStatus(true);
                    workers.get(1).setExhaustionStatus(true);
                    isCrisisResolvedThisTurn = true;
                } else {
                    System.out.println("You shouldn't let him have this toy. He is too stupid for that. From now on he will " +
                            "use this drill,\nbut the efficiency will drop by 20%.");
                    workers.get(1).setMineralProduction(workers.get(1).getMineralProduction() * 0.8);
                    workers.get(1).setExhaustionStatus(true);
                    crises.get(6).setCurrentCrisisResolutionStatus(true);
                    isCrisisResolvedThisTurn = true;
                }
                break;
            case "No":
                System.out.println("Your miner is unhappy with your decision. From now on he will eat more.");
                workers.get(1).setFoodRequirements(workers.get(1).getFoodRequirements() * 1.5);
                crises.get(6).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter: Yes or No");
                break;
        }
    }
}
