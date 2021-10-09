package test;

import biome.Forest;

import static java.lang.Thread.sleep;

public class TestBiome {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Forest myForest = new Forest();
            myForest.printBiome();
            System.out.println("TEST!" + i);
            try {
                sleep(500);
            }
            catch (InterruptedException ex) {
                System.out.println("ERROR!");
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
