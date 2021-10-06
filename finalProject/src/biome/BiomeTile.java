package biome;

import tile.Tile;

public enum BiomeTile implements Tile {
    GRASS('.'),
    TREE('T'),
    WATER('~'),
    ROCK('R');

    private char printChar;

    public char getTileChar () { return printChar; }


    //implement in all Tile interfaces, print which defines the colors for each one
    // return String: tile.COLOR + tile character + RESET

    BiomeTile(char printChar) {
        this.printChar = printChar;
    }
}

