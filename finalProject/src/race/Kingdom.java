package race;

import biome.Biome;
import tile.BuildingTile;
import tile.Tile;

import java.util.ArrayList;
import java.util.Arrays;


public class Kingdom {
    private final Biome occupiedBiome;
    private Tile[] buildings;
    private ArrayList<Asset> resources;
    // population is a resource

    public Kingdom (Biome occupiedBiome, Asset[] startResources) {
        this.occupiedBiome = occupiedBiome;
        resources = new ArrayList<Asset>(Arrays.asList(startResources));
    }

    public boolean addResource(String name, double amount, double rate) {
        for (Asset e: resources) {
            if (e.getName().equals(name)) return false;
        }
        resources.add(new Asset(name, amount, rate));
        return true;
    }

    public boolean hasResource(String name) {
        for (Asset e: resources) {
            if (e.getName().equals(name)) return true;
        }
        return false;
    }

    public void updateResources() {
        for (Asset e: resources) {
            e.grow();
        }
    }

    public ArrayList<Asset> getResources() {
        return resources;
    }

    public Biome getBiome() { return occupiedBiome; }

    public boolean build(BuildingTile building, int row, int col) {
        // build conditions:
        // valid location in the biome
        // has resources
        for (Asset e: resources) {
            //if (e.getAmount() < building.)
        }
        return false;
    }
}
