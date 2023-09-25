package book_robert;

public class Empty extends Tile {
    public Empty(){
        this.color = ColorText.Color.BLACK;
        this.symbol = '▫';
    }

    public void accept(Visitor v){
        v.acceptEmpty(this);
    }
}
