package race;

import biome.Biome;
import tile.Tile;

// Has buildings, magic / technology, religion?, trading, exploring
// resources: wood, stone, water?
// money
public class Humans extends Race {
    // default kingdom resources
    private static final Resource[] defaultResources = {
            new Resource("Food", 100.0, 1.0),
            new Resource("Wood", 100.0, 1.0),
            new Resource("Stone", 100.0, 1.0),
            new Resource("Gold", 100.0, 0.0)
        };

    public Humans(String playerName, Biome startBiome) {
        super("Humans", playerName, HumanBuilding.values(), new Kingdom(startBiome, defaultResources));
    }

    /* dont need to implement here
    public String[] buildOptions() {
        String[] buildings =
        for (HumanBuilding e: HumanBuilding.values()) {
            e.name().
        }
    }
     */

    public HumanBuilding[] getBuildings() { return HumanBuilding.values(); }

    @Override
    public void addKingdom(Biome newBiome) {
        kingdoms.add(new Kingdom(newBiome, defaultResources));
    }

    @Override
    public boolean checkWin() {
        return false;
    }
}
