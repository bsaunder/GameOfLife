package net.bryansaunder.gameoflife;

/**
 * Factory class for creating new cells.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public final class CellFactory {

    /**
     * Private constructor.
     */
    private CellFactory() {
        // Don't Instantiate me!
    }

    /**
     * Creates a new Cell based on the give Cell State.
     * 
     * @param cellState
     *            State of the new Cell
     * 
     * @return New Cell
     */
    public static Cell getInstance(final Integer cellState) {
        Cell newCell;
        if (cellState == Cell.ALIVE) {
            newCell = new Cell(true);
        } else if (cellState == Cell.DEAD) {
            newCell = new Cell(false);
        } else {
            throw new IllegalArgumentException("Invalid Cell State.");
        }
        return newCell;
    }

    /**
     * Creates a new Cell with a random state.
     * 
     * @return New Cell
     */
    public static Cell getRandomInstance() {
        boolean cellState = false;
        if (Math.random() > 0.5) {
            cellState = true;
        }
        return new Cell(cellState);
    }

}
