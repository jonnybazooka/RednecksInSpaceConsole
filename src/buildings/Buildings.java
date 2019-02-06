package buildings;

import aplicationCore.ClearScreen;
import aplicationCore.Resources;
import aplicationCore.Wonder;
import workers.Worker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Buildings {

    public static boolean isBuildingBuiltThisTurn = false;

    private boolean isItBuilt;
    private double upkeep;
    private double cost;

    public Buildings(boolean isItBuilt, double upkeep, double cost) {
        this.isItBuilt = isItBuilt;
        this.upkeep = upkeep;
        this.cost = cost;
    }

    public boolean isItBuilt() {
        return isItBuilt;
    }

    public void setItBuilt(boolean itBuilt) {
        isItBuilt = itBuilt;
    }

    public double getUpkeep() {
        return upkeep;
    }

    public void setUpkeep(double upkeep) {
        this.upkeep = upkeep;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static void buildBuilding(ArrayList<Buildings> buildings, Resources resources , Wonder wonder) {
        if (!isBuildingBuiltThisTurn) {
            ClearScreen.clearConsoleScreen();
            System.out.println("Choose a building:");
            if (!buildings.get(0).isItBuilt) {
                System.out.println("1 - Farmhouse (increases food production by 50%");
                System.out.println("    cost: 5 minerals, upkeep: 1$ / turn");
            }
            if (!buildings.get(1).isItBuilt) {
                System.out.println("2 - Deep Mine (increases mineral production by 50%");
                System.out.println("    cost: 8 minerals, upkeep: 1,5$ / turn");
            }
            if (!buildings.get(2).isItBuilt) {
                System.out.println("3 - Bank (increases money production by 50%");
                System.out.println("    cost: 8 minerals, upkeep: 2$ / turn");
            }
            if (!buildings.get(3).isItBuilt) {
                System.out.println("4 - Spaceship Dry Dock (increases efficiency of spaceship repairs by 50%");
                System.out.println("    cost: 5 minerals, upkeep: 1$ / turn");
            }
            if (!buildings.get(4).isItBuilt) {
                System.out.println("5 - School (one worker is allowed to improve he's main skill at the end of each turn");
                System.out.println("    cost: 5 minerals, upkeep: 1,5$ / turn");
            }
            if (!buildings.get(5).isItBuilt) {
                System.out.println("6 - Alien Resource Replicator (produces random amount of resources at the end of each turn");
                System.out.println("    if miner is smart, replicator will produce more resources");
                System.out.println("    cost: 5 minerals, upkeep: 2$ / turn");
            }
            if (!buildings.get(6).isItBuilt) {
                System.out.println("7 - Alien Borehole (produces some minerals on it's own.");
                System.out.println("    the longer it operates, the more it produces");
                System.out.println("    cost: 8 minerals, upkeep: 2$ / turn");
            }
            if (!buildings.get(7).isItBuilt) {
                System.out.println("8 - Alien Automated Space Donkey Farm (produces some food on it's own");
                System.out.println("    the longer it operates, the more it produces");
                System.out.println("    cost: 8 minerals, upkeep: 2$ / turn");
            }
            if (!buildings.get(8).isItBuilt) {
                System.out.println("9 - Alien Automated Money Printer (produces some money on it's own");
                System.out.println("    the longer it operates, the more it produces");
                System.out.println("    cost: 10 minerals, upkeep: 3$ / turn");
            }
            if (!buildings.get(9).isItBuilt) {
                System.out.println("10 - Marketplace (allows you to trade resources");
                System.out.println("    cost: 5 minerals, upkeep: 1$ / turn");
            }
            System.out.println("11 - Back to main menu");

            int usersChoice = new Scanner(System.in).nextInt();
            switch (usersChoice) {
                case 1:
                    if (resources.getMineralResources() >= 5 && !buildings.get(0).isItBuilt) {
                        resources.setFarmingFactor(1.5 * resources.getFarmingFactor());
                        resources.setMineralResources(resources.getMineralResources() - 5);
                        buildings.get(0).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(0).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Farmhouse is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough minerals.");
                    }
                    break;
                case 2:
                    if (resources.getMineralResources() >= 8 && !buildings.get(1).isItBuilt) {
                        resources.setMineralFactor(1.5 * resources.getMineralFactor());
                        resources.setMineralResources(resources.getMineralResources() - 8);
                        buildings.get(1).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(1).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Deep Mine is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 3:
                    if (resources.getMineralResources() >= 8 && !buildings.get(2).isItBuilt) {
                        resources.setMoneyFactor(1.5 * resources.getMoneyFactor());
                        resources.setMineralResources(resources.getMineralResources() - 8);
                        buildings.get(2).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(2).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Bank is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 4:
                    if (resources.getMineralResources() >= 5 && !buildings.get(3).isItBuilt) {
                        wonder.setWonderBuildEfficiency(wonder.getWonderBuildEfficiency() * 1.5);
                        resources.setMineralResources(resources.getMineralResources() - 5);
                        buildings.get(3).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(3).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Spaceship Dry Dock is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 5:
                    if (resources.getMineralResources() >= 5 && !buildings.get(4).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 5);
                        buildings.get(4).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(4).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("School is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 6:
                    if (resources.getMineralResources() >= 5 && !buildings.get(5).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 5);
                        buildings.get(5).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(5).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Alien Resources Replicator is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 7:
                    if (resources.getMineralResources() >= 8 && !buildings.get(6).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 8);
                        buildings.get(6).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(6).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Alien borehole is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 8:
                    if (resources.getMineralResources() >= 8 && !buildings.get(7).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 8);
                        buildings.get(7).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(7).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Alien Automated Donkey Farm is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 9:
                    if (resources.getMineralResources() >= 10 && !buildings.get(8).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 8);
                        buildings.get(8).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(8).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Alien Automated Money Printer is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 10:
                    if (resources.getMineralResources() >= 5 && !buildings.get(9).isItBuilt) {
                        resources.setMineralResources(resources.getMineralResources() - 5);
                        buildings.get(9).setItBuilt(true);
                        isBuildingBuiltThisTurn = true;
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Building constructed.");
                    } else if (buildings.get(9).isItBuilt) {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Marketplace is already built.");
                    } else {
                        ClearScreen.clearConsoleScreen();
                        System.out.println("Not enough resources.");
                    }
                    break;
                case 11:
                    ClearScreen.clearConsoleScreen();
                    break;
                default:
                    ClearScreen.clearConsoleScreen();
                    System.out.println("You cannot select that.");
                    break;
            }
        } else {
            ClearScreen.clearConsoleScreen();
            System.out.println("You have already built a building this turn.");
        }
    }

    public static void villageView(ArrayList<Buildings> buildings, Resources resources, ArrayList<Worker> workers) {
        String villageBuildings = "";
        if (buildings.get(0).isItBuilt) {
            villageBuildings = villageBuildings + (" _FARM_ ");
        }
        if(buildings.get(1).isItBuilt) {
            villageBuildings = villageBuildings +(" _DEEP MINE_ ");
        }
        if (buildings.get(2).isItBuilt) {
            villageBuildings = villageBuildings + (" _BANK_ ");
        }
        if (buildings.get(3).isItBuilt) {
            villageBuildings = villageBuildings + (" _SPACESHIP DRY DOCK_ ");
        }
        if (buildings.get(4).isItBuilt) {
            villageBuildings = villageBuildings + (" _SCHOOL_ ");
        }
        if (buildings.get(5).isItBuilt) {
            villageBuildings = villageBuildings + (" _ALIEN MINERAL REPLICATOR_ ");
        }
        if (buildings.get(6).isItBuilt) {
            villageBuildings = villageBuildings + (" _ALIEN BOREHOLE_ ");
        }
        if (buildings.get(7).isItBuilt) {
            villageBuildings = villageBuildings + (" _ALIEN AUTOMATED DONKEY FARM_ ");
        }
        if (buildings.get(8).isItBuilt) {
            villageBuildings = villageBuildings + (" _ALIEN MONEY PRINTER_ ");
        }
        if (buildings.get(9).isItBuilt) {
            villageBuildings = villageBuildings + (" _MARKETPLACE_ ");
        }
        System.out.println(villageBuildings);

        double buildingUpkeep = 0;
        Iterator<Buildings> iterator = buildings.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isItBuilt) {
                buildingUpkeep += iterator.next().upkeep;
            }
        }
        System.out.printf("Buildings upkeep: %.1f / turn\n", buildingUpkeep);

        System.out.printf("Farming efficiency = %.0f percent\n", resources.getFarmingFactor() * 100 );
        System.out.printf("Mining efficiency = %.0f percent\n", resources.getMineralFactor() * 100);
        System.out.printf("Banking efficiency = %.0f percent\n", resources.getMoneyFactor() * 100);
        double totalWages = 0;
        for (Worker worker : workers) {
            totalWages += worker.getPayRate();
        }
        System.out.printf("Total Wages: %.2f\n",totalWages);

        double totalFoodConsumption = 0;
        Iterator<Worker> iterator3 = workers.iterator();
        while (iterator3.hasNext()) {
            totalFoodConsumption += iterator3.next().getFoodRequirements();
        }
        System.out.printf("Food Consumption: %.2f\n", totalFoodConsumption);
    }
}
