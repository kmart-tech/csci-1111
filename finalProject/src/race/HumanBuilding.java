package race;

import tile.BuildingTile;
import tile.Tile;

public enum HumanBuilding implements BuildingTile {
    SETTLEMENT(100,100,50,"S"),
    CASTLE(200, 500, 100,"C"),
    HOUSE(50,50,10,"H"),
    FARM(50,10,0,"F");

    private String tileString;
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

    HumanBuilding(int woodCost, int stoneCost, int goldCost, String tileString) {
        this.woodCost = woodCost;
        this.stoneCost = stoneCost;
        this.goldCost = goldCost;
        this.tileString = tileString;
    }

    @Override
    public String printTile() {
        return ANSI_YELLOW_BACKGROUND + tileString;
    }
}
