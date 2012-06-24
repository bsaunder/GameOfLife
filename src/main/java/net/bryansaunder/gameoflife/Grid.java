package net.bryansaunder.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Grid for the Game.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class Grid {

    /**
     * Minimum Grid Size.
     */
    public static final int MIN_GRID_SIZE = 3;

    /**
     * Grid Size.
     */
    private final Integer size;

    /**
     * All of the Cells on the Grid.
     */
    private final List<Cell> cells;

    /**
     * Creates Grid of the specified size.
     * 
     * @param gridSize
     *            Grid size
     */
    public Grid(final Integer gridSize) {
        if (gridSize < MIN_GRID_SIZE) {
            throw new IllegalArgumentException("Grid size must be 3 or larger");
        }
        this.size = gridSize;
        this.cells = new ArrayList<Cell>(this.size * this.size);
    }

    /**
     * Gets the grid size.
     * 
     * @return Size of the grid.
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Gets the Array that represents the Cells.
     * 
     * @return 2D Cell Array
     */
    public List<Cell> getCells() {
        return this.cells;
    }

    /**
     * Initialize the grid. All cells get a random state.
     */
    public void initalize() {
        final Integer gridSize = this.size * this.size;
        for (Integer i = 0; i < gridSize; i++) {
            final Boolean randomState;
            if (Math.random() > 0.5) {
                randomState = true;
            } else {
                randomState = false;
            }
            final Cell cell = new Cell(randomState);
            this.cells.add(i, cell);
        }
    }

}
