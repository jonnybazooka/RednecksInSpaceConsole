package aplicationCore;

import workers.Worker;

import java.util.ArrayList;

public class Resources {

    private double foodResources;
    private double moneyResources;
    private double mineralResources;
    private double farmingFactor;
    private double mineralFactor;
    private double moneyFactor;
    private boolean isResourcesProducedThisTurn;

    public Resources(double foodResources, double moneyResources, double mineralResources, double farmingFactor, double mineralFactor, double moneyFactor, boolean isResourcesProducedThisTurn) {
        this.foodResources = foodResources;
        this.moneyResources = moneyResources;
        this.mineralResources = mineralResources;
        this.farmingFactor = farmingFactor;
        this.mineralFactor = mineralFactor;
        this.moneyFactor = moneyFactor;
        this.isResourcesProducedThisTurn = isResourcesProducedThisTurn;
    }

    public double getFoodResources() {
        return foodResources;
    }

    public void setFoodResources(double foodResources) {
        this.foodResources = foodResources;
    }

    public double getMoneyResources() {
        return moneyResources;
    }

    public void setMoneyResources(double moneyResources) {
        this.moneyResources = moneyResources;
    }

    public double getMineralResources() {
        return mineralResources;
    }

    public void setMineralResources(double mineralResources) {
        this.mineralResources = mineralResources;
    }

    public double getFarmingFactor() {
        return farmingFactor;
    }

    public void setFarmingFactor(double farmingFactor) {
        this.farmingFactor = farmingFactor;
    }

    public double getMineralFactor() {
        return mineralFactor;
    }

    public void setMineralFactor(double mineralFactor) {
        this.mineralFactor = mineralFactor;
    }

    public double getMoneyFactor() {
        return moneyFactor;
    }

    public void setMoneyFactor(double moneyFactor) {
        this.moneyFactor = moneyFactor;
    }

    boolean isResourcesProducedThisTurn() {
        return isResourcesProducedThisTurn;
    }

    void setResourcesProducedThisTurn(boolean resourcesProducedThisTurn) {
        isResourcesProducedThisTurn = resourcesProducedThisTurn;
    }

    void checkLoseConditions(Wonder wonder) {
        if (foodResources < 0 || mineralResources < 0 || moneyResources < 0) {
            System.out.println("YOU HAVE LOST! TRY AGAIN!");
            if (foodResources < 0) {
                System.out.println("You starved your workers to death. You are like Stalin.");
                System.out.println("Your spaceship repair status was: " + wonder.getWonderConstructionProgress() + "/50.");
            }
            if (moneyResources < 0) {
                System.out.println("You don't have money to pay your workers. You are like Kim Jong Un.");
                System.out.println("Your spaceship repair status was: " + wonder.getWonderConstructionProgress() + "/50.");
            }
            App.gameContinue = false;
        }
    }

    void produceResources(ArrayList<Worker> workers) {
        if (!workers.get(0).isExhaustionStatus()) {
            foodResources = foodResources + workers.get(0).getFoodProduction() * farmingFactor;
        } else {
            foodResources = foodResources +
                    Math.max(Math.max(workers.get(1).getFoodProduction(), workers.get(2).getFoodProduction()),
                            workers.get(3).getFoodProduction()) * farmingFactor;
        }
        if (!workers.get(1).isExhaustionStatus()) {
            mineralResources = mineralResources + workers.get(1).getMineralProduction() * mineralFactor;
        } else {
            mineralResources = mineralResources +
                    Math.max(Math.max(workers.get(0).getMineralProduction(), workers.get(2).getMineralProduction()),
                            workers.get(3).getMineralProduction()) * mineralFactor;
        }
        if (!workers.get(2).isExhaustionStatus()) {
            moneyResources = moneyResources + workers.get(2).getBrainPowerProduction() * moneyFactor;
        } else {
            moneyResources = moneyResources +
                    Math.max(Math.max(workers.get(0).getBrainPowerProduction(), workers.get(1).getBrainPowerProduction()),
                            workers.get(3).getBrainPowerProduction()) * moneyFactor;
        }
        isResourcesProducedThisTurn = true;
        System.out.println("Resources produced.");
    }


    void showResources() {
        System.out.printf("Food: %.2f\n", foodResources);
        System.out.printf("Minerals: %.2f\n", mineralResources);
        System.out.printf("Money: %.2f\n", moneyResources);
    }
}
