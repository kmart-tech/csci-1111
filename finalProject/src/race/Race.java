package race;

import biome.Biome;
import tile.BuildingTile;

import java.util.ArrayList;

// each player is a specific race
public abstract class Race {
    private final String raceName;
    private final String playerName;
    private final BuildingTile[] raceBuildings;
    protected ArrayList<Kingdom> kingdoms = new ArrayList<Kingdom>();
    // should default resources be included?

    /* Might not need this:
        Race(String raceName, String playerName, BuildingTile[] buildings) {
        this.raceName = raceName;
        this.playerName = playerName;
        this.buildings = buildings;
    }
    */

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

    public abstract void addKingdom(Biome newBiome);

    public abstract boolean checkWin();

    //public abstract Tile getBuildings()
}
