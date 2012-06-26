package net.bryansaunder.gameoflife;

/**
 * Class to represent the Game Board and allow interactions with it.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class GameBoard {

    /**
     * Cell Grid.
     */
    private final Grid grid;

    /**
     * Creates a GameBoard and Initializes its grid.
     * 
     * @param size
     *            Size of the board
     */
    public GameBoard(final Integer size) {
        this.grid = new Grid(size);
        this.grid.initalize();
        this.grid.setNeighbors();
    }

    /**
     * Kills all the cells on the grid.
     */
    public void killAll() {
        this.grid.killAll();
    }

    /**
     * Progress the Board through one generation.
     */
    public void tick() {
        this.grid.update();
    }

    /**
     * Sets the Cell at the specified Position to the specified State.
     * 
     * @param cellPosition
     *            Cell position
     * @param newState
     *            New Cell state
     */
    public void setCell(final Position cellPosition, final Boolean newState) {
        this.grid.setCell(cellPosition, newState);
    }

    /**
     * Gets the cell at the specified position.
     * 
     * @param position
     *            Position of the cell
     * @return Cell
     */
    public Cell getCell(final Position position) {
        return this.grid.getCell(position);
    }


    /**
     * Prints the Grid to the Screen.
     */
    public void print() {
        final Integer gridSize = this.grid.getSize();
        final Integer cellCount = gridSize * gridSize;

        for (int i = 1; i <= (cellCount); i++) {
            final Cell cell = this.grid.get(i - 1);
            if (cell.isAlive()) {
                System.out.print("[X]");
            } else {
                System.out.print("[ ]");
            }

            if (i % (gridSize) == 0) {
                System.out.println();
            }
        }
    }
}
