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
            Boolean randomState = false;
            if (Math.random() > 0.5) {
                randomState = true;
            }
            final Cell cell = new Cell(randomState);
            this.cells.add(i, cell);
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
        return this.cells.get(index);
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
        final Cell cell = this.cells.get(index);
        cell.setAlive(newState);
    }

    /**
     * Sets the neighbors for all of the Cells.
     */
    public void setNeighbors() {
        for (final Cell cell : this.cells) {
            // Get Index
            final Integer index = this.cells.indexOf(cell);

            // Get Position
            final Position position = Position.getPosition(index, this.size);

            // Find Neighbors
            final List<Position> possibleNeighbors = this.getNeighborPositions(position);

            // Add Neighbors
            for (final Position neighborPosition : possibleNeighbors) {
                final Integer neighborIndex = neighborPosition.getIndex(this.size);
                final Cell neighbor = this.cells.get(neighborIndex);
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
    public List<Position> getNeighborPositions(final Position center) {
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
        for (final Cell cell : this.cells) {
            cell.setAlive(false);
        }
    }

    /**
     * Triggers All the Cells to Update.
     */
    public void update() {
        for (final Cell cell : this.cells) {
            cell.updateNewState();
        }
        
        for (final Cell cell : this.cells) {
            cell.applyNewState();
        }
    }

    /**
     * Prints the Grid to the Screen.
     */
    public void printGrid() {
        int c = 0;
        for (int i = 0; i < (this.size * this.size); i++) {
            final Cell cell = this.cells.get(i);
            if (cell.isAlive()) {
                System.out.print("[X]");
            } else {
                System.out.print("[ ]");
            }
            c++;

            if (c == this.size) {
                System.out.println();
                c = 0;
            }
        }
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
