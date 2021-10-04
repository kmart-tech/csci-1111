package biome;

import javafx.geometry.Point2D;
import tile.Tile;

public abstract class Biome {

    protected Tile[][] tiles; //maybe just int?
    private int[] tileOffset;
    // count of each tile type?

    Biome(){}
    Biome(Point2D[] shape) {
        generateBiomeShape(shape);
    };
    
    // add a function that returns specific kingdom object(s) from occupied players

    private void generateBiomeShape(Point2D[] shape) {
        tiles = new Tile[50][50];
    }

    //maybe rename generateBiomeTiles
    protected abstract void generateBiomeTiles();

    // Biome functions
    public abstract boolean hasTile();

    public void replaceTile(Tile newTile, int x, int y) {
        tiles[y][x] = newTile;
    }

    protected abstract void generateBiomeTiles();
}
