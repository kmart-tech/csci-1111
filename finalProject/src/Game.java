import biome.*;
import race.HumanBuilding;
import race.Humans;
import race.Kingdom;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Main java file for running the game. It currently handles too much and needs
 * other methods or classes to generalize some actions such as:
 * player input, player actions, menus, and building.
 */

enum Screen {
    KINGDOMVIEW,
    MAPVIEW;
    //BIOME VIEW?
}

enum Menu {
    BUILD,
    //MAP,
    GENERAL;
}

public class Game {
    public static void main(String[] args) {
        Random rnd = new Random();
        //Scanner startInput = new Scanner(System.in);
        //setup board and players
        Map map = new Map(5,5);

        System.out.println("Kingdoms Game - Version Alpha-Alpha");
        System.out.print("Enter name: ");
        String playerName = "Kevin";
        //startInput.close();

        int startRow = 1;
        int startColumn = 1;

        Biome currentBiome = map.getBiome(startRow, startColumn);

        Humans player1 = new Humans(playerName, currentBiome);
        Kingdom currentKingdom = player1.getKingdom(currentBiome);

        // build a settlement for the player anywhere (haha if in lake)
        currentBiome.replaceTile(HumanBuilding.SETTLEMENT, rnd.nextInt(40), rnd.nextInt(40));

        Screen currentScreen = Screen.KINGDOMVIEW;
        Menu currentMenu = Menu.GENERAL;

        PlayerInputThread inputThread = new PlayerInputThread();
        inputThread.start();

        String[] generalOptions = {"", "(B)uild", "(M)ap"};

        // no win condition right now
        while (!player1.checkWin()) {

            // update game for each player, AI, biome
            // for each loop
            player1.update();

            // check for user input
            if (currentScreen == Screen.KINGDOMVIEW) {
                if (currentMenu == Menu.GENERAL) {
                    char player1char = inputThread.getChar();
                    if (player1char == 'M') {
                        currentScreen = Screen.MAPVIEW;
                    }
                    else if (player1char == 'B') currentMenu = Menu.BUILD;
                }
                else if (currentMenu == Menu.BUILD) {
                    int player1int = inputThread.getInt();
                    if (player1int >= 0 && player1int < player1.getBuildings().length) {
                        // move this logic into Humans? or some other building class (only pass the user input)
                        // build at a random location for now
                        if (player1.getBuildings()[player1int] == HumanBuilding.SETTLEMENT) {
                            // manually check and build so we charge the current kingdom for the costs
                            int mapRow = rnd.nextInt(4);
                            int mapCol = rnd.nextInt(4);
                            if (!player1.getBiomes().contains(map.getBiome(mapRow, mapCol))) {
                                int rndRow = rnd.nextInt(40);
                                int rndCol = rnd.nextInt(40);
                                if (currentBiome.validBuildingLocation(rndRow, rndCol)) {
                                    if (currentKingdom.payForBuilding(player1.getBuildings()[player1int])) {
                                        // spawn to a random biome for now
                                        Biome settledBiome = map.getBiome(mapRow, mapCol);
                                        player1.addKingdom(settledBiome);
                                        currentKingdom = player1.getKingdom(settledBiome);
                                        currentBiome = settledBiome;
                                        currentBiome.replaceTile(HumanBuilding.SETTLEMENT, rndRow, rndCol);
                                    }
                                }
                            }
                        }
                        else {
                            currentKingdom.build(player1.getBuildings()[player1int], rnd.nextInt(40), rnd.nextInt(40));
                        }
                        currentMenu = Menu.GENERAL;
                    }
                }
            }
            else if (currentScreen == Screen.MAPVIEW) {
                int player1int = inputThread.getInt();
                if (player1int >= 0 && player1int < player1.getKingdoms().size() ) {
                    currentBiome = player1.getKingdoms().get(player1int).getBiome();
                    currentKingdom = player1.getKingdoms().get(player1int);
                    currentScreen = Screen.KINGDOMVIEW;
                }
            }
            // draw board and menu
            if (currentScreen == Screen.KINGDOMVIEW) {
                if (currentMenu == Menu.GENERAL) {
                    PrintTerminal.printBiomeView(player1, currentBiome, generalOptions);
                }
                else if(currentMenu == Menu.BUILD) {
                    PrintTerminal.printBiomeView(player1, currentBiome, player1.buildOptions());
                }
            }
            else if (currentScreen == Screen.MAPVIEW) {
                PrintTerminal.printMapView(player1, map);
            }

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("SLEEP ERROR!");
            }
            //"clear" console window: [2J does not actually clear, just prints at the top of the console
            System.out.print("\033[H\033[2J");
            System.out.flush(); // might not be needed
        }
        // after win condition, close the input thread
        inputThread.terminate();
    }
}



