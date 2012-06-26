package net.bryansaunder.gameoflife;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests cases for the GameBoard.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class GameBoardTest {

    /**
     * Tests the Game Boards creation.
     */
    @Test
    public void testCreation() {
        final GameBoard board = new GameBoard(Grid.MIN_GRID_SIZE);

        assertNotNull(board);
    }
    
    
    /**
     * Tests Blinker Pattern.
     */
    @Test
    public void testBlinker() {
        final GameBoard board = new GameBoard(5);

        board.killAll();

        board.setCell(new Position(2, 1), true);
        board.setCell(new Position(2, 2), true);
        board.setCell(new Position(2, 3), true);

        board.tick();

        assertFalse(board.getCell(new Position(0, 1)).isAlive());
        assertFalse(board.getCell(new Position(1, 1)).isAlive());
        assertFalse(board.getCell(new Position(2, 1)).isAlive());
        assertFalse(board.getCell(new Position(3, 1)).isAlive());
        assertFalse(board.getCell(new Position(4, 1)).isAlive());
        assertFalse(board.getCell(new Position(0, 3)).isAlive());
        assertFalse(board.getCell(new Position(1, 3)).isAlive());
        assertFalse(board.getCell(new Position(2, 3)).isAlive());
        assertFalse(board.getCell(new Position(3, 3)).isAlive());
        assertFalse(board.getCell(new Position(4, 3)).isAlive());
        assertFalse(board.getCell(new Position(0, 2)).isAlive());
        assertFalse(board.getCell(new Position(4, 2)).isAlive());

        assertTrue(board.getCell(new Position(1, 2)).isAlive());
        assertTrue(board.getCell(new Position(2, 2)).isAlive());
        assertTrue(board.getCell(new Position(3, 2)).isAlive());

    }

    /**
     * Tests Beehive Pattern.
     */
    @Test
    public void testBeehive() {
        final GameBoard board = new GameBoard(6);

        board.killAll();

        board.setCell(new Position(1, 2), true);
        board.setCell(new Position(2, 1), true);
        board.setCell(new Position(2, 3), true);
        board.setCell(new Position(3, 1), true);
        board.setCell(new Position(3, 3), true);
        board.setCell(new Position(4, 2), true);

        board.tick();

        assertFalse(board.getCell(new Position(0, 0)).isAlive());
        assertFalse(board.getCell(new Position(1, 0)).isAlive());
        assertFalse(board.getCell(new Position(2, 0)).isAlive());
        assertFalse(board.getCell(new Position(3, 0)).isAlive());
        assertFalse(board.getCell(new Position(4, 0)).isAlive());
        assertFalse(board.getCell(new Position(5, 0)).isAlive());

        assertFalse(board.getCell(new Position(0, 1)).isAlive());
        assertFalse(board.getCell(new Position(1, 1)).isAlive());
        assertTrue(board.getCell(new Position(2, 1)).isAlive());
        assertTrue(board.getCell(new Position(3, 1)).isAlive());
        assertFalse(board.getCell(new Position(4, 1)).isAlive());
        assertFalse(board.getCell(new Position(5, 1)).isAlive());

        assertFalse(board.getCell(new Position(0, 2)).isAlive());
        assertTrue(board.getCell(new Position(1, 2)).isAlive());
        assertFalse(board.getCell(new Position(2, 2)).isAlive());
        assertFalse(board.getCell(new Position(3, 2)).isAlive());
        assertTrue(board.getCell(new Position(4, 2)).isAlive());
        assertFalse(board.getCell(new Position(5, 2)).isAlive());

        assertFalse(board.getCell(new Position(0, 3)).isAlive());
        assertFalse(board.getCell(new Position(1, 3)).isAlive());
        assertTrue(board.getCell(new Position(2, 3)).isAlive());
        assertTrue(board.getCell(new Position(3, 3)).isAlive());
        assertFalse(board.getCell(new Position(4, 3)).isAlive());
        assertFalse(board.getCell(new Position(5, 3)).isAlive());

        assertFalse(board.getCell(new Position(0, 4)).isAlive());
        assertFalse(board.getCell(new Position(1, 4)).isAlive());
        assertFalse(board.getCell(new Position(2, 4)).isAlive());
        assertFalse(board.getCell(new Position(3, 4)).isAlive());
        assertFalse(board.getCell(new Position(4, 4)).isAlive());
        assertFalse(board.getCell(new Position(5, 4)).isAlive());

    }

}
