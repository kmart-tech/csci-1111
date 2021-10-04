package race;

import biome.Biome;

// Has buildings, magic / technology, religion?, trading, exploring
// resources: wood, stone, water?
// money
public class Humans extends Race {
    private final Tile[] buildings; //maybe should be a string

    // default kingdom resources
    private final Resource[] defaultResources = {
            new Resource("Food", 100.0, 1.0),
            new Resource("Wood", 100.0, 1.0),
            new Resource("Stone", 100.0, 1.0),
            new Resource("Gold", 100.0, 0.0)
        };

    Humans(String playerName, Biome startBiome) {
        super("Humans", playerName);
        this.addKingdom(startBiome);
    }

    @Override
    public void addKingdom(Biome newBiome) {
        kingdoms.add(new Kingdom(newBiome, defaultResources));
    }

    @Override
    public boolean checkWin() {
        return false;
    }
}
