import biome.*;
import race.Humans;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Game {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        //setup board and players
        Biome[][] map = new Biome[5][5];
        mapGenerator(map);

        System.out.println("Kingdoms Game - Version Alpha-Alpha");
        System.out.print("Enter name: ");
        String playerName = userInput.nextLine();
        userInput.close();

        int startY = 1;
        int startX = 1;

        Humans player1 = new Humans(playerName, map[startY][startX]);

        PlayerInputThread inputThread = new PlayerInputThread();
        inputThread.start();

        String[][] currentBoard = new String[2][];
        currentBoard = getBoard('0'); // some default menu

        //start game loop (what order should things be done?)
        while (!player1.checkWin()) {

            // update game for each player, AI, biome
            // for each loop
            player1.update();

            char player1Input = inputThread.getKey();
            currentBoard = getBoard(player1Input);

            // check for user input
            // String[] menu = menu(getInput(inputThread)))???
            //getInput(inputThread.getKey());

            // draw board and menu
            PrintTerminal.printGame(currentBoard[0], [1], 20);
            try {
                sleep(1000);
            }
            catch (InterruptedException ex) {
                System.out.println("ERROR!");
            }
            //"clear" console window: 2J does not actually clear, just prints at the top of the console
            System.out.print("\033[H\033[2J");
            System.out.flush(); // might not be needed
        }
    }

    private static String[][] getBoard(char input) {
        String [] board = new String[40]; // size of biomes?
        String [] menu = new String[40];

        switch (input) {
            case "B": // build

            default:
                throw new IllegalStateException("Unexpected value: " + 'B');
        }


    }


    // move to a map object eventually
    public static void mapGenerator(Biome[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int x = new Random().nextInt(2); // gives 0 or 1 for forest or plain
                if (x == 0) {
                    map[i][j] = new Forest();
                }
                else {
                    map[i][j] = new Plain();
                }
            }
        }
    }
}
