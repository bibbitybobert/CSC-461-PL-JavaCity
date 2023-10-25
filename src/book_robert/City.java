package book_robert;

/*
▫ → empty area
⌂ → building
░ → green space
~ → water
━ → initial road
 */


import static book_robert.ColorText.Color.BLACK;

/**
 * Manager class for many types of tiles
 */
public class City {

    /**
     * Main 2D array to display and manage tiles
     */
    public Tile[][] Grid;

    /**
     * size of the y-axis of the grid variable
     */
    public int size_y;

    /**
     * size of the x-axis of the grid variable
     */
    public int size_x;


    /**
     * Empty constructor. Defaults new Cities to a 7x7 Grid
     */
    public City(){
        this(7, 7);
    }

    /**
     * Base constructor to create a new City obj
     * @param x_size size of the x-axis of the Grid
     * @param y_size size of the y-axis of the Grid
     */
    public City(int x_size, int y_size){
        this.size_x = x_size;
        this.size_y = y_size;
        this.Grid = new Tile[x_size][y_size];
        for( int i = 0; i < x_size; i++){
            for( int j = 0; j < y_size; j++){
                this.Grid[i][j] = new Empty();
                this.Grid[i][j].x = i;
                this.Grid[i][j].y = j;
            }
        }
    }

    /**
     * Function used to accept any Visitor for all tiles in the City
     * @param v visitor for all the tiles to accept
     */
    public void accept(Visitor v){
        for(Tile[] t1 : this.Grid){
            for(Tile t2 : t1){
                t2.accept(v);
            }
        }
    }

    /**
     * Used to print the City Grid in the correct format with the correct color per tile
     */
    public void print(){
        for(Tile[] t1 : this.Grid){
            for(Tile t2 : t1){
                System.out.print(ColorText.colorString(t2.symbol, t2.color));
            }
            System.out.print('\n');
        }
    }

    /**
     * Used to replace a tile in the city and update the contents of the tile
     * @param x x value of the tile getting replaced
     * @param y y value of the tile getting replaced
     * @param new_tile new Tile object to replace the old tile
     */
    public void replace(int x, int y, Tile new_tile){
        new_tile.x = x;
        new_tile.y = y;
        this.Grid[x][y] = new_tile;
    }

}
