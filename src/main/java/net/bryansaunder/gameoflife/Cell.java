/**
 * 
 */
package net.bryansaunder.gameoflife;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Cell.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class Cell {

    /**
     * Cell State.
     */
    private final Boolean alive;

    /**
     * List of Neighbor Cells.
     */
    private final List<Cell> neighbors;

    /**
     * Creates Cell with Initial State.
     * 
     * @param state
     *            Initial Cell State.
     */
    public Cell(final Boolean state) {
        this.alive = state;
        this.neighbors = new LinkedList<Cell>();
    }

    /**
     * Gets Cell State.
     * 
     * @return Cell State, Alive or not.
     */
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Adds a Cell as a Neighbor.
     * 
     * @param neighbor
     *            Neighbor Cell to Add.
     */
    public void addNeighbor(final Cell neighbor) {
        if (neighbor != null) {
            this.neighbors.add(neighbor);
        }
    }
}
