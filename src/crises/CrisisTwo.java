package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisTwo extends Crisis {
    public CrisisTwo(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        do {
            System.out.println("Your crops has been attacked by a very ferocious breed of potato beetle. If your farmer is " +
                    "smart enough, he may be able to exterminate it, but he won't be able to work his farm this turn.\n Otherwise " +
                    "some crops will be eaten and production will be permanently damaged. Do you wish to send your farmer? Yes or No");
            String decision = new Scanner(System.in).nextLine();
            if (decision.equals("Yes") && workers.get(0).getBrainPowerProduction() > 2) {
                System.out.println("Good job. Potato beetle has been eradicated, and your farmer just got a little bit smarter.");
                workers.get(0).setBrainPowerProduction(workers.get(0).getBrainPowerProduction() * 1.1);
                workers.get(0).setExhaustionStatus(true);
                crises.get(1).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else if (decision.equals("Yes") && workers.get(0).getBrainPowerProduction() <= 2) {
                System.out.println("Unfortunately your farmer wasn't strong enough, but prevented some damage. You will suffer the consequences.");
                workers.get(0).setExhaustionStatus(true);
                resources.setFarmingFactor(resources.getFarmingFactor() * (workers.get(0).getBrainPowerProduction() / 10));
                crises.get(1).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else if (decision.equals("No")) {
                System.out.println("Potato beetle did great damage");
                resources.setFarmingFactor(resources.getFarmingFactor() * 0.6);
                resources.setFoodResources(resources.getFoodResources() * 0.6);
                crises.get(1).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            }
        } while (!isCrisisResolvedThisTurn);
    }
}
