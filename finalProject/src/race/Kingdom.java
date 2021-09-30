package race;

import biome.Biome;

import java.util.HashMap;

// can this be used for all races? can also be extended i suppose
public class Kingdom {
    private final Biome occupiedBiome;
    private String[] buildings; //strings?
    private HashMap<Resource, int> resourcesMap; // maybe bonus for each resource so another hashmap
        // and maybe not string? just another int

    public Kingdom (Biome startBiome) {
        occupiedBiome = startBiome;
    }

    public Biome getBiome() { return occupiedBiome; }
}
