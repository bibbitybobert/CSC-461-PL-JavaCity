package book_robert;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Grading tags in for all lines marked with *	_Yes_

The visitor pattern is used 				_Yes_
Handles bad input with 1 try-catch			_Yes_
Threw the exception in tier 8 (rezone)		_Yes_

Tier 1: running and menu working 			_Yes_
Tier 2: set any object at 0, 0 				_Yes_
Tier 3: set any object at anywhere			_Yes_
Tier 4: handles bad input at this point		_Yes_
Tier 5: default grid displays properly 		_Yes_
Tier 6: count types * 					    _Yes_
Tier 7: coloring and menus completed*		_Yes_
Tier 8: Rezone *					        _Yes_
Tier 9: Fix roads*			  		        _Yes_
     All adjacent pullable objects removed		        _Yes_
     At least one pullable objects are pulled inwards	_Yes_

 */

public class CityStart {
    /**
     * Scanner used for input
     */
    public static Scanner cin;

    /**
     * Main function for handling user input and error catching
     *
     * @param args arguments passed into the program
     */
    public static void main(String[] args) {

        City c = new City();
        cin = new Scanner(System.in);
        String menu =
                "1) Set Tile\n"+
                "2) Make Default City\n"+
                "3) Count Zones\n"+
                "4) Set Tile Color\n"+
                "5) Rezone\n"+
                "6) Fix Roads\n"+
                "0) Quit\n";

        int input = -1;
        while(input != 0) {
            try {
                c.print();
                System.out.println(menu);
                System.out.print("Choice:> ");

                input = cin.nextInt();
                switch (input) {
                    case 1 -> set_tile(c);
                    case 2 -> c = make_default_city();
                    case 3 -> count_zones(c);
                    case 4 -> set_tile_color(c);
                    case 5 -> rezone_command(c);
                    case 6 -> fix_roads(c);
                    case 0 -> {}
                    default -> throw new ArithmeticException();
                }
            } catch (InsufficientOpenAreaException i) {
                System.out.println("Insufficient open areas");
                input = -1;
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer");
                cin.next();
                input = -1;
            } catch (ArithmeticException a) {
                System.out.println("Number is out of range");
                input = -1;
            }
        }


    }

    /**
     * Helper function for setting tiles in the city.
     * Used as a submenu for when a user wants to change a singular tile type.
     * Can throw errors but errors are handled in the main() function.
     *
     * @param city city obj to modify
     */
    private static void set_tile(City city){
        int x_loc, y_loc, tile_type;
        System.out.print("Input tile type " +
                "1) greenspace " +
                "2) water " +
                "3) road " +
                "4) building " +
                "5) empty:> ");
        tile_type = cin.nextInt();
        if(tile_type > 5 || tile_type < 1){
            throw new ArithmeticException();
        }
        System.out.print("input location (x y): ");
        y_loc = cin.nextInt();
        if(y_loc < 0 || y_loc > city.size_y){
            throw new ArithmeticException();
        }
        x_loc = cin.nextInt();
        if(x_loc < 0 || x_loc > city.size_x){
            throw new ArithmeticException();
        }
        System.out.println();

        switch (tile_type) {
            case 1 -> city.replace(x_loc, y_loc, new Greenspace());
            case 2 -> city.replace(x_loc, y_loc, new Water());
            case 3 -> city.replace(x_loc, y_loc, new Street());
            case 4 -> city.replace(x_loc, y_loc, new Building());
            case 5 -> city.replace(x_loc, y_loc, new Empty());
            default -> throw new ArithmeticException();
        }


    }

    /**
     * Helper function to overwrite the city obj with a new default city
     *
     * @return new city obj with content in it
     */
    public static City make_default_city(){
        City city = new City(7, 7);
        int[][] city_map = {{1, 1, 1, 1, 1, 1, 1},
                            {1, 2, 1, 0, 1, 0, 0},
                            {1, 1, 1, 1, 1, 3, 3},
                            {1, 2, 1, 0, 1, 4, 3},
                            {1, 2, 0, 2, 1, 4, 3},
                            {1, 2, 2, 2, 1, 4, 3},
                            {1, 1, 1, 1, 1, 4, 3}};
        for( int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                switch(city_map[i][j]){
                    case 0 -> city.replace(i, j, new Empty());
                    case 1 -> city.replace(i, j, new Street());
                    case 2 -> city.replace(i, j, new Building());
                    case 3 -> city.replace(i, j, new Water());
                    case 4 -> city.replace(i, j, new Greenspace());
                }
            }
        }
        return city;

    }

    /**
     * Helper function used to manage the counter Visitor and deal with output.
     *
     * @param city city to look at with the GetCounts Visitor
     */
    public static void count_zones(City city){
        GetCounts counter = new GetCounts();
        city.accept(counter); //GRADING: COUNT
        System.out.println("Empty: " + counter.emptyCount());
        System.out.println("Buildings: " + counter.buildingCount());
        System.out.println("Greenspaces: " + counter.greenspaceCount());
        System.out.println("Roads: " + counter.streetCount());
        System.out.println("Water: " + counter.waterCount());

    }

    /**
     * Helper function to manage the ChangeColor visitor. Also acts as a submenu of
     * main(). This function can throw errors, but all errors are handled in the try
     * catch block in main()
     *
     * @param c city to accept the ChangeColor visitor
     */
    public static void set_tile_color(City c){
        int tile_type, new_color_int;
        ColorText.Color new_color;
        System.out.println("Input tile type 1) building 2) road 3) non-structure:> ");
        tile_type = cin.nextInt();
        if(tile_type > 4 || tile_type < 1){
            throw new ArithmeticException();
        }
        System.out.println("Input color 1) red 2) orange 3) blue 4) green 5) black:> ");
        new_color_int = cin.nextInt();
        switch(new_color_int){
            case 1 -> new_color = ColorText.Color.RED;
            case 2 -> new_color = ColorText.Color.ORANGE;
            case 3 -> new_color = ColorText.Color.BLUE;
            case 4 -> new_color = ColorText.Color.GREEN;
            case 5 -> new_color = ColorText.Color.BLACK;
            default -> throw new ArithmeticException();
        }
        ChangeColor color_visitor = new ChangeColor(new_color, tile_type);
        c.accept(color_visitor); //GRADING: COLOR
    }

    /**
     * Helper function to deal with the Rezone visitor. This function can throw
     * errors, but all errors are handled in the main() function
     *
     * @param c city obj to accept the Rezone visitor
     * @throws InsufficientOpenAreaException error if there is not enough open areas
     *                                      to properly use the Rezone visitor
     */
    public static void rezone_command(City c) throws InsufficientOpenAreaException {
        GetCounts counter = new GetCounts();
        Rezone rezone_visitor = new Rezone(c);
        c.accept(counter);
        if(counter.emptyCount() < 5){
            c.accept(rezone_visitor); //GRADING: REZONE
        }
        else{
            throw new InsufficientOpenAreaException();
        }

    }


    /**
     * Helper function to handle the FixRoads visitor
     * @param c city to accept the FixRoads visitor
     */
    public static void fix_roads(City c){
        FixRoads FRVisitor = new FixRoads(c.Grid);
        c.accept(FRVisitor);
    }

}
