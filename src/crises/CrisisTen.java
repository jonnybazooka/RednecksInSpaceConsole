package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisTen extends Crisis {
    public CrisisTen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        System.out.println("Your banker have developed new method of work organization. He is eager to test it on a farm " +
                "or on a mine. Choose one.");
        String farmOrMine = new Scanner(System.in).nextLine();
        switch (farmOrMine) {
            case "farm":
                double changeFactor = (workers.get(2).getBrainPowerProduction() - 3) / 2;
                resources.setFarmingFactor(resources.getFarmingFactor() + changeFactor);
                if (changeFactor > 0) {
                    System.out.printf("Your farm production has improved by %.1f percent.\n", (changeFactor * 100));
                } else if (changeFactor == 0) {
                    System.out.println("Unfortunately new method didn't improve anything.");
                } else {
                    System.out.printf("Your farm production has dropped by %.1f percent. Oops.\n", (changeFactor * 100));
                }
                System.out.println("Since your banker was busy implementing new method, he cannot produce cash this turn.");
                workers.get(2).setExhaustionStatus(true);
                crises.get(9).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "mine":
                double changeFactor2 = (workers.get(2).getBrainPowerProduction() - 3) / 2;
                resources.setMineralFactor(resources.getMineralFactor() + changeFactor2);
                if (changeFactor2 > 0) {
                    System.out.printf("Your mine production has improved by %.1f percent.\n", (changeFactor2 * 100));
                } else if (changeFactor2 == 0) {
                    System.out.println("Unfortunately new method didn't improve anything.");
                } else {
                    System.out.printf("Your mine production has dropped by %.1f percent. Oops.\n", (changeFactor2 * 100));
                }
                System.out.println("Since your banker was busy implementing new method, he cannot produce cash this turn.");
                workers.get(2).setExhaustionStatus(true);
                crises.get(9).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter farm or mine. Lower case letters only.");
                break;
        }
    }
}
