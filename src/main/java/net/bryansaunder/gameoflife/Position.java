/**
 * 
 */
package net.bryansaunder.gameoflife;

/**
 * Represents Cell Position.
 * 
 * @author Bryan Saunders <btsaunde@gmail.com>
 * 
 */
public class Position {

    /**
     * X Coordinate.
     */
    private Integer xCoord;

    /**
     * Y Coordinate.
     */
    private Integer yCoord;

    /**
     * Creates a Position with the specified X/Y.
     * 
     * @param x
     *            X coordinate.
     * @param y
     *            Y coordinate.
     */
    public Position(final Integer x, final Integer y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    /**
     * Gets the X coordinate.
     * 
     * @return the x
     */
    public Integer getX() {
        return this.xCoord;
    }

    /**
     * Sets the X coordinate.
     * 
     * @param x
     *            the x to set
     */
    public void setX(final Integer x) {
        this.xCoord = x;
    }

    /**
     * Gets the Y coordinate.
     * 
     * @return the y
     */
    public Integer getY() {
        return this.yCoord;
    }

    /**
     * Sets the y coordinate.
     * 
     * @param y
     *            the y to set
     */
    public void setY(final Integer y) {
        this.yCoord = y;
    }

    /**
     * Gets the Index of a cell in a list based on the X/Y coordinate and the row size.
     * 
     * @param rowSize
     *            Size of the row in the list
     * @return Index of the position
     */
    public Integer getIndex(final Integer rowSize) {
        final Integer index = (this.yCoord * rowSize) + this.xCoord;
        return index;
    }

    /**
     * Creates a position based on an index and row size.
     * 
     * @param index
     *            Index in list
     * @param size
     *            Row size
     * @return Position
     */
    public static Position getPosition(final Integer index, final Integer size) {
        final Integer y = index / size;
        final Integer x = index % size;
        return new Position(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        Integer result = 1;
        result = prime * result + ((this.xCoord == null) ? 0 : this.xCoord.hashCode());
        result = prime * result + ((this.yCoord == null) ? 0 : this.yCoord.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        Position other = (Position) obj;
        if (this.xCoord == null) {
            if (other.xCoord != null) {
                return false;
            }
        } else if (!this.xCoord.equals(other.xCoord)) {
            return false;
        }
        
        if (this.yCoord == null) {
            if (other.yCoord != null) {
                return false;
            }
        } else if (!this.yCoord.equals(other.yCoord)) {
            return false;
        }
        
        return true;
    }

}
