package biome;

import javafx.geometry.Point2D;
import tile.Tile;

import java.util.Random;

import static biome.biomeTile.*;

public class Forest extends Biome {
    Random rnd = new Random();
    // int forestGrowths here?

    Forest(Point2D[] shape) {
        super(shape);
        generateBiomeTiles();
    }

    @Override
    public boolean hasTile() {
        return false;
    }

    @Override
    protected void generateBiomeTiles() {
        int forestGrowths = rnd.nextInt(5) + 5;
        // create a grass base first
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = GRASS;
            }
        }

        // grow trees numTreeGrowths times
        for (int i = 0; i < forestGrowths; i++) {
            int col = rnd.nextInt(tiles.length);
            int row = rnd.nextInt(tiles[col].length);
            tiles[col][row] = TREE;

            recurvsiveTreeGrow(col, row,3);
        }
    }

    // recursive depth tree grow
    private void recurvsiveTreeGrow(int col, int row, int count) {
        int colOffset = rnd.nextInt(2);
        if (colOffset == 0) colOffset = -1;

        int rowOffset = rnd.nextInt(2);
        if (rowOffset == 0) rowOffset = -1;

        col += colOffset;
        row += rowOffset;

        try {
            if (tiles[col][row] != TREE) {
                tiles[col][row] = TREE;
                recurvsiveTreeGrow(col, row, count - 1);
            }
        }
        catch(ArrayIndexOutOfBoundsException ex) {
            // do nothing?
        }
    }
}
