package aplicationCore;

public class Wonder {

    private double wonderConstructionProgress;
    private double wonderBuildEfficiency;
    private boolean wonderBuiltThisTurn;

    Wonder(double wonderConstructionProgress, double wonderBuildEfficiency, boolean wonderBuiltThisTurn) {
        this.wonderConstructionProgress = wonderConstructionProgress;
        this.wonderBuildEfficiency = wonderBuildEfficiency;
        this.wonderBuiltThisTurn = wonderBuiltThisTurn;
    }

    public double getWonderConstructionProgress() {
        return wonderConstructionProgress;
    }

    public void setWonderConstructionProgress(double wonderConstructionProgress) {
        this.wonderConstructionProgress = wonderConstructionProgress;
    }

    public double getWonderBuildEfficiency() {
        return wonderBuildEfficiency;
    }

    public void setWonderBuildEfficiency(double wonderBuildEfficiency) {
        this.wonderBuildEfficiency = wonderBuildEfficiency;
    }

    public boolean isWonderBuiltThisTurn() {
        return wonderBuiltThisTurn;
    }

    void setWonderBuiltThisTurn(boolean wonderBuiltThisTurn) {
        this.wonderBuiltThisTurn = wonderBuiltThisTurn;
    }

    void constructWonder(Resources resources) {
        if (resources.getMineralResources() >= 5 && !wonderBuiltThisTurn) {
            wonderConstructionProgress = wonderConstructionProgress + (5 * wonderBuildEfficiency);
            resources.setMineralResources(resources.getMineralResources() - 5);
            System.out.println("You are closer to victory. Your wonder progress is: " + wonderConstructionProgress + "/50");
            wonderBuiltThisTurn = true;
        } else if (wonderBuiltThisTurn) {
            System.out.println("You have already built wonder this turn.");
        } else if (resources.getMineralResources() < 5) {
            System.out.println("Not enough minerals.");
        }
    }

    void checkVictoryCondition() {
        if (wonderConstructionProgress >= 50) {
            System.out.println("CONGRATULATIONS! YOU HAVE WON!");
            App.gameContinue = false;
        }
    }
}
