package book_robert;

/*
▫ → empty area
⌂ → building
░ → green space
~ → water
━ → initial road
 */

public abstract class Tile {
    ColorText.Color color;
    char symbol;
    public abstract void accept(Visitor v);
}
