package race;

import tile.BuildingTile;
import tile.Tile;
import static race.Resource.*;

import java.util.EnumMap;

// Should this be put in Humans class file and be named enum Buildings?
// then each race just has the form of RACE.Buildings."..."???
// can they still use implements?

// Maybe just in a human folder that would give the same effect?

public enum HumanBuilding implements BuildingTile {
    SETTLEMENT("S", new EnumMap<Resource, Integer>(Resource.class) {{
        put(WOOD, 50);
        put(STONE, 50);
        put(GOLD, 10);
    }} ), // change to unit settlers?
    CASTLE("C", new EnumMap<Resource, Integer>(Resource.class) {{
        put(WOOD, 100);
        put(STONE, 100);
        put(GOLD, 100);
    }} ),
    HOUSE("H", new EnumMap<Resource, Integer>(Resource.class) {{
        put(WOOD, 50);
        put(STONE, 10);
        put(GOLD, 10);
    }} ),
    FARM("F", new EnumMap<Resource, Integer>(Resource.class) {{
        put(WOOD, 10);
        put(STONE, 10);
    }} );

    // do a map of <resource, cost> then a function related to it for when building cost

    private final EnumMap<Resource, Integer> resourceCost;

    private final String tileString;
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[103m";

    private int woodCost;
    private int stoneCost;
    private int goldCost;

    public int getWoodCost() {
        return this.woodCost;
    }
    public int getStoneCost() {
        return stoneCost;
    }
    public int getGoldCost() {
        return goldCost;
    }

    HumanBuilding(String tileString, EnumMap<Resource, Integer> resourceCost) {
        this.tileString = tileString;
        this.resourceCost = resourceCost;
    }

    @Override
    public String printTile() {
        return ANSI_YELLOW_BACKGROUND + tileString;
    }
}
