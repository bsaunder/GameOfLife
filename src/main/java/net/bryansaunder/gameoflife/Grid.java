package net.bryansaunder.gameoflife;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the Grid for the Game.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class Grid extends ArrayList<Cell> {

    /**
     * Minimum Grid Size.
     */
    public static final Integer MIN_GRID_SIZE = 3;

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = 1L;

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
     * Initialize the grid. All cells get a random state.
     */
    public void initalize() {
        final Integer gridSize = this.size * this.size;
        for (Integer i = 0; i < gridSize; i++) {
            final Cell cell = CellFactory.getRandomInstance();
            this.add(i, cell);
        }
    }

    /**
     * Gets the cell at the specified position.
     * 
     * @param position
     *            Position of cell to get
     * @return Cell at given position
     */
    public Cell getCell(final Position position) {
        final Integer index = position.getIndex(this.size);
        return this.get(index);
    }

    /**
     * Sets the state of the cell at the given position.
     * 
     * @param cellPosition
     *            Position of cell
     * @param newState
     *            New cell state
     */
    public void setCell(final Position cellPosition, final boolean newState) {
        final Integer index = cellPosition.getIndex(this.size);
        final Cell cell = this.get(index);
        cell.setAlive(newState);
    }

    /**
     * Sets the neighbors for all of the Cells.
     */
    public void setNeighbors() {
        for (final Cell cell : this) {
            // Get Index
            final Integer index = this.indexOf(cell);

            // Get Position
            final Position position = Position.getPosition(index, this.size);

            // Find Neighbors
            final List<Position> possibleNeighbors = this.getNeighborPositions(position);

            // Add Neighbors
            for (final Position neighborPosition : possibleNeighbors) {
                final Integer neighborIndex = neighborPosition.getIndex(this.size);
                final Cell neighbor = this.get(neighborIndex);
                cell.addNeighbor(neighbor);
            }
        }
    }

    /**
     * Gets the Positions for the neighbors of the center.
     * 
     * @param center
     *            Center position
     * @return List of positions
     */
    protected final List<Position> getNeighborPositions(final Position center) {
        final List<Position> neighborPositions = new LinkedList<Position>();

        final Integer x = center.getX();
        final Integer y = center.getY();

        for (Integer c = x - 1; c <= x + 1; c++) {
            for (Integer r = y - 1; r <= y + 1; r++) {
                if (c == x && r == y) {
                    continue;
                }

                if ((-1 < c && c < this.size) && (-1 < r && r < this.size)) {
                    neighborPositions.add(new Position(c, r));
                }
            }
        }

        return neighborPositions;

    }

    /**
     * Kills all cells on the grid.
     */
    public void killAll() {
        for (final Cell cell : this) {
            cell.setAlive(false);
        }
    }

    /**
     * Triggers All the Cells to Update.
     */
    public void update() {
        for (final Cell cell : this) {
            cell.updateNewState();
        }

        for (final Cell cell : this) {
            cell.applyNewState();
        }
    }

    /**
     * Gets the grid size.
     * 
     * @return Size of the grid
     */
    public Integer getSize() {
        return this.size;
    }

}
