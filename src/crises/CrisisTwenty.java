package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisTwenty extends Crisis {
    public CrisisTwenty(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("A drug dealer arrived to your village. You can buy an ecstasy pill for 5 $ or a dose of " +
                "heroin for 8 $? What would you like?");
        System.out.println("1 - Ecstasy");
        System.out.println("2 - Heroin");
        System.out.println("3 - Nothing, you don't take drugs.");
        int drugChoice = new Scanner(System.in).nextInt();
        switch (drugChoice) {
            case 1:
                System.out.println("Ecstasy is an excellent choice. Who should take it?");
                String drugUser = new Scanner(System.in).nextLine();
                switch (drugUser) {
                    case "Farmer":
                        System.out.println("Your farmer has become more energetic and farms better. But his brain " +
                                "suffered some damage.");
                        workers.get(0).setFoodProduction(workers.get(0).getFoodProduction() * 1.5);
                        workers.get(0).setBrainPowerProduction(workers.get(0).getBrainPowerProduction() * 0.75);
                        resources.setMoneyResources(resources.getMoneyResources() - 5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Miner":
                        System.out.println("Your miner has become more energetic and mines better. But his brain " +
                                "suffered some damage.");
                        workers.get(1).setMineralProduction(workers.get(1).getMineralProduction() * 1.5);
                        workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 0.75);
                        resources.setMoneyResources(resources.getMoneyResources() - 5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Banker":
                        System.out.println("Your banker loves ecstasy. His brainpower has increased, but he became an " +
                                "addict, and you have to pay him more from now on, so he can afford drugs.");
                        workers.get(2).setBrainPowerProduction(workers.get(2).getBrainPowerProduction() * 1.5);
                        workers.get(2).setPayRate(workers.get(2).getPayRate() * 1.5);
                        resources.setMoneyResources(resources.getMoneyResources() - 5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Slave":
                        System.out.println("Your slave don't do drugs. He spilled it out and flushed the toilet. " +
                                "You just lost money.");
                        resources.setMoneyResources(resources.getMoneyResources() - 5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    default:
                        System.out.println("Enter: Farmer, Miner, Banker or Slave.");
                        break;
                }
                break;
            case 2:
                System.out.println("Heroin is an excellent choice. Who should take it?");
                String drugUser2 = new Scanner(System.in).nextLine();
                switch (drugUser2) {
                    case "Farmer":
                        System.out.println("Heroin unlocked new circuits in Farmer's brain. He became smarter, but " +
                                "also much more hungry.");
                        resources.setMoneyResources(resources.getMoneyResources() - 8);
                        workers.get(0).setBrainPowerProduction(workers.get(0).getBrainPowerProduction() * 1.5);
                        workers.get(0).setFoodRequirements(workers.get(0).getFoodRequirements() * 1.5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Miner":
                        System.out.println("Heroin unlocked new circuits in Miner's brain. He became smarter, but " +
                                "also much more hungry.");
                        resources.setMoneyResources(resources.getMoneyResources() - 8);
                        workers.get(1).setBrainPowerProduction(workers.get(1).getBrainPowerProduction() * 1.5);
                        workers.get(1).setFoodRequirements(workers.get(1).getFoodRequirements() * 1.5);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Banker":
                        System.out.println("Heroin unlocked new circuits in Banker's brain. He became smarter, but " +
                                "also much more hungry. He's also addicted now, so you much pay him more.");
                        resources.setMoneyResources(resources.getMoneyResources() - 8);
                        workers.get(2).setBrainPowerProduction(workers.get(2).getBrainPowerProduction() * 2);
                        workers.get(2).setFoodRequirements(workers.get(2).getFoodRequirements() * 1.5);
                        workers.get(2).setPayRate(workers.get(2).getPayRate() * 2);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    case "Slave":
                        System.out.println("Your slave don't do drugs. He spilled it out and flushed the toilet. You" +
                                " just lost your money.");
                        resources.setMoneyResources(resources.getMoneyResources() - 8);
                        crises.get(19).setCurrentCrisisResolutionStatus(true);
                        isCrisisResolvedThisTurn = true;
                        break;
                    default:
                        System.out.println("You must enter: Farmer, Miner, Banker or Slave.");
                        break;
                }
                break;
            case 3:
                System.out.println("It's smart not to take drugs. Drug dealer leaves your village unhappy.");
                resources.setMoneyResources(resources.getMoneyResources() - 8);
                isCrisisResolvedThisTurn = true;
                break;
            default:
                System.out.println("Select option 1, 2 or 3.");
                break;
        }
    }
}
