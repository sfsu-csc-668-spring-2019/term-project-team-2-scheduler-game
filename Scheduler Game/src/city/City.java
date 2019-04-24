package city;

import java.util.ArrayList;

public class City {
    private int streak;
    private int cityID;
    private ArrayList<Building> buildings;
    private Money budget;
    private int exp;
    private int lvl;
    private int expGoal; //TODO: Make a list of experience goals. Maybe need another class
    private int expRate;
    private EventManager eventManager;


    public City(int cityID){
        this.cityID = cityID;
        budget = new Money(0);
        buildings = new ArrayList<>();
        exp = 0;
        lvl = 0;
        streak = 0;
        expRate = 1;
        expGoal = 100;
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

    public void Update(){

    }

}
