package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for Cell Factory.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class CellFactoryTest {

    /**
     * Tests Living cells are created properly.
     */
    @Test
    public void getAliveCell() {
        Cell cell = CellFactory.getInstance(Cell.ALIVE);

        assertTrue(cell.isAlive());
    }

    /**
     * Tests Dead cells are created properly.
     */
    @Test
    public void getDeadCell() {
        Cell cell = CellFactory.getInstance(Cell.DEAD);

        assertFalse(cell.isAlive());
    }

    /**
     * Tests Invalid States are rejected properly.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void getCellWithInvalidState() {
        Cell cell = CellFactory.getInstance(5);
    }

    /**
     * Tests Random cells are created properly.
     */
    @Test
    public void getRandomCell() {
        Cell cell = CellFactory.getRandomInstance();

        assertNotNull(cell);
    }

}
