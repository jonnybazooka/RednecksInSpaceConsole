package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisSeventeen extends Crisis {
    public CrisisSeventeen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("Crazy cookie monster attacks your village. You must feed him. How much food will you give him?");
        System.out.println("Choose between 0 and " + resources.getFoodResources() + ".");
        double foodForMonster = new Scanner(System.in).nextDouble();
        if (foodForMonster < 0) {
            foodForMonster = 0;
        }
        if (foodForMonster > resources.getFoodResources()) {
            foodForMonster = resources.getFoodResources();
        }
        double memoryNumber = resources.getFarmingFactor();
        for (int i = 10; i > foodForMonster; i--) {
            resources.setFarmingFactor(resources.getFarmingFactor() - ((i - foodForMonster) / 100));
            resources.setMineralFactor(resources.getMineralFactor() - ((i - foodForMonster) / 100));
            resources.setMoneyFactor(resources.getMoneyFactor() - ((i - foodForMonster) / 100));
        }
        double totalDamage = (memoryNumber - resources.getFarmingFactor()) * 10;
        System.out.printf("Your village have sustained %.1f percent damage.\n", totalDamage * 10);
        isCrisisResolvedThisTurn = true;
    }
}
