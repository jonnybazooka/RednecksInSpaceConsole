package workers;

import java.util.Scanner;

public class Miner extends Worker {
    public Miner(String job, double payRate, double foodRequirements, double foodProduction, double mineralProduction,
                 double brainPowerProduction, boolean exhaustionStatus) {
        super(job, payRate, foodRequirements, foodProduction, mineralProduction, brainPowerProduction, exhaustionStatus);
    }

    public static Miner buildMiner() {
        Miner myMiner;
        System.out.println("How much minerals is your Miner going to produce? Pick between 3.0 and 6.0 ");
        double minProd = new Scanner(System.in).nextDouble();
        if (minProd < 3.0) {
            minProd = 3.0;
        }
        if (minProd > 6.0) {
            minProd = 6.0;
        }
        System.out.println("How smart is your Miner? Pick between 1.0 and 3.0 ");
        double brainPow = new Scanner(System.in).nextDouble();
        if (brainPow < 1.0) {
            brainPow = 1.0;
        }
        if (brainPow > 3.0) {
            brainPow = 3.0;
        }
        double foodProd = Math.sqrt(18 - (minProd + Math.pow(brainPow, 2.1)));
        double pay = 0.3 * foodProd + 0.2 * minProd + 0.6 * brainPow;
        double foodReq = 0.2 * foodProd + 0.5 * minProd + 0.6 * brainPow;
        myMiner = new Miner("Miner", pay, foodReq, foodProd, minProd, brainPow, false);
        myMiner.introduceWorker();
        return myMiner;
    }
}
