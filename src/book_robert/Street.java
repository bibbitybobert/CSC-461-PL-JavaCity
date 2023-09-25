package book_robert;

public class Street extends Tile{
    boolean top, right, bottom, left;
    public Street(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '━';
    }

    public void accept(Visitor v){
        v.acceptStreet(this);
    }

}
