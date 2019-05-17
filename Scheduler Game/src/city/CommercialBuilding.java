package city;

import java.util.ArrayList;

public class CommercialBuilding extends Building {

    public CommercialBuilding (ArrayList<Integer> coord, int lvl){
        super(coord, lvl);
    }

    public void execute(City city){
        city.modifyIncome(this.fullModifier);
    }
}
