package biome;

import java.util.Random;

public class Map {
    private Biome[][] map;

    private Map() {}

    public Map(int width, int height) {
        map = new Biome[width][height];
        this.generate();
    }

    public Biome getBiome(int row, int column) {
        return map[row][column];
    }

    //public String[] getStringArray() {    }

    // could use biome generation here
    public void generate() {
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
