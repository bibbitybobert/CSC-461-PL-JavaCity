package book_robert;

/*
▫ → empty area
⌂ → building
░ → green space
~ → water
━ → initial road
 */


import static book_robert.ColorText.Color.BLACK;

public class City {
    Tile[][] Grid;

    int size_y;
    int size_x;

    //if called with no size default to a 7x7 grid
    public City(){
        this(7, 7);
    }

    //base constructor
    public City(int x_size, int y_size){
        this.size_x = x_size;
        this.size_y = y_size;
        this.Grid = new Tile[x_size][y_size];
        for( int i = 0; i < x_size; i++){
            for( int j = 0; j < y_size; j++){
                this.Grid[i][j] = new Empty();
            }
        }
    }


    public void accept(Visitor v){
        for(Tile[] t1 : this.Grid){
            for(Tile t2 : t1){
                t2.accept(v);
            }
        }
    }

    public void print(){
        for(Tile[] t1 : this.Grid){
            for(Tile t2 : t1){
                System.out.print(ColorText.colorString(t2.symbol, t2.color));
            }
            System.out.print('\n');
        }
    }

}
