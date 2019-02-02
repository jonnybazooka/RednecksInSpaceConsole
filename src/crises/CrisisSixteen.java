package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisSixteen extends Crisis {
    public CrisisSixteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your slave prepared some sabotage. He stole some dynamite from the mine and rigged your resource " +
                "\ndepot and your farm and mine machinery. You have time to stop only one explosion. What will you save?");
        System.out.println("1 - Resource Depot.");
        System.out.println("2 - Farm and Mine machinery.");
        int savingChoice = new Scanner(System.in).nextInt();
        switch (savingChoice) {
            case 1:
                double damage = (workers.get(3).getBrainPowerProduction() * 1.5) / 10;
                resources.setFarmingFactor(resources.getFarmingFactor() - damage);
                resources.setMineralFactor(resources.getMineralFactor() - damage);
                System.out.printf("Your farming and mine efficiency have dropped by %.1f percent.\n", damage * 100);
                crises.get(15).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case 2:
                double damage2 = ((workers.get(3).getBrainPowerProduction() * 25) / 100);
                resources.setFoodResources(resources.getFoodResources() * (1 - damage2));
                resources.setMineralResources(resources.getMineralResources() * (1 - damage2));
                System.out.printf("You have lost %.1f percent food and minerals in the blast.\n", damage2 * 100);
                crises.get(15).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter: 1 or 2.");
                break;
        }
    }
}
