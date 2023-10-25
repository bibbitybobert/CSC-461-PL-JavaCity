package book_robert;

/**
 * Water Tile type derived from the default Tile class
 */
public class Water extends Tile{

    /**
     * Default constructor that sets default color and symbol
     */
    public Water(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '~';
    }

    /**
     * Overridden accept function that accepts a Visitor of any type
     * @param v Visitor of any type for this Tile to accept
     */
    public void accept(Visitor v){
        v.acceptWater(this);
    }
}
