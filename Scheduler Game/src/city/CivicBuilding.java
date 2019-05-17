package city;

import java.util.ArrayList;

public class CivicBuilding extends Building{


    public CivicBuilding (ArrayList<Integer> coord, int lvl){
        super(coord, lvl);
    }

    public void execute(City city){
        city.modifyEvents(this.fullModifier);
    }
}
