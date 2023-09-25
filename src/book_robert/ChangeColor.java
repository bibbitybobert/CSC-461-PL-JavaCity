package book_robert;

public class ChangeColor implements Visitor{
    ColorText.Color color;

    public ChangeColor(ColorText.Color c){
        this.color = c;
    }
    public void acceptEmpty(Empty empty){
        empty.color = color;
    }
    public void acceptStreet(Street street){
        street.color = color;
    }

    public void acceptGreenspace(Greenspace greenspace){
        greenspace.color = color;
    }

    public void acceptWater(Water water){
        water.color = color;
    }

    public void acceptBuilding(Building building){
        building.color = color;
    }

}
