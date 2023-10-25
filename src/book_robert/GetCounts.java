package book_robert;

/**
 * Visitor derived from the Visitor interface used to count up the number of each
 * tile type a city has in it.
 */
public class GetCounts implements Visitor{

    /**
     * count of how many Greenspace tiles there are in a city
     */
    private int greenspace_count = 0;

    /**
     * count of how many Empty tiles there are in a city
     */
    private int empty_count = 0;

    /**
     * count of how many Street tiles there are in a city
     */
    private int street_count = 0;

    /**
     * count of how many Water tiles there are in a city
     */
    private int water_count = 0;

    /**
     * count of how many Building tiles there are in a city
     */
    private int building_count = 0;

    /**
     * Overridden acceptEmpty function taken from Visitor interface.
     * If an Empty tile accepts this visitor, it increments the Empty_count variable.
     * @param e Empty Tile type that accepted this Visitor
     */
    public void acceptEmpty(Empty e){
        this.empty_count++;
    }

    /**
     * Overridden acceptStreet function taken from Visitor interface.
     * If a Street tile accepts this visitor, it increments the Street_count variable.
     * @param s Street Tile type that accepted this Visitor
     */
    public void acceptStreet(Street s){
        this.street_count++;
    }

    /**
     * Overridden acceptGreenspace function taken from Visitor interface.
     * If a Greenspace tile accepts this visitor, it increments the
     * greenspace_count variable
     * @param g Greenspace Tile type that accepted this visitor
     */
    public void acceptGreenspace(Greenspace g){
        this.greenspace_count++;
    }

    /**
     * Overridden acceptWater function taken from Visitor interface.
     * If a Water tile accepts this visitor, it increments the water_count variable
     * @param w Water Tile type that accepted this visitor
     */
    public void acceptWater(Water w){
        this.water_count++;
    }

    /**
     * Overridden accept building function taken from Visitor interface.
     * If a Building tile accepts this visitor, it increments the Building_count
     * variable.
     * @param b Building Tile type that accepted this visitor
     */
    public void acceptBuilding(Building b) {
        this.building_count++;
    }

    /**
     * Functon to return how many Empty tiles were counted
     * @return number of Empty tiles in a city
     */
    public int emptyCount(){ return empty_count;}

    /**
     * Function to return how many Street tiles were counted.
     * @return number of Street tiles in a city
     */
    public int streetCount(){ return street_count;}

    /**
     * Function to return how many Greenspace tiles were counted.
     * @return number of Greenspace tiles in a city
     */
    public int greenspaceCount(){
        return greenspace_count;
    }

    /**
     * Function to return how many Water tiles were counted.
     * @return number of Water tiles in a city.
     */
    public int waterCount(){
        return water_count;
    }

    /**
     * Function to return how many Building tiles were counted.
     * @return number of Building tiles in a city.
     */
    public int buildingCount(){
        return building_count;
    }
}
