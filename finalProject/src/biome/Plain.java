package biome;

import javafx.geometry.Point2D;

import java.util.Arrays;
import java.util.HashSet;

import static biome.BiomeTile.*;

public class Plain extends Biome {
    public Plain(int row, int col) {
        super("P", row, col);
        generateBiomeTiles();
    }

    @Override
    protected void generateBiomeTiles() {
        // base it on number of total tiles
        int forestGrowths = rnd.nextInt(3) + 5; // rename to grass
        int rockGrowths = 5;
        int waterGrowths = 2;

        // create a Grass filled biome first
        for (tile.Tile[] tilesRow : tiles) {
            Arrays.fill(tilesRow, GRASS);
        }

        // grow TREE numTreeGrowths times
        for (int i = 0; i < forestGrowths; i++) {
            this.tileGrow(TREE, 20);
        }

        // rock generation
        for (int i = 0; i < rockGrowths; i++) {
            this.tileGrow(ROCK, 5);
        }

        // water generation
        for (int i = 0; i < waterGrowths; i++) {
            this.tileGrow(WATER, 20);
        }
    }
}
