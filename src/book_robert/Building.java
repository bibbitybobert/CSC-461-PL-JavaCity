package book_robert;

/**
 * Building Tile type
 */
public class Building extends Tile{

    /**
     * Main Constructor
     */
    public Building(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '⌂';
    }

    /**
     * Overridden accept function to deal with using Visitors
     * @param v the visitor to accept
     */
    public void accept(Visitor v){
        v.acceptBuilding(this);
    }
}
