package crises;

import aplicationCore.Resources;
import workers.Worker;
import java.util.ArrayList;

public class Crisis {

    public static boolean isCrisisResolvedThisTurn = false;

    private boolean currentCrisisResolutionStatus;

    public Crisis(boolean currentCrisisResolutionStatus) {
        this.currentCrisisResolutionStatus = currentCrisisResolutionStatus;
    }

    public boolean isCurrentCrisisResolutionStatus() {
        return currentCrisisResolutionStatus;
    }

    public void setCurrentCrisisResolutionStatus(boolean currentCrisisResolutionStatus) {
        this.currentCrisisResolutionStatus = currentCrisisResolutionStatus;
    }

    public void crisisResolution(ArrayList<Crisis> crises, ArrayList<Worker> workers, Resources resources) {

    }

    public static void crisisStatusCheck(ArrayList<Crisis> crises) {
        if (crises.get(0).isCurrentCrisisResolutionStatus() && crises.get(1).isCurrentCrisisResolutionStatus() &&
                crises.get(2).isCurrentCrisisResolutionStatus() && crises.get(3).isCurrentCrisisResolutionStatus() &&
                crises.get(4).isCurrentCrisisResolutionStatus() && crises.get(5).isCurrentCrisisResolutionStatus() &&
                crises.get(6).isCurrentCrisisResolutionStatus() && crises.get(7).isCurrentCrisisResolutionStatus() &&
                crises.get(8).isCurrentCrisisResolutionStatus() && crises.get(9).isCurrentCrisisResolutionStatus() &&
                crises.get(10).isCurrentCrisisResolutionStatus() && crises.get(11).isCurrentCrisisResolutionStatus() &&
                crises.get(12).isCurrentCrisisResolutionStatus() && crises.get(13).isCurrentCrisisResolutionStatus() &&
                crises.get(14).isCurrentCrisisResolutionStatus() && crises.get(15).isCurrentCrisisResolutionStatus() &&
                crises.get(16).isCurrentCrisisResolutionStatus() && crises.get(17).isCurrentCrisisResolutionStatus() &&
                crises.get(18).isCurrentCrisisResolutionStatus() && crises.get(19).isCurrentCrisisResolutionStatus()) {
            for (Crisis crisis : crises) {
                crisis.setCurrentCrisisResolutionStatus(false);
            }
        }
    }
}
