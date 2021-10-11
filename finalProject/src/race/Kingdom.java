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
    private ArrayList<Asset> resources; // maybe this should be an EnumMap of <Resource, Asset>
    // population is a resource

    public Kingdom (Biome occupiedBiome, Asset[] startResources) {
        this.occupiedBiome = occupiedBiome;
        resources = new ArrayList<Asset>(Arrays.asList(startResources));
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

    public ArrayList<Asset> getResources() {
        return resources;
    }

    public ArrayList<String> resourcesToString() {
        //copy biome to stringArray?
        String[] resourcesString = new String[resources.size()];
        for (Asset resource: resources) {
            resourcesString[i]
        }
    }

    public Biome getBiome() { return occupiedBiome; }

    public boolean build(final BuildingTile building, final int row, final int col) {

        // check for required resources and amount
        for (Map.Entry<Resource, Double> mapEntry : building.getResourceCost().entrySet()) {
            boolean foundResource = false;
            for (int i = 0; i < resources.size(); i++) {
                // look for the matching resource
                if (resources.get(i).getResource() == mapEntry.getKey()) {
                    // found the matching resource
                    if (resources.get(i).getAmount() >= mapEntry.getValue()) {
                        // do we have enough resource?
                        resources.get(i).addToAmount(-mapEntry.getValue());
                        foundResource = true;
                        break;
                    }
                    else return false; // not enough of that resource
                }
            }
            if (!foundResource) return false; // didn't have that specific resource or amount
        }
        // build it if a valid location (replaceTile might do too much)
        // apply the building's effect (increase food, population rate, etc...)
        // if (below) then apply (effect from building)
        return occupiedBiome.replaceTile(building, row, col);
    }
}
