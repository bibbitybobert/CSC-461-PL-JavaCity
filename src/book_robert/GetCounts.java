package book_robert;

public class GetCounts implements Visitor{
    public int greenspace_count = 0;
    public int empty_count = 0;
    public int street_count = 0;
    public int water_count = 0;
    public int building_count = 0;

    public void acceptEmpty(Empty e){
        this.empty_count++;
    }

    public void acceptStreet(Street s){
        this.street_count++;
    }

    public void acceptGreenspace(Greenspace g){
        this.greenspace_count++;
    }

    public void acceptWater(Water w){
        this.water_count++;
    }
    public void acceptBuilding(Building b) {
        this.building_count++;
    }

    public int emptyCount(){
        return empty_count;
    }

    public int streetCount(){
        return street_count;
    }

    public int greenspaceCount(){
        return greenspace_count;
    }

    public int waterCount(){
        return water_count;
    }

    public int buildingCount(){
        return building_count;
    }
}
