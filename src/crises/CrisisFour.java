package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisFour extends Crisis {
    public CrisisFour(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {

            System.out.println("Your Farmer want's to educate himself to become a better professional. " +
                    "How much money will you spend on his education?");
            System.out.println("Choose between 0 and " + resources.getMoneyResources());
            double educationCash = new Scanner(System.in).nextDouble();
            if (educationCash > resources.getMoneyResources()) {
                educationCash = resources.getMoneyResources();
            }
            if (educationCash < 0) {
                educationCash = 0;
            }
            if (educationCash > 0) {
                System.out.println("Your farmer improved his skills, but he cannot produce this turn.");
                workers.get(0).setFoodProduction(workers.get(0).getFoodProduction() * (1 + educationCash / 20));
                crises.get(3).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else {
                System.out.println("Your sad farmer goes back home. He refuses to produce this turn.");
                workers.get(0).setExhaustionStatus(true);
                crises.get(3).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            }
    }
}
