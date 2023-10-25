package book_robert;

/**
 * Empty Tile type derived from the Base Tile class
 */
public class Empty extends Tile {

    /**
     * Default constructor to set symbol and base color
     */
    public Empty(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '▫';
    }

    /**
     * Overridden accept function from tile used to accept any visitor type
     * @param v Visitor of any type to accept
     */
    public void accept(Visitor v){
        v.acceptEmpty(this);
    }
}
