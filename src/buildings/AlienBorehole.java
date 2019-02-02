package buildings;

import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;

public class AlienBorehole extends Buildings {
    private int boreholeTurnCounter;

    public AlienBorehole(boolean isItBuilt, double upkeep, double cost, int boreholeTurnCounter) {
        super(isItBuilt, upkeep, cost);
        this.boreholeTurnCounter = boreholeTurnCounter;
    }

    public void boreholeOperations(ArrayList<Worker> workers, Resources resources) {
        double mineralsBored = workers.get(1).getBrainPowerProduction() * boreholeTurnCounter * 0.5;
        resources.setMineralResources(resources.getMineralResources() + mineralsBored);
        System.out.printf("Alien borehole produced %.1f minerals.\n", mineralsBored);
        boreholeTurnCounter++;
    }
}
