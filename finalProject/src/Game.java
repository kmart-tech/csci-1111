import biome.*;
import race.Humans;

import java.util.Scanner;

import static java.lang.Thread.sleep;

enum View {
    BIOMEVIEW,
    MAPVIEW;
}

public class Game {
    public static void main(String[] args) {
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


        View currentScreen = View.BIOMEVIEW;

        PlayerInputThread inputThread = new PlayerInputThread();
        inputThread.start();

        //start game loop (what order should things be done?)
        while (!player1.checkWin()) {

            // update game for each player, AI, biome
            // for each loop
            player1.update();

            // check for user input
            if (currentScreen == View.BIOMEVIEW) {
                char player1char = inputThread.getChar();
                if (player1char == 'M') currentScreen = View.MAPVIEW;
                else if (player1char == 'B') {
                    // buildVIEW?
                }
            }
            else if (currentScreen == View.MAPVIEW) {
                int player1int = inputThread.getInt();
                if (player1int >= 0 && player1int < player1.getKingdoms().size() ) {
                    currentBiome = player1.getKingdoms().get(player1int).getBiome();
                    currentScreen = View.BIOMEVIEW;
                }
            }

            // draw board and menu
            if (currentScreen == View.BIOMEVIEW) {
                PrintTerminal.printBiomeView(player1, currentBiome);
            }
            else if (currentScreen == View.MAPVIEW) {
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
    }


}



