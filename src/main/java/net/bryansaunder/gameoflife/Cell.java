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
     * Cell state.
     */
    private Boolean alive;

    /**
     * List of neighbor cells.
     */
    private final List<Cell> neighbors;

    /**
     * Creates cell with initial state.
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
     * Adds a cell as a neighbor.
     * 
     * @param neighbor
     *            Neighbor Cell to Add.
     */
    public void addNeighbor(final Cell neighbor) {
        if (neighbor != null) {
            this.neighbors.add(neighbor);
        }
    }

    /**
     * Checks game rules and updates cell status.
     */
    public void update() {
        Integer aliveCount = 0;
        for (Cell neighbor : this.neighbors) {
            if (neighbor.isAlive()) {
                aliveCount++;
            }
        }

        if (aliveCount < 2) {
            this.setAlive(false);
        }else if(!this.isAlive() && aliveCount == 3){
            this.setAlive(true);
        }else if(aliveCount > 3){
            this.setAlive(false);
        }
    }

    /**
     * Sets the state of the cell.
     * 
     * @param state
     *            New state of cell.
     */
    public void setAlive(final Boolean state) {
        this.alive = state;
    }

    /**
     * Gets the list of neighbors.
     * 
     * @return List of neighbor cells
     */
    public List<Cell> getNeighbors() {
        return this.neighbors;
    }
}
