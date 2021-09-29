package biome;

import javafx.geometry.Point2D;
import race.Race;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Biome {

    private Tile[][] Tiles = null; //maybe just int?
    private int[] tileOffset;
    // count of each tile type?
    private HashSet<Race> occupiedPlayers = new HashSet<Race>(); //array list

    Biome(){}
    Biome(Point2D[] shape) {
        generateBiomeShape(shape);
    };

    public void addPlayer(Race player) {
            occupiedPlayers.add(player);
    }

    public void removePlayer(Race player) {
        occupiedPlayers.remove(player);
    }

    // add a function that returns specific kingdom object(s) from occupied players

    private void generateBiomeShape(Point2D[] shape) {
        // go line by line to create the shape of Tiles and tileOffset
    }

    protected abstract void generateLandscape();


    // Biome functions
    public abstract boolean hasTile();

    public void replaceTile(Tile newTile, int x, int y) {
        Tiles[y][x] = newTile;
    }
}
