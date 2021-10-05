package biome;

import tile.Tile;

import java.util.Random;


public abstract class Biome {
    protected Tile[][] tiles; //maybe just int?
    private int[] tileOffset;
    Random rnd = new Random();
    // count of each tile type?
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[45m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[49m";

    Biome() {
        generateBiomeShape();
    };
    
    // add a function that returns specific kingdom object(s) from occupied players

    private void generateBiomeShape() {
        tiles = new Tile[50][50];
    }

    // Biome functions

    public void replaceTile(Tile newTile, int x, int y) {
        tiles[y][x] = newTile;
    }

    public void printBiome() {
        for (int i =0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                //print offset here
                if (tiles[i][j] == biome.BiomeTile.TREE) {
                    System.out.print(ANSI_GREEN_BACKGROUND + tiles[i][j].getTileChar() + " " + ANSI_BLACK_BACKGROUND);
                }
                else {
                    System.out.print(tiles[i][j].getTileChar() + " ");
                }
            }
            System.out.println();
        }
    }

    protected void tileGrow(final Tile tile, int iterations) {
        int row = rnd.nextInt(tiles.length);
        int col = rnd.nextInt(tiles[row].length);
        tiles[row][col] = tile;
        recursiveTileGrow(tile, row, col, iterations);
    }

    // recursive tile grow
    private void recursiveTileGrow(final Tile tile, int row, int col, int count) {
        if (count < 0) {
            return;
        }

        int colOffset = rnd.nextInt(4);
        if (colOffset == 3) colOffset = 1; // 50% for 0. 50% for -1,1
        else if (colOffset == 2) colOffset = -1;
        else colOffset = 0;

        int rowOffset = 0;
        if (colOffset == 0) {
            // dont let rowOffset also be 0
            rowOffset = rnd.nextInt(2);
            if (rowOffset == 0) rowOffset = -1;
        }
        else {
            rowOffset = rnd.nextInt(4);
            if (rowOffset == 3) rowOffset = 1; // 50% for 0. 50% for -1,1
            else if (rowOffset == 2) rowOffset = -1;
            else rowOffset = 0;
        }

        /* scattering
        int colMultiplier = 1;
        if (rnd.nextDouble() > .8) {
            colMultiplier = 2;
        }

        int rowMultiplier = 1;
        if (rnd.nextDouble() > .8) {
            rowMultiplier = 2;
        }
        */

        col += colOffset;
        row += rowOffset;

        if (row >= 0 && col >= 0 && row < tiles.length && col < tiles[row].length) {
            if (tiles[row][col] == tile) {
                // if there is a tree already, go back and try again
                recursiveTileGrow(tile,row - rowOffset, col - colOffset, count - 2);
            }
            else {
                tiles[row][col] = tile;
                recursiveTileGrow(tile,row - rowOffset, col - colOffset, count - 2);
                recursiveTileGrow(tile, row, col, count - 1);
            }
        }
        else {
            recursiveTileGrow(tile, row - rowOffset, col - colOffset, count - 1);
        }

    }

    public abstract boolean hasTile();

    protected abstract void generateBiomeTiles();
}
