package crises;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;
import java.util.Scanner;

public class CrisisNineteen extends Crisis {
    public CrisisNineteen(boolean currentCrisisResolutionStatus) {
        super(currentCrisisResolutionStatus);
    }

    @Override
    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {
        ClearScreen.clearConsoleScreen();
        System.out.println("A gypsy caravan arrived to your village. You have a rare opportunity to trade your resources.");
        boolean continueTrading = true;
        do {
            System.out.println("1 - Check your resources.");
            System.out.println("2 - Sell.");
            System.out.println("3 - Buy.");
            System.out.println("4 - End trading.");
            int tradingMenu = new Scanner(System.in).nextInt();
            switch (tradingMenu) {
                case 1:
                    System.out.printf("Food: %.2f\n", resources.getFoodResources());
                    System.out.printf("Minerals: %.2f\n", resources.getMineralResources());
                    System.out.printf("Money: %.2f\n", resources.getMoneyResources());
                    break;
                case 2:
                    System.out.println("1 - Sell food: 1 for 1 $.");
                    System.out.println("2 - Sell minerals: 1 for 1.3 $");
                    System.out.println("3 - End trading.");
                    int sellingMenu = new Scanner(System.in).nextInt();
                    switch (sellingMenu) {
                        case 1:
                            System.out.println("How much food do you want to sell?");
                            double soldFood = new Scanner(System.in).nextDouble();
                            if (soldFood > resources.getFoodResources()) {
                                soldFood = resources.getFoodResources();
                            }
                            if (soldFood < 0) {
                                soldFood = 0;
                            }
                            resources.setFoodResources(resources.getFoodResources() - soldFood);
                            resources.setMoneyResources(resources.getMoneyResources() + soldFood);
                            System.out.println("Transaction successful.");
                            break;
                        case 2:
                            System.out.println("How much resources do you want to sell?");
                            double soldResources = new Scanner(System.in).nextDouble();
                            if (soldResources > resources.getMineralResources()) {
                                soldResources = resources.getMineralResources();
                            }
                            if (soldResources < 0) {
                                soldResources = 0;
                            }
                            resources.setMineralResources(resources.getMineralResources() - soldResources);
                            resources.setMoneyResources(resources.getMoneyResources() + (soldResources * 1.3));
                            System.out.println("Transaction successful.");
                            break;
                        default:
                            System.out.println("Cannot process that.");
                            break;
                    }
                case 3:
                    System.out.println("1 - Buy food: 1 for 1.5 $.");
                    System.out.println("2 - Buy minerals: 1 for 2 $.");
                    System.out.println("3 - End trading.");
                    int buyingMenu = new Scanner(System.in).nextInt();
                    switch (buyingMenu) {
                        case 1:
                            System.out.println("How much food do you want to buy?");
                            double boughtFood = new Scanner(System.in).nextDouble();
                            if (boughtFood < 0) {
                                boughtFood = 0;
                            }
                            resources.setFoodResources(resources.getFoodResources() + boughtFood);
                            resources.setMoneyResources(resources.getMoneyResources() - (boughtFood * 1.5));
                            System.out.println("Transaction successful.");
                            if (resources.getMoneyResources() < 0) {
                                System.out.println("Warning. You are on a debit.");
                            }
                            break;
                        case 2:
                            System.out.println("How much resources do you want to buy?");
                            double boughtResources = new Scanner(System.in).nextDouble();
                            if (boughtResources < 0) {
                                boughtResources = 0;
                            }
                            resources.setMineralResources(resources.getMineralResources() + boughtResources);
                            resources.setMoneyResources(resources.getMoneyResources() - (boughtResources * 2));
                            System.out.println("Transaction successful.");
                            if (resources.getMoneyResources() < 0) {
                                System.out.println("Warning. You are on a debit.");
                            }
                            break;
                        default:
                            System.out.println("Cannot process that.");
                            break;
                    }
                case 4:
                    continueTrading = false;
                    break;
                default:
                    System.out.println("Cannot process that.");
                    break;
            }
        } while (continueTrading);
        crises.get(18).setCurrentCrisisResolutionStatus(true);
        isCrisisResolvedThisTurn = true;
    }
}
