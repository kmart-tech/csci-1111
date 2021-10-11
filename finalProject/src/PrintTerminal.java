// maybe should take another argument that prints above menu called stats?
public class PrintTerminal {
    public static void printGame(String[] board, String[] menu, int menuWidth) {
        // make String[] a multi-argument variable?

        // change so menu can be longer than board if needed
        // and wordwrap menu strings
        for (int i = 0; i < board.length; i++) {
            if (i < menu.length) {
                String menuSubString = menu[i].substring(0, menuWidth);
                System.out.printf("%s|%s", board[i], menuSubString);
            }
            else System.out.println(board[i]);
        }
    }
}
