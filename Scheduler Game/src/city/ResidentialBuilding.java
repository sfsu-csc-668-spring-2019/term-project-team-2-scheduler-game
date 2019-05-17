package city;

import java.util.ArrayList;

public class ResidentialBuilding extends Building{
    public ResidentialBuilding (ArrayList<Integer> coord, int lvl) {
        super(coord, lvl);
    }

    public void execute(City city){
        city.modifyExperience(this.fullModifier);
    }
}
