package main;

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

        this.city = new City();
        this.calendar = new Calendar();
    }

    public boolean checkPassword(String password){
        return (this.hashedPassword == password.hashCode());
    }

}
