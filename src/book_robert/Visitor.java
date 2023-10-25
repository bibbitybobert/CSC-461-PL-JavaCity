package book_robert;

/**
 * Default Visitor interface that all other Visitors are based off of
 */
public interface Visitor {

    /**
     * Function to be overridden that handles Empty Tile types
     * @param empty Empty Tile obj to handle
     */
    void acceptEmpty(Empty empty);

    /**
     * Function to be overridden that handles Street Tile types
     * @param street Street Tile obj to handle
     */
    void acceptStreet(Street street);

    /**
     * Function to be overridden that handles Greenspace Tile types
     * @param greenspace Greenspace Tile obj to handle
     */
    void acceptGreenspace(Greenspace greenspace);


    /**
     * Function to be overridden that handles Water Tile types
     * @param water Water Tile obj to handle
     */
    void acceptWater(Water water);

    /**
     * Function to be overridden that handles Building Tile types
     * @param building Building Tile obj to handle
     */
    void acceptBuilding(Building building);
}
