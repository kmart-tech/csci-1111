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

    public String[] toStringArray() {
        String[] biomeString = new String[map.length];
        for (int i = 0; i < map.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < map[i].length; j++) {
                line.append(map[i][j].getMapTile() + "  ");
            }
            biomeString[i] = line.toString();
        }
        return biomeString;
    }

    // could use biome generation here
    private void generate() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                int x = new Random().nextInt(2); // gives 0 or 1 for forest or plain
                if (x == 0) {
                    map[row][col] = new Forest(row, col);
                }
                else {
                    map[row][col] = new Plain(row, col);
                }
            }
        }
    }
}
