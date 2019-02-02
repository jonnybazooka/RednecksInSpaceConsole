package buildings;

import aplicationCore.Resources;
import workers.Worker;

import java.util.ArrayList;

public class MoneyPrinter extends Buildings {
    private int moneyPrinterTurnCounter;

    public MoneyPrinter(boolean isItBuilt, double upkeep, double cost, int moneyPrinterTurnCounter) {
        super(isItBuilt, upkeep, cost);
        this.moneyPrinterTurnCounter = moneyPrinterTurnCounter;
    }

    public void moneyPrinterOperations(ArrayList<Worker> workers, Resources resources) {
        double moneyPrinted = workers.get(2).getBrainPowerProduction() * moneyPrinterTurnCounter * 0.5;
        resources.setMoneyResources(resources.getMoneyResources() + moneyPrinted);
        System.out.printf("Alien automated money printer produced %.1f cash.\n", moneyPrinted);
        moneyPrinterTurnCounter++;
    }
}
