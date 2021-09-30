package biome;

import javafx.geometry.Point2D;
import race.Race;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Biome {

    private Tile[][] Tiles; //maybe just int?
    private int[] tileOffset;
    // count of each tile type?

    Biome(){}
    Biome(Point2D[] shape) {
        generateBiomeShape(shape);
    };
    
    // add a function that returns specific kingdom object(s) from occupied players

    private void generateBiomeShape(Point2D[] shape) {
        // go line by line to create the shape of Tiles and tileOffset
    }

    //maybe rename generateBiomeTiles
    protected abstract void generateBiomeTiles();

    // Biome functions
    public abstract boolean hasTile();

    public void replaceTile(Tile newTile, int x, int y) {
        Tiles[y][x] = newTile;
    }
}
