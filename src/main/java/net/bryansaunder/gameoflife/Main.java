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
        final Grid grid = new Grid(5);
        grid.initalize();
        grid.setNeighbors();

        grid.killAll();
        grid.setCell(new Position(2, 1), true);
        grid.setCell(new Position(2, 2), true);
        grid.setCell(new Position(2, 3), true);

        grid.printGrid();
        grid.update();
        System.out.println("====================================");
        grid.printGrid();
    }
}
