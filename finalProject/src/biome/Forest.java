package biome;

import javafx.geometry.Point2D;

import java.util.HashSet;

public class Forest extends Biome {
    // maybe is implemented in Biome and part of constructor?
    private static final Tile[] biomeTiles; // define or have a function pull the tiles from the tile class

    Forest(Point2D[] shape) {
        super(shape);
        // set biomeTiles?
        generateBiomeTiles();
    }

    @Override
    protected void generateBiomeTiles() {

    }
}
