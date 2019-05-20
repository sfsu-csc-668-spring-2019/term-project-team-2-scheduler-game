package scheduler;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class DBManager {


    public void DBManager(){

    }

    public void updateProject(User user, JSONArray projects){


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(user.getName())){
                System.out.println(jsonObject.get(user.getName()));
                JSONObject temp = (JSONObject) jsonObject.get(user.getName());
                temp.put("projects", projects);
                jsonObject.put(user.getName(), temp);


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


    public JSONArray getProject(User user){


        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(user.getName())){
                System.out.println(jsonObject.get(user.getName()));
                JSONObject temp = (JSONObject) jsonObject.get(user.getName());
                return (JSONArray) temp.get("projects");


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    public User checkLogin(String username, String password){

        User user = new User();
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("database.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);



            if(jsonObject.containsKey(username)){
                System.out.println(jsonObject.get(username));
                JSONObject temp = (JSONObject) jsonObject.get(username);

                if(temp.get("password").equals(password)){
                    user.setName(username);
                    user.setPassword(password);
                    return user;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }


    public User createUser(String username, String password) {


        User user = new User(username, password);
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

        return user;
    }

}