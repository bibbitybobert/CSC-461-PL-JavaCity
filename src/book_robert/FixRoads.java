package book_robert;

/**
 * Visitor to fix road tiles to make output look prettier
 */
public class FixRoads implements Visitor{

    /**
     * look_up array for the city so the function knows how to update each road
     * that accepts this visitor
     */
    private Tile[][] look_at;

    /**
     * Default constructor
     * @param grid the grid of a city to use as a lookup array
     */
    public FixRoads(Tile[][] grid){
        this.look_at = grid;
    }

    /**
     * Overridden acceptEmpty function from Visitor interface
     * (does nothing for this Visitor type)
     * @param e Empty tile type
     */
    public void acceptEmpty(Empty e){}

    /**
     * Overridden acceptGreenspace function from Visitor interface
     * (does nothing for this visitor type)
     * @param g Greenspace tile type
     */
    public void acceptGreenspace(Greenspace g){}

    /**
     * Overridden acceptBuilding function from Visitor interface
     * (does nothing for this visitor type)
     * @param b Building tile type
     */
    public void acceptBuilding(Building b){}

    /**
     * Overridden acceptStreet function from Visitor interface.
     * Calls helper function to modify the street tile type that accepted this Visitor
     * @param s Street tile type that accepted this visitor
     */
    public void acceptStreet(Street s){
        fixSymbol(s);
    }

    /**
     * Overridden acceptWater function from Visitor interface
     * (does nothing for this visitor type)
     * @param w Water tile type
     */
    public void acceptWater(Water w){}

    /**
     * Helper function that does all the changing of the tile that accepted
     * this Visitor. Checks tiles on all four cardinal directions to decide which
     * symbol to use for the specific street tile that accepted this visitor
     * @param s Street tile type that accepted this visitor
     */
    private void fixSymbol(Street s){
        boolean[] side_checks = {false, false, false, false};
        IsRoad isRoadVisitor = new IsRoad(); //GRADING: NESTED
        int[] x_vals = {s.x-1, s.x, s.x+1, s.x};
        int[] y_vals = {s.y, s.y+1, s.y, s.y-1};

        for(int i = 0; i < 4; i++){
            if(x_vals[i] >= 0 &&
                    x_vals[i] < this.look_at.length &&
                    y_vals[i] >= 0 &&
                    y_vals[i] < this.look_at[i].length) {
                look_at[x_vals[i]][y_vals[i]].accept(isRoadVisitor);
                if (isRoadVisitor.getIsRoad())
                        side_checks[i] = true;
            }
        }

        s.setAdjacencies(side_checks[0], side_checks[1], side_checks[2], side_checks[3]);

    }

}
