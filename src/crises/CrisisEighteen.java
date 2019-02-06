package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CrisisEighteen extends Crisis {
    public CrisisEighteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("The alien spaceship kidnapped one of your workers to do some tests. Don't worry, he " +
                "will be back next turn. \nType 'kidnapper' to see who was kidnapped.");
        String button = new Scanner(System.in).nextLine();
        if (button.equals("kidnapper")) {
            Random abductor = new Random();
            int abductee = abductor.nextInt(4) + 1;
            if (abductee == 1) {
                System.out.println("Your Farmer has been kidnapped.");
                workers.get(0).setExhaustionStatus(true);
                crises.get(17).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else if (abductee == 2) {
                System.out.println("Your Miner has been kidnapped.");
                workers.get(1).setExhaustionStatus(true);
                crises.get(17).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else if (abductee == 3) {
                System.out.println("Your Banker has been kidnapped.");
                workers.get(2).setExhaustionStatus(true);
                crises.get(17).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            } else {
                System.out.println("Your Slave has been kidnapped. He will return smarter. But he will eat much more.");
                workers.get(3).setExhaustionStatus(true);
                workers.get(3).setBrainPowerProduction(workers.get(3).getBrainPowerProduction() * 2);
                workers.get(3).setFoodRequirements(workers.get(3).getFoodRequirements() * 2);
                crises.get(17).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
            }
        } else {
            System.out.println("Enter: kidnapper.");
        }
    }
}
