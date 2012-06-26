/**
 * 
 */
package net.bryansaunder.gameoflife;

/**
 * Main Class.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public final class Main {

    /**
     * Private default constructor.
     */
    private Main() {
        // Dont instantiate me!
    }

    /**
     * Main Method. It has a Blinker.
     * 
     * @param args
     *            Command line args.
     */
    public static void main(final String[] args) {
        final GameBoard board = new GameBoard(5);

        board.killAll();
        board.setCell(new Position(2, 1), true);
        board.setCell(new Position(2, 2), true);
        board.setCell(new Position(2, 3), true);

        board.print();
        board.tick();
        System.out.println("====================================");
        board.print();
    }
}
