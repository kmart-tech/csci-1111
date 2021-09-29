package biome;

import javafx.geometry.Point2D;

import java.util.HashSet;

public class Plain extends Biome {
    private final HashSet<Tile> biomeTiles; // define or have a function pull the tiles from the tile class

    Plain(Point2D[] shape) {
        super(shape);
        generateLandscape();
    }

    @Override
    protected void generateLandscape() {

    }
}
