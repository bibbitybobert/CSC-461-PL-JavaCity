package book_robert;

/**
 * Visitor implementing the Visitor interface that checks if a tile is a Street Tile type
 */
public class IsRoad implements Visitor{

    /**
     * Unless shown otherwise, assume all tiles are NOT roads
     */
    private boolean isRoad = false;

    /**
     * Overridden acceptBuilding function taken from Visitor interface. Buildings are not
     * roads so set isRoad tag to false.
     * @param building Building Tile type that accepted this visitor
     */
    public void acceptBuilding(Building building) {
        this.isRoad = false;
    }

    /**
     * Overridden acceptEmpty function taken from Visitor interface. Empty tiles are not
     * roads so set isRoad tag to false.
     * @param empty Empty Tile type that accepted this visitor
     */
    public void acceptEmpty(Empty empty) {
        this.isRoad = false;
    }

    /**
     * Overridden acceptGreenspace function taken from Visitor interface. Greenspaces are
     * not roads so set isRoad tag to false.
     * @param greenspace Greenspace Tile type that accepted this visitor
     */
    public void acceptGreenspace(Greenspace greenspace) {
        this.isRoad = false;
    }

    /**
     * Overridden acceptGreenspace function taken from Visitor interface. Streets ARE roads
     * so set isRoad tag to true.
     * @param street Street Tile type that accepted this visitor
     */
    public void acceptStreet(Street street) {
        this.isRoad = true;
    }

    /**
     * Overridden acceptWater function taken from Visitor interface. Water tiles are not
     * roads so set isRoad tag to false.
     * @param water Water Tile Type that accepted this visitor
     */
    public void acceptWater(Water water) {
        this.isRoad = false;
    }

    /**
     * Function that returns whether the Tile that accepted this visitor is a Street tile tyep or not
     * @return true if the Tile that accepted this visitor is a Street Tile
     */
    public boolean getIsRoad(){
        return isRoad;
    }
}
