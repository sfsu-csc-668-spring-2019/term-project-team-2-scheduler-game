package city;

public class CivicBuilding extends Building{


    public CivicBuilding (int [] coord, int lvl){
        super(coord, lvl);
    }

    public void execute(City city){
        city.modifyEvents(this.fullModifier);
    }
}
