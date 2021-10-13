import biome.Biome;
import biome.Map;
import race.Asset;
import race.Kingdom;
import race.Race;

import java.util.ArrayList;

// could overload the method to just be printScreen (map), (kingdom) and (biome)
public class PrintTerminal {
    /**
     * Wrapper method for private method printScreen that prints the map and the player's kingdoms.
     * @param player
     * @param map
     */
    public static void printMapView(Race player, Map map) {
        // Map view (see visible biomes (not implemented) and owned Kingdoms)
        String[] menuOptions = {"", "Enter the number to go to that Kingdom."};

        String[] mapMenu = new String[player.getKingdoms().size() + 1 + menuOptions.length];
        mapMenu[0] = "Kingdom | row | column";

        for (int i = 0; i < player.getKingdoms().size(); i++) {
            mapMenu[i + 1] = i + ". " + player.getKingdoms().get(i).getMapLocation()[0] +
                     " " + player.getKingdoms().get(i).getMapLocation()[1];
        }
        System.arraycopy(menuOptions, 0, mapMenu, 1 + player.getKingdoms().size(), menuOptions.length);


        printScreen(map.toStringArray(), mapMenu);
    }

    // maybe split to biome view and kingdom view?

    /**
     * Wrapper method
     * @param player
     * @param currentBiome is the biome the player is currently looking at
     * @param menuOptions
     */
    public static void printBiomeView(Race player, Biome currentBiome, String[] menuOptions) {
        String[] biomeMenu;
        Kingdom currentKingdom = player.getKingdom(currentBiome);
        if (currentKingdom != null) {
            // Kingdom view

            ArrayList<Asset> currentResouces = currentKingdom.getResources();
            biomeMenu = new String[currentResouces.size() + menuOptions.length];
            for (int i = 0; i < currentResouces.size(); i++) {
                biomeMenu[i] = currentResouces.get(i).getResource().name() + ": "
                        + (int)currentResouces.get(i).getAmount();
            }
            System.arraycopy(menuOptions, 0, biomeMenu, currentResouces.size(), menuOptions.length);
        }
        else {
            // Biome only view
            // list players that exist?
            biomeMenu = new String[]{"(M)ap"};
        }
            // then have the sameish general menu?
        printScreen(currentBiome.toStringArray(), biomeMenu);
    }

    /**
     * For printing to a terminal screen. Combines two different String[]s by printing them on the same line.
     * @param board is the map or biome tiles
     * @param menu is the player options on the current screen
     */
    private static void printScreen(String[] board, String[] menu) {
        // make String[] a multi-argument variable?

        // change so menu can be longer than board if needed
        // and wordwrap menu strings
        for (int i = 0; i < board.length; i++) {
            if (i < menu.length) {
                //String menuSubString = menu[i].substring(0, menuWidth);
                System.out.printf("%s  |  %s\n", board[i], menu[i]);
            }
            else System.out.println(board[i]);
        }
    }
}
