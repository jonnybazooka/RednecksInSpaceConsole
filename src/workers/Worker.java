package workers;

import aplicationCore.Resources;

import java.util.ArrayList;

public class Worker {

    private String job;
    private double payRate;
    private double foodRequirements;
    private double foodProduction;
    private double mineralProduction;
    private double brainPowerProduction;
    private boolean exhaustionStatus;

    public Worker(String job, double payRate, double foodRequirements, double foodProduction, double mineralProduction, double brainPowerProduction, boolean exhaustionStatus) {
        this.job = job;
        this.payRate = payRate;
        this.foodRequirements = foodRequirements;
        this.foodProduction = foodProduction;
        this.mineralProduction = mineralProduction;
        this.brainPowerProduction = brainPowerProduction;
        this.exhaustionStatus = exhaustionStatus;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getFoodRequirements() {
        return foodRequirements;
    }

    public void setFoodRequirements(double foodRequirements) {
        this.foodRequirements = foodRequirements;
    }

    public double getFoodProduction() {
        return foodProduction;
    }

    public void setFoodProduction(double foodProduction) {
        this.foodProduction = foodProduction;
    }

    public double getMineralProduction() {
        return mineralProduction;
    }

    public void setMineralProduction(double mineralProduction) {
        this.mineralProduction = mineralProduction;
    }

    public double getBrainPowerProduction() {
        return brainPowerProduction;
    }

    public void setBrainPowerProduction(double brainPowerProduction) {
        this.brainPowerProduction = brainPowerProduction;
    }

    public boolean isExhaustionStatus() {
        return exhaustionStatus;
    }

    public void setExhaustionStatus(boolean exhaustionStatus) {
        this.exhaustionStatus = exhaustionStatus;
    }

    public void introduceWorker() {
        System.out.printf("I'm a " + "%s" + "\nFood production: " + "%.2f" + "\nMineral production: "
                        + "%.2f" + "\nBrain power: " + "%.2f" + "\nMy pay is: " + "%.2f"
                        + "\nI eat: " + "%.2f" + " food.\n\n", getJob(), getFoodProduction(), getMineralProduction(), getBrainPowerProduction(),
                getPayRate(), getFoodRequirements());
    }

    public static void workerEndTurn(ArrayList<Worker> workers, Resources resources) {
        double foodIntake = 0;
        double wages = 0;
        for (Worker worker : workers) {
            worker.setExhaustionStatus(false);
            foodIntake += worker.getFoodRequirements();
            wages += worker.getPayRate();
        }
        resources.setFoodResources(resources.getFoodResources() - foodIntake);
        resources.setMoneyResources(resources.getMoneyResources() - wages);
    }
}
