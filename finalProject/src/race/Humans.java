package race;

import biome.Biome;

import static race.Resource.*;

// Has buildings, magic / technology, religion?, trading, exploring
// resources: wood, stone, water?
// money
public class Humans extends Race {
    // default kingdom resources and population (no max population? maybe just logarithm it
    private static final Asset[] defaultResources = {
            new Asset(POPULATION, 10.0, .05),
            new Asset(FOOD, 100.0, 1.0),
            new Asset(WOOD, 100.0, 1.0),
            new Asset(STONE, 100.0, 1.0),
            new Asset(GOLD, 100.0, 0.0)
        };

    public static final String[] actions = {"(B)uild"};

    public Humans(String playerName, Biome startBiome) {
        super("Humans", playerName, HumanBuilding.values(), new Kingdom(startBiome, defaultResources));
    }

    public HumanBuilding[] getBuildings() { return HumanBuilding.values(); }

    @Override
    public void addKingdom(Biome newBiome) {
        kingdoms.add(new Kingdom(newBiome, defaultResources));
    }

    @Override
    public boolean checkWin() {
        return false;
    }

    public String[] getActions() {
        return actions;
    }

    public boolean build(HumanBuilding building, Kingdom currentKingdom) {
        return false;
        //if ()
    }

    /*
    public boolean doAction(char input) {
        switch(input) {
            case 'B':

        }
    }
    /*
    humans do the following actions
    Build -
    - build a castle if they have the follow resources and conditions (settlement and so many farms)
    Units -
    - send unit to place
    - do action with unit?
    Explore or other action types?
     */

}
