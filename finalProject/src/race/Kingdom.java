package race;

import biome.Biome;

import java.util.ArrayList;
import java.util.Arrays;


// can this be used for all races? can also be extended i suppose
public class Kingdom {
    private final Biome occupiedBiome;
    private String[] buildings; //strings? Building Enum?
    private ArrayList<Resource> resources; // maybe bonus for each resource so another hashmap
        // and maybe not string? just another int

    public Kingdom (Biome occupiedBiome, Resource[] startResources) {
        this.occupiedBiome = occupiedBiome;
        resources = new ArrayList<Resource>(Arrays.asList(startResources));
    }

    public boolean addResource(String name, double amount, double rate) {
        for (Resource e: resources) {
            if (e.getName().equals(name)) return false;
        }
        resources.add(new Resource(name, amount, rate));
        return true;
    }

    public boolean hasResource(String name) {
        for (Resource e: resources) {
            if (e.getName().equals(name)) return true;
        }
        return false;
    }

    public Biome getBiome() { return occupiedBiome; }
}
