package book_robert;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
Grading tags in for all lines marked with *		___

The visitor pattern is used 				_Yes_
Handles bad input with 1 try-catch			___
Threw the exception in tier 8 (rezone)			___

Tier 1: running and menu working 			_Yes_
Tier 2: set any object at 0, 0 				_Yes_
Tier 3: set any object at anywhere			_Yes_
Tier 4: handles bad input at this point			___
Tier 5: default grid displays properly 			___
Tier 6: count types * 					___
Tier 7: coloring and menus completed*			___
Tier 8: Rezone *					___
Tier 9: Fix roads*			  		___
     All adjacent pullable objects removed		___
     At least one pullable objects are pulled inwards	___

 */

public class CityStart {
    public static Scanner cin;
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
        try {
            while(input != 0) {
                c.print();
                System.out.println(menu);
                System.out.print("Choice:> ");

                input = cin.nextInt();
                switch (input) {
                    case 1 -> set_tile(c);
                    case 2 -> make_default_city();
                    case 3 -> count_zones();
                    case 4 -> set_tile_color();
                    case 5 -> rezone();
                    case 6 -> fix_roads();
                    case 0 -> {}
                    default -> throw new ArithmeticException();
                }

            }
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer");
            main(args);
        }
        catch(ArithmeticException a){
            System.out.println("Number is out of range");
            main(args);
        }

    }

    private static void set_tile(City city){
        int x_loc, y_loc, tile_type;
        System.out.println("Input tile type " +
                "1) greenspace " +
                "2) water " +
                "3) road " +
                "4) building " +
                "5) empty:> ");
        tile_type = cin.nextInt();
        if(tile_type > 5 || tile_type < 1){
            throw new ArithmeticException();
        }
        System.out.println("input location (x y): ");
        y_loc = cin.nextInt();
        if(y_loc < 0 || y_loc > city.size_y){
            throw new ArithmeticException();
        }
        x_loc = cin.nextInt();
        if(x_loc < 0 || x_loc > city.size_x){
            throw new ArithmeticException();
        }

        switch (tile_type) {
            case 1 -> city.Grid[x_loc][y_loc] = new Greenspace();
            case 2 -> city.Grid[x_loc][y_loc] = new Water();
            case 3 -> city.Grid[x_loc][y_loc] = new Street();
            case 4 -> city.Grid[x_loc][y_loc] = new Building();
            case 5 -> city.Grid[x_loc][y_loc] = new Empty();
            default -> throw new ArithmeticException();
        }


    }

    public static void make_default_city(){

    }

    public static void count_zones(){

    }

    public static void set_tile_color(){

    }

    public static void rezone(){

    }

    public static void fix_roads(){

    }

}
