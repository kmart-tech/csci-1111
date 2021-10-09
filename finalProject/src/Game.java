import biome.*;
import race.Humans;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Game {
    public static void main(String[] args) {
        Scanner startInput = new Scanner(System.in);
        //setup board and players
        Map map = new Map(5,5);

        System.out.println("Kingdoms Game - Version Alpha-Alpha");
        System.out.print("Enter name: ");
        String playerName = startInput.nextLine();
        startInput.close();

        int startRow = 1;
        int startColumn = 1;

        Humans player1 = new Humans(playerName, map.getBiome(startRow, startColumn));

        PlayerInputThread inputThread = new PlayerInputThread();
        inputThread.start();

        String[][] currentScreen = new String[2][];
        currentScreen = getBoard('0'); // some default menu

        //start game loop (what order should things be done?)
        while (!player1.checkWin()) {

            // update game for each player, AI, biome
            // for each loop
            player1.update();

            char player1Input = inputThread.getKey();
            currentScreen = getBoard(player1Input);

            // check for user input
            // String[] menu = menu(getInput(inputThread)))???
            //getInput(inputThread.getKey());

            // draw board and menu
            PrintTerminal.printGame(currentScreen[0], currentScreen[1], 20);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("SLEEP ERROR!");
            }
            //"clear" console window: [2J does not actually clear, just prints at the top of the console
            System.out.print("\033[H\033[2J");
            System.out.flush(); // might not be needed
        }
    }

    /*
    // dont use
    private static String[][] getBoard(char input) {
        String[] board = new String[40]; // size of biomes?
        String[] menu = new String[40];

        switch (input) {
            case 'B': // build
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + 'B');
        }
    }
     */
}



