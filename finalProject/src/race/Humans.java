package race;

// does this class talk about the player's Race as a whole?
// What describes the specific settlement on in a biome.

import biome.Biome;

// Has buildings, magic / technology, religion?, trading, exploring
// resources: wood, stone, water?
// money
public class Humans extends Race {

    private final Tile[] buildings; //maybe should be a string

    // resources

    Humans(String playerName, Biome startLocation) {
        super("Humans", playerName, startLocation);
    }

    @Override
    public boolean checkWin() {
        return false;
    }
}
