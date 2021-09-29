package race;

import java.util.HashSet;

public abstract class Race {
    // each race has a name, buildings, win conditions
    private final String raceName;
    private final String playerName;
    private final Tile[] buildings;

    Race(String raceName, String playerName) {
        this.raceName = raceName;
        this.playerName = playerName
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
