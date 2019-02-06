package workers;

import java.util.Scanner;

public class Farmer extends Worker{

    public Farmer(String job, double payRate, double foodRequirements, double foodProduction, double mineralProduction,
                  double brainPowerProduction, boolean exhaustionStatus) {
        super(job, payRate, foodRequirements, foodProduction, mineralProduction, brainPowerProduction, exhaustionStatus);
    }

    public static Farmer buildFarmer() {
        Farmer myFarmer;
        System.out.println("How much food is your Farmer going to produce? Pick between 3.0 and 6.0 ");
        double foodProd = new Scanner(System.in).nextDouble();
        if (foodProd < 3.0) {
            foodProd = 3.0;
        }
        if (foodProd > 6.0) {
            foodProd = 6.0;
        }
        System.out.println("How smart is your Farmer? Pick between 1.0 and 3.0 ");
        double brainPow = new Scanner(System.in).nextDouble();
        if (brainPow < 1.0) {
            brainPow = 1.0;
        }
        if (brainPow > 3.0) {
            brainPow = 3.0;
        }
        double minProd = Math.sqrt(19 - (foodProd + Math.pow(brainPow, 2.2)));
        double pay = 0.3 * foodProd + 0.3 * minProd + 0.6 * brainPow;
        double foodReq = 0.2 * foodProd + 0.3 * minProd + 0.8 * brainPow;
        myFarmer = new Farmer("Farmer", pay, foodReq, foodProd, minProd, brainPow, false);
        myFarmer.introduceWorker();
        return myFarmer;
    }
}
