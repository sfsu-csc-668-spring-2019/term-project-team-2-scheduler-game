package scheduler;

import city.City;
import calendar.Calendar;

public class User {

    private String name;
    private int hashedPassword;
    private int level;
    private float experience;

    private City city;
    private Calendar calendar;

    public User(String name, String password){
        this.name = name;
        this.hashedPassword = password.hashCode();
        this.level = 0;
        this.experience = 0;

        this.city = new City(1);
        this.calendar = new Calendar();
    }

    public boolean checkLogin(String username, String password){

        if (hashedPassword == password.hashCode() && name.equals(username)){
            System.out.println("Authentication Success");
            return true;
        }
        System.out.println("Authentication Failure");
        return false;
    }

    public boolean checkPassword(String password){
        return (this.hashedPassword == password.hashCode());
    }

}
