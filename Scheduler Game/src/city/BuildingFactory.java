package city;

import java.util.ArrayList;

public class BuildingFactory {
    enum BuildingType {Commercial, Civic, Residential}

    static public Building Create(String type, ArrayList<Integer> coord, int lvl){
        Building newBuilding = null;
        BuildingType buildingType= null;
        if (type.equals("Commercial")){
            buildingType = BuildingType.Commercial;
        }
        if (type.equals("Residential")){
            buildingType = BuildingType.Residential;
        }
        if (type.equals("Civic")){
            buildingType = BuildingType.Civic;
        }
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
