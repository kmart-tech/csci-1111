package test;

import biome.Forest;
import race.HumanBuilding;
import race.Humans;
import tile.BuildingTile;
import tile.Tile;

public class TestHumans {
    public static void main(String[] args) {
        Forest myForest = new Forest();
        Humans player1 = new Humans("Kevin", myForest);


        BuildingTile[] buildings = player1.getBuildings();

        for (int i = 0; i < buildings.length; i++) {
            System.out.println(((Enum)buildings[i]).name());
        }

        // get user input for building choice
    }
}
