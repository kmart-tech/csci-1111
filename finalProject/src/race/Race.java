package race;

import biome.Biome;
import tile.BuildingTile;

import java.util.ArrayList;

// each player is a specific race
// rename Race to Player?
public abstract class Race {
    private final String raceName;
    private final String playerName;
    private final BuildingTile[] raceBuildings;
    protected ArrayList<Kingdom> kingdoms = new ArrayList<Kingdom>();
    protected ArrayList<Biome> visibleBiomes = new ArrayList<Biome>(); // maybe should be a matrix the same size as map with boolean values
    // or maybe the Map class has the visible biomes for each player? (easier interactions?)
    // should default resources be included?


    Race(String raceName, String playerName, BuildingTile[] raceBuildings, Kingdom startLocation) {
        this.raceName = raceName;
        this.playerName = playerName;
        this.raceBuildings = raceBuildings;
        kingdoms.add(startLocation);
    }

    public String getRaceName() {
        return raceName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public BuildingTile[] getRaceBuildings() {
        return raceBuildings;
    }

    public ArrayList<Kingdom> getKingdoms() {return kingdoms;}

    public void update() {
        for (Kingdom kingdom: kingdoms) {
            kingdom.updateResources();
        }
    }

    public Kingdom getKingdom(Biome biome) {
        for (Kingdom k: kingdoms) {
            if (k.getBiome() == biome) return k;
        }
        return null;
    }

    public abstract void addKingdom(Biome newBiome);

    public abstract boolean checkWin();

    //public abstract boolean menu();

        /* General MENU
    See the Resources in a biome (displayed above the menu options)

    All players do the following actions (implemented in Race class)
    View map
    - has a list of biomes they own (maybe names of them too)
    - view a biome they have vision of (or had vision of)
    */


        /*
    // map view or specific Kingdom view
    protected String[] generalMenu(char input, Kingdom kingdom) {
        String[] outputString = new String[];
        switch(input) {
            // no input from user
            case "":
                for (e: kingdom.getResources()) {


        }

        return outputString;
    }
    */



    //public abstract Tile getBuildings()
}
