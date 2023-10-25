package book_robert;

/*
▫ → empty area
⌂ → building
░ → green space
~ → water
━ → initial road
 */

/**
 * Abstract Super class that all other Tile Types are derived from.
 * (Other tiles are: Greenspace, Water, Road, Building, Empty)
 */
public abstract class Tile {

    /**
     * Variables to keep track of Tile location in a city.Grid
     */
    public int x, y;

    /**
     * Variable to keep track of how the user wants a tile to be colored for output
     */
    public ColorText.Color color;

    /**
     * Symbol to determine what each tile is after output
     */
    public char symbol;

    /**
     * Base class to be overridden that accepts Visitors of any type
     * @param v Visitor of any type for Tile to accept
     */
    public abstract void accept(Visitor v);

    /**
     * Function to get x address of a Tile
     * @return x address of a Tile in a City.Grid
     */
    public int getXVal(){
        return x;
    }

    /**
     * Function to get y address of a Tile
     * @return y address of a Tile in a City.Grid
     */
    public int getYVal(){
        return y;
    }
}
