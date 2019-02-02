package buildings;

import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;

public class DonkeyFarm extends Buildings {
    private int donkeyFarmTurnCounter;

    public DonkeyFarm(boolean isItBuilt, double upkeep, double cost, int donkeyFarmTurnCounter) {
        super(isItBuilt, upkeep, cost);
        this.donkeyFarmTurnCounter = donkeyFarmTurnCounter;
    }

    public void donkeyFarmOperations(ArrayList<Worker> workers, Resources resources) {
        double donkeysMilked = workers.get(0).getBrainPowerProduction() * donkeyFarmTurnCounter * 0.5;
        resources.setFoodResources(resources.getFoodResources() + donkeysMilked);
        System.out.printf("Alien automated donkey farm produced %.1f food.\n", donkeysMilked);
        donkeyFarmTurnCounter++;
    }
}
