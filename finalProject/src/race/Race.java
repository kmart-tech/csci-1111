package race;

import biome.Biome;

import java.util.ArrayList;

// each player is a specific race
public abstract class Race {
    private final String raceName;
    private final String playerName;
    private final Tile[] buildings;
    private ArrayList<Biome> kingdoms;

    Race(String raceName, String playerName, Biome startLocation) {
        this.raceName = raceName;
        this.playerName = playerName;
        kingdoms.add(startLocation);
    }

    public static String getRaceName {
        return raceName;
    }

    public static String getPlayerName {
        return playerName;
    }

    public abstract boolean checkWin();

    //public abstract Tile getBuildings()
}
