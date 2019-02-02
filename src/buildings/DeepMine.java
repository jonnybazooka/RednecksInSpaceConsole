package buildings;

public class DeepMine extends Buildings {
    private double mineralFactor;

    public DeepMine(boolean isItBuilt, double upkeep, double cost, double mineralFactor) {
        super(isItBuilt, upkeep, cost);
        this.mineralFactor = mineralFactor;
    }

    public double getMineralFactor() {
        return mineralFactor;
    }

    public void setMineralFactor(double mineralFactor) {
        this.mineralFactor = mineralFactor;
    }
}
