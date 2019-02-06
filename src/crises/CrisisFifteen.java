package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Slave;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisFifteen extends Crisis {
    public CrisisFifteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("Your slave have escaped. You must buy a new slave. Send one of your workers to the slave market. " +
                "Who will go? ");
        String whoWillBuyASlave = new Scanner(System.in).nextLine();
        switch (whoWillBuyASlave) {
            case "Farmer":
                workers.get(0).setExhaustionStatus(true);
                Slave dummySlave = Slave.buildSlave();
                workers.get(3).setFoodProduction(dummySlave.getFoodProduction());
                workers.get(3).setMineralProduction(dummySlave.getMineralProduction());
                workers.get(3).setBrainPowerProduction(dummySlave.getBrainPowerProduction());
                workers.get(3).setFoodRequirements(dummySlave.getFoodRequirements());
                workers.get(3).setPayRate(dummySlave.getPayRate());
                double slaveCost = ((workers.get(3).getFoodProduction() + workers.get(3).getMineralProduction() +
                        workers.get(3).getBrainPowerProduction()) / workers.get(0).getBrainPowerProduction());
                resources.setMoneyResources(resources.getMoneyResources() - slaveCost);
                System.out.printf("Purchase was successful. New slave cost you %.1f $$$.\n", slaveCost);
                crises.get(14).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Miner":
                workers.get(1).setExhaustionStatus(true);
                Slave dummySlave2 = Slave.buildSlave();
                workers.get(3).setFoodProduction(dummySlave2.getFoodProduction());
                workers.get(3).setMineralProduction(dummySlave2.getMineralProduction());
                workers.get(3).setBrainPowerProduction(dummySlave2.getBrainPowerProduction());
                workers.get(3).setFoodRequirements(dummySlave2.getFoodRequirements());
                workers.get(3).setPayRate(dummySlave2.getPayRate());
                double slaveCost2 = ((workers.get(3).getFoodProduction() + workers.get(3).getMineralProduction() +
                        workers.get(3).getBrainPowerProduction()) / workers.get(1).getBrainPowerProduction());
                resources.setMoneyResources(resources.getMoneyResources() - slaveCost2);
                System.out.printf("Purchase was successful. New slave cost you %.1f $$$.\n", slaveCost2);
                crises.get(14).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            case "Banker":
                workers.get(2).setExhaustionStatus(true);
                Slave dummySlave3 = Slave.buildSlave();
                workers.get(3).setFoodProduction(dummySlave3.getFoodProduction());
                workers.get(3).setMineralProduction(dummySlave3.getMineralProduction());
                workers.get(3).setBrainPowerProduction(dummySlave3.getBrainPowerProduction());
                workers.get(3).setFoodRequirements(dummySlave3.getFoodRequirements());
                workers.get(3).setPayRate(dummySlave3.getPayRate());
                double slaveCost3 = ((workers.get(3).getFoodProduction() + workers.get(3).getMineralProduction() +
                        workers.get(3).getBrainPowerProduction()) / workers.get(2).getBrainPowerProduction());
                resources.setMoneyResources(resources.getMoneyResources() - slaveCost3);
                System.out.printf("Purchase was successful. New slave cost you %.1f $$$.\n", slaveCost3);
                crises.get(14).setCurrentCrisisResolutionStatus(true);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Enter: Farmer, Miner or Banker.");
                break;
        }
    }
}
