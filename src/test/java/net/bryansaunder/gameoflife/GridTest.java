package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

/**
 * Tests for the Grid.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class GridTest {

    /**
     * Valid grid is created.
     */
    @Test
    public void gridCreation() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        assertNotNull(grid);
        
        assertEquals(Grid.MIN_GRID_SIZE, grid.getSize());
    }

    /**
     * If grid size < 3, throw IllegalArgumentException.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void ifSmallGridSizeThenThrowException() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE - 1);
    }

    /**
     * Tests that all cells are dead after initialization.
     */
    @Test
    public void gridIsInitializedAndAllCellsDead() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        for (final Cell cell : grid) {
            if (cell == null) {
                fail("Cell not properly initalized.");
            }
        }
    }

    /**
     * Tests setting a cell at the start.
     */
    @Test
    public void setCellAtStart() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        final Position startPos = new Position(0, 0);
        grid.setCell(startPos, true);

        assertTrue(grid.getCell(startPos).isAlive());
    }

    /**
     * Tests setting a cell at the end.
     */
    @Test
    public void setCellAtEnd() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        final Position endPos = new Position(2, 2);
        grid.setCell(endPos, true);

        assertTrue(grid.getCell(endPos).isAlive());
    }

    /**
     * Tests setting a cell in the middle.
     */
    @Test
    public void setCellInMiddle() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        final Position middlePos = new Position(1, 1);
        grid.setCell(middlePos, true);

        assertTrue(grid.getCell(middlePos).isAlive());
    }

    /**
     * Tests that neighbors are set properly in a grid when the cell is the center.
     */
    @Test
    public void setNeighborsInMiddle() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        // Set the Neighbors
        grid.setNeighbors();

        // Check Neighbors
        final Cell middleCell = grid.getCell(new Position(1, 1));
        final List<Cell> neighbors = middleCell.getNeighbors();

        assertEquals(8, neighbors.size());

        assertTrue(neighbors.contains(grid.getCell(new Position(0, 1))));
        assertTrue(neighbors.contains(grid.getCell(new Position(0, 1))));
        assertTrue(neighbors.contains(grid.getCell(new Position(0, 2))));
        assertTrue(neighbors.contains(grid.getCell(new Position(1, 0))));
        assertTrue(neighbors.contains(grid.getCell(new Position(1, 2))));
        assertTrue(neighbors.contains(grid.getCell(new Position(2, 0))));
        assertTrue(neighbors.contains(grid.getCell(new Position(2, 1))));
        assertTrue(neighbors.contains(grid.getCell(new Position(2, 2))));
    }

    /**
     * Tests that neighbors are set properly in a grid when the cell is the bottom right corner.
     */
    @Test
    public void setNeighborsInCorner() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        // Set the Neighbors
        grid.setNeighbors();

        // Check Neighbors
        final Cell middleCell = grid.getCell(new Position(2, 2));
        final List<Cell> neighbors = middleCell.getNeighbors();

        assertEquals(3, neighbors.size());

        assertTrue(neighbors.contains(grid.getCell(new Position(1, 1))));
        assertTrue(neighbors.contains(grid.getCell(new Position(1, 2))));
        assertTrue(neighbors.contains(grid.getCell(new Position(2, 1))));
    }

    /**
     * Tests the Algorithm to get the positions of all the possible neighbors at 1,1.
     */
    @Test
    public void getNeighborPositionsForOneOne() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        final Position center = new Position(1, 1);
        final List<Position> positions = grid.getNeighborPositions(center);
        assertEquals(8, positions.size());

        assertTrue(positions.contains(new Position(0, 0)));
        assertTrue(positions.contains(new Position(0, 1)));
        assertTrue(positions.contains(new Position(0, 2)));
        assertTrue(positions.contains(new Position(1, 0)));
        assertFalse(positions.contains(new Position(1, 1)));
        assertTrue(positions.contains(new Position(1, 2)));
        assertTrue(positions.contains(new Position(2, 0)));
        assertTrue(positions.contains(new Position(2, 1)));
        assertTrue(positions.contains(new Position(2, 2)));
    }

    /**
     * Tests the Algorithm to get the positions of all the possible neighbors at 2,2.
     */
    @Test
    public void getNeighborPositionsForTwoTwo() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        final Position center = new Position(2, 2);
        final List<Position> positions = grid.getNeighborPositions(center);
        assertEquals(3, positions.size());

        assertFalse(positions.contains(new Position(0, 0)));
        assertFalse(positions.contains(new Position(0, 1)));
        assertFalse(positions.contains(new Position(0, 2)));
        assertFalse(positions.contains(new Position(1, 0)));
        assertTrue(positions.contains(new Position(1, 1)));
        assertTrue(positions.contains(new Position(1, 2)));
        assertFalse(positions.contains(new Position(2, 0)));
        assertTrue(positions.contains(new Position(2, 1)));
        assertFalse(positions.contains(new Position(2, 2)));
    }

    /**
     * Tests all Cells are Killed.
     */
    @Test
    public void testKillAll() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();
        grid.killAll();

        for (final Cell cell : grid) {
            if (cell.isAlive()) {
                fail("Cell is not dead.");
            }
        }
    }
}
