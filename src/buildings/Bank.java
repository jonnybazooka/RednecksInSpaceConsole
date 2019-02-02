package buildings;

public class Bank extends Buildings {
    private double moneyFactor;

    public Bank(boolean isItBuilt, double upkeep, double cost, double moneyFactor) {
        super(isItBuilt, upkeep, cost);
        this.moneyFactor = moneyFactor;
    }

    public double getMoneyFactor() {
        return moneyFactor;
    }

    public void setMoneyFactor(double moneyFactor) {
        this.moneyFactor = moneyFactor;
    }
}
