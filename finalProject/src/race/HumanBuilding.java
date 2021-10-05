package race;

import tile.BuildingTile;
import tile.Tile;

public enum HumanBuilding implements BuildingTile {
    SETTLEMENT(100,100,50),
    CASTLE(200, 500, 100),
    HOUSE(50,50,10),
    FARM(50,10,0);

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

    HumanBuilding(int woodCost, int stoneCost, int goldCost) {
        this.woodCost = woodCost;
        this.stoneCost = stoneCost;
        this.goldCost = goldCost;
    }

    @Override
    public char getTileChar() {
        return 0;
    }
}
