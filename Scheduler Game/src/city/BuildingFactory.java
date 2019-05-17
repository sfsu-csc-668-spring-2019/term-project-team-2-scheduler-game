package city;

import java.util.ArrayList;

public class BuildingFactory {
    enum BuildingType {Commercial, Civic, Residential}

    static public Building Create(BuildingType buildingType, ArrayList<Integer> coord, int lvl){
        Building newBuilding = null;
        switch (buildingType) {
            case Commercial: newBuilding = new CommercialBuilding(coord, lvl);
                break;
            case Civic: newBuilding = new CivicBuilding(coord, lvl);
                break;
            case Residential: newBuilding = new ResidentialBuilding(coord, lvl);
                break;

        }
        return newBuilding;
    }
}
