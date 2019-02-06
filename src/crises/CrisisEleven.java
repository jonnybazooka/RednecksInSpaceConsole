package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class CrisisEleven extends Crisis {
    public CrisisEleven(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("Great wages inflation is coming. Your banker will combat it but you can spend cash to make " +
                "his struggle easier. You can spend 0 - 10 cash to make your chances better. How much would you like to spend?");
        double inflationMoney = new Scanner(System.in).nextDouble();
        if (inflationMoney > 10) {
            inflationMoney = 10;
        }
        if (inflationMoney < 0) {
            inflationMoney = 0;
        }
        double wagesInflation = ((40 - (workers.get(2).getBrainPowerProduction() * inflationMoney)) / 40);
        workers.get(0).setPayRate(workers.get(0).getPayRate() * (1 + wagesInflation));
        workers.get(1).setPayRate(workers.get(1).getPayRate() * (1 + wagesInflation));
        workers.get(2).setPayRate(workers.get(2).getPayRate() * (1 + wagesInflation));
        workers.get(3).setPayRate(workers.get(3).getPayRate() * (1 + wagesInflation));
        System.out.println("Your worker's wages have increased by " + (wagesInflation * 100) + " %.");
        resources.setMoneyResources(resources.getMoneyResources() - inflationMoney);
        if (resources.getMoneyResources() < 0) {
            System.out.println("Warning. Your cash reserves are on debit.");
        }
        crises.get(10).setCurrentCrisisResolutionStatus(true);
        isCrisisResolvedThisTurn = true;
    }
}
