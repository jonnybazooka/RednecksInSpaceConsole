package buildings;

public class WonderCrane extends Buildings {
    private double wonderBuildEfficiency;

    public WonderCrane(boolean isItBuilt, double upkeep, double cost, double wonderBuildEfficiency) {
        super(isItBuilt, upkeep, cost);
        this.wonderBuildEfficiency = wonderBuildEfficiency;
    }

    public double getWonderBuildEfficiency() {
        return wonderBuildEfficiency;
    }

    public void setWonderBuildEfficiency(double wonderBuildEfficiency) {
        this.wonderBuildEfficiency = wonderBuildEfficiency;
    }
}
