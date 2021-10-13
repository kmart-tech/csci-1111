package biome;

import tile.BuildingTile;
import tile.Tile;
import java.util.Random;


public abstract class Biome {
    protected Tile[][] tiles; //maybe just int?
    private int[] tileOffset;
    private final String mapTile;
    private final int[] mapLocation;
    // count of each tile type?
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[49m";
    protected Random rnd = new Random();

    Biome(String mapTile, int row, int col) {
        this.mapTile = mapTile;
        mapLocation = new int[]{row, col};
        generateBiomeShape();
    }
    
    // add a function that returns specific kingdom object(s) from occupied players

    private void generateBiomeShape() {
        tiles = new Tile[40][40];
    }

    // Biome functions

    public void replaceTile(Tile newTile, int row, int col) {
        tiles[row][col] = newTile;
    }

    public boolean validBuildingLocation(int row, int col) {
        if (row > 0 && row < tiles.length) {
            if (col > 0 && col < tiles[row].length) {
                if (tiles[row][col] instanceof BuildingTile || tiles[row][col] == BiomeTile.ROCK) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getMapTile() {
        return mapTile;
    }

    public int[] getMapLocation() {
        return mapLocation;
    }

    // depreciated
    public void printBiome() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                //print offset here
                    System.out.print(tiles[i][j].printTile() + " " + ANSI_BLACK_BACKGROUND);
                }
            System.out.println();
        }
    }

    public String[] toStringArray() {
        String[] biomeString = new String[tiles.length];
        for (int i = 0; i < tiles.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < tiles[i].length; j++) {
                line.append(tiles[i][j].printTile() + " " + ANSI_BLACK_BACKGROUND);
            }
            biomeString[i] = line.toString();
        }
        return biomeString;
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
