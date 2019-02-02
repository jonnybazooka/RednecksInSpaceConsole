package buildings;

import workers.Worker;

import java.util.ArrayList;
import java.util.Scanner;

public class School extends Buildings {
    public School(boolean isItBuilt, double upkeep, double cost) {
        super(isItBuilt, upkeep, cost);
    }

    public void teachWorker(ArrayList<Worker> workers) {
        System.out.println("Your school is built. One worker will now learn something new. Who do you send to school?");
        System.out.println("1 - Farmer");
        System.out.println("2 - Miner");
        System.out.println("3 - Banker");
        int student = new Scanner(System.in).nextInt();
        switch (student) {
            case 1:
                workers.get(0).setFoodProduction(workers.get(0).getFoodProduction() +
                        ((workers.get(0).getFoodProduction() + workers.get(0).getBrainPowerProduction() * 2) /
                                (workers.get(0).getFoodProduction() + 1)));
                System.out.println("Your farmer is better now.");
                break;
            case 2:
                workers.get(1).setMineralProduction(workers.get(1).getMineralProduction() +
                        ((workers.get(1).getMineralProduction() + workers.get(1).getBrainPowerProduction() * 2) /
                                (workers.get(1).getMineralProduction() + 1)));
                System.out.println("Your miner is better now.");
                break;
            case 3:
                workers.get(2).setBrainPowerProduction(workers.get(2).getBrainPowerProduction() +
                        (Math.sqrt(workers.get(2).getBrainPowerProduction() - 0.5)));
                System.out.println("Your banker is better now.");
                break;
            default:
                System.out.println("Enter: 1, 2 or 3.");
                teachWorker(workers);
                break;
        }
    }
}
