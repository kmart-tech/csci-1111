package race;

import biome.Biome;
import tile.BuildingTile;
import tile.Tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class Kingdom {
    private final Biome occupiedBiome;
    private Tile[] buildings;
    private ArrayList<Asset> resources = new ArrayList<Asset>(); // maybe this should be an EnumMap of <Resource, Asset>
    // population is a resource

    public Kingdom (Biome occupiedBiome, Asset[] startResources) {
        this.occupiedBiome = occupiedBiome;
        for (Asset resource: startResources) {
            resources.add(new Asset(resource));
        }
    }

    public boolean newResource(Resource newResource, double amount, double rate) {
        for (Asset e: resources) {
            if (e.getResource() == newResource) return false;
        }
        resources.add(new Asset(newResource, amount, rate));
        return true;
    }

    public boolean hasResource(Resource someResource) {
        for (Asset e: resources) {
            if (e.getResource() == someResource) return true;
        }
        return false;
    }

    public void updateResources() {
        for (Asset e: resources) {
            e.grow();
        }
    }

    public void addToResource(Resource someResource, double amount) {
        // feels like there should be a better way to access the specific resource
        for (int i =0; i < resources.size(); i++) {
            if (resources.get(i).getResource() == someResource) {
                resources.get(i).addToAmount(amount);
            }
        }
    }

    public boolean payForBuilding(BuildingTile building) {
        // check for required resources and amount
        int[] resourcesToPay = new int[building.getResourceCost().size()];
        double[] costArray = new double[building.getResourceCost().size()];
        int counter = 0;

        // TODO: enumerate over the building resources not the kingdom resources
        for (Map.Entry<Resource, Double> mapEntry : building.getResourceCost().entrySet()) {
            boolean foundResource = false;
            for (int i = 0; i < resources.size(); i++) {
                // look for the matching resource
                if (resources.get(i).getResource() == mapEntry.getKey()) {
                    // found the matching resource
                    if (resources.get(i).getAmount() >= mapEntry.getValue()) {
                        // do we have enough resource?
                        resourcesToPay[counter] = i;
                        costArray[counter] = mapEntry.getValue();
                        counter++;
                        foundResource = true;
                        break;
                    }
                    else return false; // not enough of that resource
                }
            }
            if (!foundResource) return false; // didn't have that specific resource or amount
        }
        // pay for the costs
        for (int i = 0; i < resourcesToPay.length; i++) {
            resources.get(resourcesToPay[i]).addToAmount(-costArray[i]);
        }
        return true;
    }

    public ArrayList<Asset> getResources() {
        return resources;
    }

    public Biome getBiome() { return occupiedBiome; }

    public int[] getMapLocation(){ return occupiedBiome.getMapLocation(); }

    public boolean build(final BuildingTile building, final int row, final int col) {
        if (!occupiedBiome.validBuildingLocation(row, col)) {
            return false;
        }

        // check for resources then pay for them
        if (!payForBuilding(building)) {
            return false;
        }


        //TODO: apply the building's effect (increase food, population rate, etc...)
        occupiedBiome.replaceTile(building, row, col);
        return true;
    }
}

