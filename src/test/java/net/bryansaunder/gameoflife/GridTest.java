package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
    }

    /**
     * If grid size < 3, throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifSmallGridSizeThenThrowException() {
        Grid grid = new Grid(Grid.MIN_GRID_SIZE - 1);
    }

    /**
     * Tests that all cells are dead after initialization.
     */
    @Test
    public void gridIsInitializedAndAllCellsDead() {
        final Grid grid = new Grid(Grid.MIN_GRID_SIZE);
        grid.initalize();

        for (Cell cell : grid.getCells()) {
            if (cell == null) {
                fail("Cell not properly initalized.");
            }
        }
    }
}
