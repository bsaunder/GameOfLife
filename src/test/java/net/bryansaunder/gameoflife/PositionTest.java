/**
 * 
 */
package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class PositionTest {

    /**
     * Tests creation of a Position & the Getters.
     */
    @Test
    public void testPosition() {
        final Position p = new Position(5, 6);

        // jUnit needs this, using just 5 it doesnt like. Idunno.
        assertEquals(new Integer(5), p.getX());
        assertEquals(new Integer(6), p.getY());

        p.setX(4);
        p.setY(3);

        // jUnit needs this, using just 5 it doesnt like. Idunno.
        assertEquals(new Integer(4), p.getX());
        assertEquals(new Integer(3), p.getY());

    }

    /**
     * Test index calculation at 0,0.
     */
    @Test
    public void testGetIndexAtZeroZero() {
        final Position p = new Position(0, 0);
        final int index = p.getIndex(Grid.MIN_GRID_SIZE);

        assertEquals(0, index);
    }

    /**
     * Test index calculation at 2,2.
     */
    @Test
    public void testGetIndexAtTwoTwo() {
        final Position p = new Position(2, 2);
        final int index = p.getIndex(Grid.MIN_GRID_SIZE);

        assertEquals(8, index);
    }

    /**
     * Test index calculation at 1,1.
     */
    @Test
    public void testGetIndexAtOneOne() {
        final Position p = new Position(1, 1);
        final int index = p.getIndex(Grid.MIN_GRID_SIZE);

        assertEquals(4, index);
    }
    
    /**
     * Test index calculation at 2,1.
     */
    @Test
    public void testGetIndexAtTwoOne() {
        final Position p = new Position(2, 1);
        final int index = p.getIndex(Grid.MIN_GRID_SIZE);

        assertEquals(5, index);
    }

    /**
     * Test position calculation at Index 0.
     */
    @Test
    public void testGetPostionAtZero() {
        final Position p = Position.getPosition(0, Grid.MIN_GRID_SIZE);

        assertEquals(new Integer(0), p.getX());
        assertEquals(new Integer(0), p.getY());
    }
    
    /**
     * Test position calculation at Index 4.
     */
    @Test
    public void testGetPostionAtFour() {
        final Position p = Position.getPosition(4, Grid.MIN_GRID_SIZE);

        assertEquals(new Integer(1), p.getX());
        assertEquals(new Integer(1), p.getY());
    }
    
    /**
     * Test position calculation at Index 5.
     */
    @Test
    public void testGetPostionAtFive() {
        final Position p = Position.getPosition(5, Grid.MIN_GRID_SIZE);

        assertEquals(new Integer(2), p.getX());
        assertEquals(new Integer(1), p.getY());
    }
    
    /**
     * Test position calculation at Index 8.
     */
    @Test
    public void testGetPostionAtEight() {
        final Position p = Position.getPosition(8, Grid.MIN_GRID_SIZE);

        assertEquals(new Integer(2), p.getX());
        assertEquals(new Integer(2), p.getY());
    }

}
