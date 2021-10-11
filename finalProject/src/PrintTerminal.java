import biome.Biome;
import biome.Map;
import race.Asset;
import race.Kingdom;
import race.Race;

import java.util.ArrayList;

// maybe should take another argument that prints above menu called stats?
public class PrintTerminal {
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


        printScreen(map.toStringArray(), mapMenu, 100);
    }

    // maybe split to biome view and kingdom view?
    public static void printBiomeView(Race player, Biome currentBiome) {
        String[] biomeMenu;
        Kingdom currentKingdom = player.getKingdom(currentBiome);
        if (currentKingdom != null) {
            // Kingdom view
            String[] menuOptions = {"", "(B)uild", "(M)ap"};

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
        printScreen(currentBiome.toStringArray(), biomeMenu, 100);
    }
    private static void printScreen(String[] board, String[] menu, int menuWidth) {
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
