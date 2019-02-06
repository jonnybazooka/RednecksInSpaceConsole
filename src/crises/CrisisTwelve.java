package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisTwelve extends Crisis {
    public CrisisTwelve(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("Your banker has became paranoid. He doesn't want to leave anymore to do outside works. But his efficiency " +
                "as a banker will improve.\nYou just need to feed him better. Choose how many percent more food he will eat (0 - 100).");
        double greatHunger = new Scanner(System.in).nextDouble();
        if (greatHunger < 0) {
            greatHunger = 0;
        }
        if (greatHunger > 100) {
            greatHunger = 100;
        }
        workers.get(2).setFoodRequirements(workers.get(2).getFoodRequirements() * (1 + (greatHunger/100)));
        workers.get(2).setFoodProduction(workers.get(2).getFoodProduction() * 0.3);
        workers.get(2).setMineralProduction(workers.get(2).getMineralProduction() * 0.3);
        resources.setMoneyFactor(resources.getMoneyFactor() + (greatHunger/100));
        crises.get(11).setCurrentCrisisResolutionStatus(true);
        isCrisisResolvedThisTurn = true;
    }
}
