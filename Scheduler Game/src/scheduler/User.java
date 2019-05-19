package scheduler;

import city.City;
import calendar.Calendar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class User {

    private String name;
    private String password;
    private int level;
    private float experience;

    private City city;
    private Calendar calendar;


    public User(){
        this.level = 0;
        this.experience = 0;

        this.city = new City();
        this.calendar = new Calendar();
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
        this.level = 0;
        this.experience = 0;

        this.city = new City();
        this.calendar = new Calendar();
    }

    public JSONObject getProject(){


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(this.name)){
                System.out.println(jsonObject.get(this.name));
                JSONObject temp = (JSONObject) jsonObject.get(this.name);
                return (JSONObject) temp.get("projects");


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateProject(JSONObject projects){


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(this.name)){
                System.out.println(jsonObject.get(this.name));
                JSONObject temp = (JSONObject) jsonObject.get(this.name);
                temp.put("projects", projects);
                jsonObject.put(this.name, temp);


                try (FileWriter file = new FileWriter("database.json", false)) {
                    file.write(jsonObject.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public int checkLogin(String username, String password){


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(username)){
                System.out.println(jsonObject.get(username));
                JSONObject temp = (JSONObject) jsonObject.get(username);

                if(temp.get("password").equals(password)){
                    this.name = username;
                    this.password = password;
                    return 0;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return 1;
    }


    public void createUser(String username, String password) {


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            JSONObject userInfo = new JSONObject();
            JSONArray projects = new JSONArray();
            JSONArray buildings = new JSONArray();

            userInfo.put("password" ,password);
            userInfo.put("projects" ,projects);
            userInfo.put("buildings",buildings);

            jsonObject.put(username, userInfo);



            try (FileWriter file = new FileWriter("database.json", false)) {
                file.write(jsonObject.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.name = username;
        this.password = password;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
