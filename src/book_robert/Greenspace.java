package book_robert;

/**
 * Greenspace Tile type
 */
public class Greenspace extends Tile{

    /**
     * Default Constructor that sets symbol and default color
     */
    public Greenspace(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '░';
    }

    /**
     * Overridden accept function taken from Tile class that accepts any Visitor type
     * @param v Visitor of any type to accept
     */
    public void accept(Visitor v) {
        v.acceptGreenspace(this);
    }
}
