package book_robert;

/**
 * Visitor derived from the Visitor interface that replaces all Empty Tile
 * types with Greenspace Tiles
 */
public class Rezone implements Visitor{

    /**
     * Variable to call function that refactors the specific Tile
     */
    private City city;

    /**
     * Default constructor
     * @param c City object used to call a function that refactors tiles
     */
    public Rezone(City c){
        this.city = c;
    }

    /**
     * Overridden acceptEmpty function from Visitor interface. If the Tile
     * that accepted this visitor is an Empty Tile type, refactor it into
     * a Greenspace Tile type.
     * @param e Empty Tile type that accepted this visitor
     */
    public void acceptEmpty(Empty e){
        int x = e.getXVal();
        int y = e.getYVal();
        this.city.replace(x, y, new Greenspace());

    }

    /**
     * Overridden acceptStreet function from Visitor interface.
     * If the Tile Type that accepted this visitor is a Street, ignore it.
     * @param s Street Tile type that accepted this visitor
     */
    public void acceptStreet(Street s){}

    /**
     * Overridden acceptGreenspace function from Visitor interface.
     * If the Tile Type that accepted this visitor is a Greenspace,
     * ignore it.
     * @param g Greenspace Tile type that accepted this visitor
     */
    public void acceptGreenspace(Greenspace g){}

    /**
     * Overridden acceptWater function from Visitor interface.
     * If the Tile Type that accepted this visitor is a Water,
     * ignore it.
     * @param w Water Tile type that accepted this visitor
     */
    public void acceptWater(Water w){}

    /**
     * Overridden acceptBuilding function from Visitor interface.
     * If the Tile Type that accepted this visitor is a Building,
     * ignore it.
     * @param b Building Tile type that accepted this visitor
     */
    public void acceptBuilding(Building b){}
}
