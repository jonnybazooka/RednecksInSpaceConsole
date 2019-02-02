package buildings;

import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;
import java.util.Random;

public class AlienResourceReplicator extends Buildings {
    public AlienResourceReplicator(boolean isItBuilt, double upkeep, double cost) {
        super(isItBuilt, upkeep, cost);
    }

    public void replicateResources(ArrayList<Worker> workers, Resources resources) {
        int resourceRandomizer = new Random().nextInt(3) + 1;
        switch (resourceRandomizer) {
            case 1:
                double foodReplicator = new Random().nextInt(5) + 1;
                double replicatedResources = Math.sqrt((foodReplicator * workers.get(1).getBrainPowerProduction() * 2)) + 1;
                resources.setFoodResources(resources.getFoodResources() + replicatedResources);
                System.out.printf("Alien Resources Replicator produced %.1f food.\n", replicatedResources);
                break;
            case 2:
                double mineralReplicator = new Random().nextInt(5) + 1;
                double replicatedMinerals = Math.sqrt((mineralReplicator * workers.get(1).getBrainPowerProduction() * 2)) + 1;
                resources.setMineralResources(resources.getMineralResources() + replicatedMinerals);
                System.out.printf("Alien Resources Replicator produced %.1f minerals.\n", replicatedMinerals);
                break;
            case 3:
                double moneyReplicator = new Random().nextInt(5) + 1;
                double replicatedMoney = Math.sqrt((moneyReplicator * workers.get(1).getBrainPowerProduction() * 2)) + 1;
                resources.setMoneyResources(resources.getMoneyResources() + replicatedMoney);
                System.out.printf("Alien Resources Replicator produced %.1f cash.\n", replicatedMoney);
                break;
            default:
                System.out.println("Something is seriously wrong with replicator. Call your programmer.");
                break;
        }
    }
}
