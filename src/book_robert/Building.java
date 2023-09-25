package book_robert;

public class Building extends Tile{
    public Building(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '⌂';
    }

    public void accept(Visitor v){
        v.acceptBuilding(this);
    }
}
