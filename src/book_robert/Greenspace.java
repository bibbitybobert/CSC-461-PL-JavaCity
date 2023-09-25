package book_robert;

public class Greenspace extends Tile{
    public Greenspace(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '░';
    }

    public void accept(Visitor v) {
        v.acceptGreenspace(this);
    }
}
