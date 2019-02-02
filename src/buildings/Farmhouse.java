package buildings;

public class Farmhouse extends Buildings {
    private double farmingFactorModifier;

    public Farmhouse(boolean isItBuilt, double upkeep, double cost, double farmingFactorModifier) {
        super(isItBuilt, upkeep, cost);
        this.farmingFactorModifier = farmingFactorModifier;
    }

    public double getFarmingFactorModifier() {
        return farmingFactorModifier;
    }

    public void setFarmingFactorModifier(double farmingFactorModifier) {
        this.farmingFactorModifier = farmingFactorModifier;
    }
}
