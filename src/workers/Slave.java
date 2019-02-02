package workers;

import java.util.Scanner;

public class Slave extends Worker {
    public Slave(String job, double payRate, double foodRequirements, double foodProduction, double mineralProduction,
                 double brainPowerProduction, boolean exhaustionStatus) {
        super(job, payRate, foodRequirements, foodProduction, mineralProduction, brainPowerProduction, exhaustionStatus);
    }

    public static Slave buildSlave() {
        Slave mySlave;
        System.out.println("How much food is your Slave going to produce? Pick between 2.0 and 4.0 ");
        double foodProd = new Scanner(System.in).nextDouble();
        if (foodProd < 2.0) {
            foodProd = 2.0;
        }
        if (foodProd > 4.0) {
            foodProd = 4.0;
        }
        System.out.println("How much minerals is your Slave going to produce? Pick between 2.0 and 4.0 ");
        double minProd = new Scanner(System.in).nextDouble();
        if (minProd < 2.0) {
            minProd = 2.0;
        }
        if (minProd > 4.0) {
            minProd = 4.0;
        }
        System.out.println("How smart is your Slave? Pick between 1.0 and 2.0 ");
        double brainPow = new Scanner(System.in).nextDouble();
        if (brainPow < 1.0) {
            brainPow = 1.0;
        }
        if (brainPow > 2.0) {
            brainPow = 2.0;
        }
        double pay = 0.1 * foodProd + 0.1 * minProd + 0.3 * brainPow;
        double foodReq = 0.1 * Math.pow(foodProd, 2) + 0.1 * Math.pow(minProd, 2) + 0.4 * Math.pow(brainPow, 2);
        mySlave = new Slave("Slave", pay, foodReq, foodProd, minProd, brainPow, false);
        mySlave.introduceWorker();
        return mySlave;
    }
}
