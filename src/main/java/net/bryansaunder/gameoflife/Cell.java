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
     * Holder for New State.
     */
    private Boolean newState;

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
        this.newState = state;
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
    public void updateNewState() {
        Integer aliveCount = 0;
        for (final Cell neighbor : this.neighbors) {
            if (neighbor.isAlive()) {
                aliveCount++;
            }
        }

        if (aliveCount < 2) {
            this.setNewState(false);
        } else if (!this.isAlive() && aliveCount == 3) {
            this.setNewState(true);
        } else if (aliveCount > 3) {
            this.setNewState(false);
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
        this.newState = state;
    }

    /**
     * Gets the list of neighbors.
     * 
     * @return List of neighbor cells
     */
    public List<Cell> getNeighbors() {
        return this.neighbors;
    }

    /**
     * Gets the new state.
     * 
     * @return the newState
     */
    public Boolean getNewState() {
        return this.newState;
    }

    /**
     * Sets the new state.
     * 
     * @param newCellState
     *            the newState to set
     */
    public void setNewState(final Boolean newCellState) {
        this.newState = newCellState;
    }

    /**
     * Applies the new State of the Cell.
     */
    public void applyNewState() {
        this.setAlive(this.newState);
    }
}
