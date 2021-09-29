package race;

// does this class talk about the player's Race as a whole?
// What describes the specific settlement on in a biome.

// Has buildings, magic / technology, religion?, trading, exploring
// resources: wood, stone, water?
// money
public class Humans extends Race {

    private final Tile[] buildings; //maybe should be a string

    // resources

    Humans(String playerName) {
        super("Humans", playerName);
    }

    @Override
    public boolean checkWin() {
        return false;
    }
}
