package city;

import java.util.ArrayList;
import java.util.Scanner;

public class City {
    private int streak;
    private int cityID;
    private ArrayList<Building> buildings;
    private Money budget;
    private int exp;
    private int lvl;
    private int expGoal; //TODO: Make a list of experience goals.
    private float expRate;
    private EventManager eventManager;


    public City(){
        //this.cityID = cityID;
        budget = new Money(0);
        buildings = new ArrayList<>();
        exp = 0;
        lvl = 0;
        streak = 0;
        expRate = 1f;
        expGoal = 100;
        eventManager  = new EventManager(1);
    }

    public void completeTask(){
        if (streak < 0){
            streak = 0;
        }
        streak++;
        updateExperience();
        updateBudget();
    }

    private void updateBudget(){
        budget.gainIncome();
    }

    private void updateExperience(){
        exp += expRate * streak;
        updateLevel();
    }

    private void updateLevel(){
        if (exp >= expGoal){
            lvl++;
            expGoal += 100;
        }
    }

    public void incompleteTask(){
        if (streak > 0){
            streak = 0;
        }
        streak--;
    }

    protected void modifyEvents(float modifier){
        eventManager.modifyIncrease(modifier);
    }

    protected void modifyIncome(float modifier){
        budget.modifyIncome(modifier);
    }

    protected void modifyExperience(float modifier){
        expRate = (expRate * (1 + modifier));
    }

    public void Update(){
        Scanner scanner = new Scanner(System.in);
        //while (true) {
            System.out.print("Enter building type: ");
            String type = scanner.nextLine();
            System.out.print("Enter coordinates: ");
            int buildingX = scanner.nextInt();
            int buildingY = scanner.nextInt();
            ArrayList<Integer> coord = new ArrayList<>();
            coord.add(buildingX);
            coord.add(buildingY);
            BuildingFactory.BuildingType buildingType = null;
            if (type.equals("Residential")) {
                buildingType = BuildingFactory.BuildingType.Residential;
            }
            else if (type.equals("Commercial")) {
                buildingType = BuildingFactory.BuildingType.Commercial;
            }
            else if (type.equals("Civic")) {
                buildingType = BuildingFactory.BuildingType.Civic;
            }
            //Building newBuilding = BuildingFactory.Create(buildingType, coord, this.lvl);
            //buildings.add(newBuilding);
            updateBuildings();
        //}
    }

    private void updateBuildings(){
        for (Building building: buildings) {
            building.execute(this);
        }
    }

    public String toString(){
        StringBuilder cityString = new StringBuilder();
        cityString.append("Budget: " + budget.toString());
        cityString.append("\n");
        cityString.append(" Level: " + lvl + "\n Exp: " + exp + "/" + expGoal);


        return cityString.toString();
    }
    public void addBuilding(String type, ArrayList<Integer> coord){
        BuildingFactory.Create(type, coord, lvl);
    }
}
