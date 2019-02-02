package aplicationCore;

import buildings.*;
import crises.Crisis;
import workers.Worker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

class Menu {

    private static int turnCounter = 1;

    static void printMenu(ArrayList<Buildings> buildings, Wonder wonder, Resources resources, ArrayList<Worker> workers,
                          ArrayList<Crisis> crises) {
        System.out.println("1 - Check workers abilities.");
        System.out.println("2 - Check resources.");
        System.out.println("3 - Build wonder.");
        if (!Buildings.isBuildingBuiltThisTurn) {
            System.out.println("4 - Build a building.");
        }
        if (!Crisis.isCrisisResolvedThisTurn) {
            System.out.println("5 - Resolve crisis.");
        }
        if (Crisis.isCrisisResolvedThisTurn && !resources.isResourcesProducedThisTurn()) {
            System.out.println("6 - Produce resources.");
        }
        if (buildings.get(9).isItBuilt()) {
            System.out.println("7 - Marketplace.");
        }
        if (Crisis.isCrisisResolvedThisTurn && resources.isResourcesProducedThisTurn()) {
            System.out.println("8 - End turn.");
        }
        System.out.println("9 - Village View");
        int input = new Scanner(System.in).nextInt();
        MenuOptions command = MenuOptions.menuOptionByOrdinal((input-1));
        switch (command) {
            case CHECK_WORKERS_ABILITIES:
                for (Worker worker : workers) {
                    worker.introduceWorker();
                }
                break;
            case CHECK_RESOURCES:
                resources.showResources();
                break;
            case BUILD_WONDER:
                wonder.constructWonder(resources);
                break;
            case BUILD_A_BUILDING:
                Buildings.buildBuilding(buildings, resources, wonder);
                break;
            case RESOLVE_CRISIS:
                if (!Crisis.isCrisisResolvedThisTurn) {
                    Crisis.crisisStatusCheck(crises);
                    int randomCrisisCounter = new Random().nextInt(20) + 1;
                    do {
                        if (!crises.get(randomCrisisCounter).isCurrentCrisisResolutionStatus()) {
                            crises.get(randomCrisisCounter).crisisResolution(crises, workers, resources);
                        }
                    } while (!Crisis.isCrisisResolvedThisTurn);
                    break;
                } else {
                    System.out.println("Crisis has already been resolved this turn.");
                    break;
                }
            case PRODUCE_RESOURCES:
                if (resources.isResourcesProducedThisTurn()) {
                    System.out.println("You have already produced this turn.");
                }
                if (!resources.isResourcesProducedThisTurn() && Crisis.isCrisisResolvedThisTurn) {
                    resources.produceResources(workers);
                }
                if (!Crisis.isCrisisResolvedThisTurn) {
                    System.out.println("You have to resolve crisis first.");
                }
                break;
            case MARKETPLACE:
                if (buildings.get(9).isItBuilt()) {
                    ((Marketplace) buildings.get(9)).marketplace(resources);
                } else {
                    System.out.println("You need to build marketplace to trade.");
                }
                break;
            case END_TURN:
                if (resources.isResourcesProducedThisTurn() && Crisis.isCrisisResolvedThisTurn) {
                    Worker.workerEndTurn(workers, resources);
                    resources.setResourcesProducedThisTurn(false);
                    Crisis.isCrisisResolvedThisTurn = false;
                    Buildings.isBuildingBuiltThisTurn = false;
                    wonder.setWonderBuiltThisTurn(false);

                    double buildingUpkeep = 0;
                    Iterator<Buildings> iterator = buildings.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().isItBuilt()) {
                            buildingUpkeep += iterator.next().getUpkeep();
                        }
                    }
                    resources.setMoneyResources(resources.getMoneyResources() - buildingUpkeep);
                    if (buildings.get(4).isItBuilt()) {
                        ((School) buildings.get(4)).teachWorker(workers);
                    }
                    if (buildings.get(5).isItBuilt()) {
                        ((AlienResourceReplicator) buildings.get(5)).replicateResources(workers, resources);
                    }
                    if (buildings.get(6).isItBuilt()) {
                        ((AlienBorehole) buildings.get(6)).boreholeOperations(workers, resources);
                    }
                    if (buildings.get(7).isItBuilt()) {
                        ((DonkeyFarm) buildings.get(7)).donkeyFarmOperations(workers, resources);
                    }
                    if (buildings.get(8).isItBuilt()) {
                        ((MoneyPrinter) buildings.get(8)).moneyPrinterOperations(workers, resources);
                    }
                    wonder.checkVictoryCondition();
                    resources.checkLoseConditions();
                    if (App.gameContinue) {
                        turnCounter++;
                        System.out.println("TURN " + turnCounter + " BEGINS.");
                }
                } else if (!Crisis.isCrisisResolvedThisTurn) {
                    System.out.println("You have to resolve crisis to end turn.");
                } else if (!resources.isResourcesProducedThisTurn()) {
                    System.out.println("Produce your resources before you end your turn.");
                }
                break;
            case VILLAGE_VIEW:
                Buildings.villageView(buildings, resources, workers);
        }
    }
}
