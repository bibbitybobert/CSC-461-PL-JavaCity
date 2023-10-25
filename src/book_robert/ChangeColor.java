package book_robert;

/**
 * Change Color Visitor to modify the color of Tiles without knowing the tile type
 */
public class ChangeColor implements Visitor{

    /**
     * color to change the given tile to
     */
    public ColorText.Color color;

    /**
     * used to determine between building, road, or non-structure
     * 1 = building
     * 2 = street
     * 3 = non-structure
     */
    public int group;


    /**
     * Main Constructor
     * @param c color to change the tile to
     * @param t group that each tile belongs to
     */
    public ChangeColor(ColorText.Color c, int t){
        this.color = c;
        this.group = t;
    }

    /**
     * overridden acceptEmpty function taken from main Visitor interface
     * @param empty Empty obj (if an Empty tile this Visitor does not affect)
     */
    public void acceptEmpty(Empty empty){}

    /**
     * Overridden acceptStreet function taken from main Visitor interface
     * @param street Street obj to change color of
     */
    public void acceptStreet(Street street){
        if(group == 2)
            street.color = color;
    }

    /**
     * Overridden acceptGreenspace function taken from main Visitor interface
     * @param greenspace Greenspace obj to change color of
     */
    public void acceptGreenspace(Greenspace greenspace){
        if(group == 3)
            greenspace.color = color;
    }

    /**
     * Overridden acceptWater function taken from main Visitor interface
     * @param water Water obj to change color of
     */
    public void acceptWater(Water water){
        if(group == 3)
            water.color = color;
    }

    /**
     * Overridden acceptBuilding function taken from main Visitor interface.
     * @param building Building obj to change color of
     */
    public void acceptBuilding(Building building){
        if(group == 1)
            building.color = color;
    }

}
