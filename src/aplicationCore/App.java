package aplicationCore;

import buildings.*;
import crises.Crisis;
import crises.*;
import workers.*;
import java.util.ArrayList;

public class App {

    private static Resources resources = null;
    static boolean gameContinue = true;

    public static void main(String[] args) {

        Introduction.introduction();

        ArrayList<Worker> workers = workersSetup();
        ArrayList<Buildings> buildings = buildingsSetup();
        ArrayList<Crisis> crises = crisesSetup();

        Wonder wonder = new Wonder(0, 1, false);
        do {
            try {
                resources = Difficulty.selectDifficultyLevel();
            } catch (Exception e) {
                System.out.println("Do not troll!");
            }

        } while (resources == null);

        do {
            try {
                Menu.printMenu(buildings, wonder, resources, workers, crises);
            } catch (Exception e) {
                System.out.println("Do not troll!");
            }

        } while (gameContinue);
    }

    private static ArrayList<Buildings> buildingsSetup() {
        Farmhouse farmhouse = new Farmhouse(false, 1, 5, 1.5);
        DeepMine deepMine = new DeepMine(false, 1.5, 8, 1.5);
        Bank bank = new Bank(false, 2, 8, 1.5);
        WonderCrane wonderCrane = new WonderCrane(false, 1, 5, 1.5);
        School school = new School(false, 1.5, 5);
        AlienResourceReplicator alienResourceReplicator = new AlienResourceReplicator(false, 2, 5);
        AlienBorehole alienBorehole = new AlienBorehole(false, 2, 8, 1);
        DonkeyFarm donkeyFarm = new DonkeyFarm(false, 2, 8, 1);
        MoneyPrinter moneyPrinter = new MoneyPrinter(false, 3, 10, 1);
        Marketplace marketplace = new Marketplace(false, 1, 5);
        ArrayList<Buildings> buildings = new ArrayList<>();
        buildings.add(0,farmhouse);
        buildings.add(1, deepMine);
        buildings.add(2, bank);
        buildings.add(3, wonderCrane);
        buildings.add(4, school);
        buildings.add(5, alienResourceReplicator);
        buildings.add(6, alienBorehole);
        buildings.add(7, donkeyFarm);
        buildings.add(8, moneyPrinter);
        buildings.add(9, marketplace);
        return buildings;
    }

    private static ArrayList<Worker> workersSetup() {
        boolean areWorkersSetUp = false;
        ArrayList<Worker> workers = new ArrayList<>();
        do {
            try {
                workers.add(0, Farmer.buildFarmer());
                workers.add(1, Miner.buildMiner());
                workers.add(2, Banker.buildBanker());
                workers.add(3, Slave.buildSlave());
                areWorkersSetUp = true;
            } catch (Exception e) {
                System.out.println("Do not troll!");
            }
        } while (!areWorkersSetUp);
        return workers;
    }

    private static ArrayList<Crisis> crisesSetup() {
        ArrayList<Crisis> crises = new ArrayList<>();
        crises.add(0, new CrisisOne(false));
        crises.add(1, new CrisisTwo(false));
        crises.add(2, new CrisisThree(false));
        crises.add(3, new CrisisFour(false));
        crises.add(4, new CrisisFive(false));
        crises.add(5, new CrisisSix(false));
        crises.add(6, new CrisisSeven(false));
        crises.add(7, new CrisisEight(false));
        crises.add(8, new CrisisNine(false));
        crises.add(9, new CrisisTen(false));
        crises.add(10, new CrisisEleven(false));
        crises.add(11, new CrisisTwelve(false));
        crises.add(12, new CrisisThirteen(false));
        crises.add(13, new CrisisFourteen(false));
        crises.add(14, new CrisisFifteen(false));
        crises.add(15, new CrisisSixteen(false));
        crises.add(16, new CrisisSeventeen(false));
        crises.add(17, new CrisisEighteen(false));
        crises.add(18, new CrisisNineteen(false));
        crises.add(19, new CrisisTwenty(false));
        return crises;
    }
}






