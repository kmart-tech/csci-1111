import biome.Forest;
import race.Humans;

import static java.lang.Thread.sleep;

public class TestLoop {
    public static void main(String[] args) {
        Forest myForest = new Forest();
        Humans player1 = new Humans("KEVIN", myForest);
        PlayerInputThread inputThread = new PlayerInputThread();
        inputThread.start();

        while (true) {
            if (inputThread.getKey() == 'b') {
                int x = (int) (Math.random() * 40);
                int y = (int) (Math.random() * 40);
                myForest.replaceTile(race.HumanBuilding.HOUSE, x, y);
            }

            //render the world
            myForest.printBiome();
            System.out.print("Press B to build a settlement: ");
            //System.out.print("\033[1A"); // move up 1 line
            // System.out.print("\033[2K"); // clear line
            try {
                sleep(1000);
            }
            catch (InterruptedException ex) {
                System.out.println("ERROR!");
            }
            //always print at the beginning of the console window
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        //inputThread.terminate();
    }
}
