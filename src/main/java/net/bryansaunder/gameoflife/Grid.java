package net.bryansaunder.gameoflife;

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
    }

    /**
     * Gets the grid size.
     * 
     * @return Size of the grid.
     */
    public Integer getSize() {
        return this.size;
    }

}
