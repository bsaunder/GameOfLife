/**
 * 
 */
package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Cell Tests.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class CellTest {

    /**
     * Cell is created and is dead.
     */
    @Test
    public void cellCreatedDead() {
        final Cell cell = new Cell(false);

        assertFalse(cell.isAlive());
    }

    /**
     * Cell is created and is alive.
     */
    @Test
    public void cellCreatedAlive() {
        final Cell cell = new Cell(true);

        assertTrue(cell.isAlive());
    }

    /**
     * Alive cell with one alive neighbor should die.
     */
    @Test
    public void isAliveAndOneThenDie() {
        final Cell cell = new Cell(true);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        cell.update();
        
        assertFalse(cell.isAlive());
    }
    
    /**
     * Dead cell with one alive neighbor should stay dead.
     */
    @Test
    public void isDeadAndOneThenStayDead() {
        final Cell cell = new Cell(false);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        cell.update();
        
        assertFalse(cell.isAlive());
    }
    
    /**
     * Alive cell with two alive neighbors should stay alive.
     */
    @Test
    public void isAliveAndTwoThenStayAlive() {
        final Cell cell = new Cell(true);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        cell.update();
        
        assertTrue(cell.isAlive());
    }
    
    /**
     * Dead cell with two alive neighbors should stay dead.
     */
    @Test
    public void isDeadAndTwoThenStayDead() {
        final Cell cell = new Cell(false);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        cell.update();
        
        assertFalse(cell.isAlive());
    }
    
    /**
     * Alive cell with three alive neighbors should stay alive.
     */
    @Test
    public void isAliveAndThreeThenStayAlive() {
        final Cell cell = new Cell(true);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        final Cell cell4 = new Cell(true);
        cell.addNeighbor(cell4);
        
        cell.update();
        
        assertTrue(cell.isAlive());
    }
    
    /**
     * Dead cell with three alive neighbors should come to life. Zombie Rule.
     */
    @Test
    public void isDeadAndThreeThenZombie() {
        final Cell cell = new Cell(false);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        final Cell cell4 = new Cell(true);
        cell.addNeighbor(cell4);
        
        cell.update();
        
        assertTrue(cell.isAlive());
    }
    
    /**
     * Alive cell with four alive neighbors should die.
     */
    @Test
    public void isAliveAndFourThenDie() {
        final Cell cell = new Cell(true);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        final Cell cell4 = new Cell(true);
        cell.addNeighbor(cell4);
        
        final Cell cell5 = new Cell(true);
        cell.addNeighbor(cell5);
        
        cell.update();
        
        assertFalse(cell.isAlive());
    }
    
    /**
     * Dead cell with four alive neighbors should stay dead.
     */
    @Test
    public void isAliveAndFourThenStayDead() {
        final Cell cell = new Cell(true);
        assertNotNull(cell);

        final Cell cell2 = new Cell(true);
        cell.addNeighbor(cell2);
        
        final Cell cell3 = new Cell(true);
        cell.addNeighbor(cell3);
        
        final Cell cell4 = new Cell(true);
        cell.addNeighbor(cell4);
        
        final Cell cell5 = new Cell(true);
        cell.addNeighbor(cell5);
        
        cell.update();
        
        assertFalse(cell.isAlive());
    }
}
