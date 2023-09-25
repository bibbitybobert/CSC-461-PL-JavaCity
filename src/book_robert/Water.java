package book_robert;

public class Water extends Tile{
    public Water(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '~';
    }

    public void accept(Visitor v){
        v.acceptWater(this);
    }
}
