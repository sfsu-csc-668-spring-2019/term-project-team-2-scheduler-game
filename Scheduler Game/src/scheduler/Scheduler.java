package scheduler;

import com.sun.xml.internal.bind.v2.TODO;
import gui.PanelProject;
import org.json.simple.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.io.FileWriter;
import org.json.simple.parser.*;

import calendar.Project;
import calendar.Task;
import gui.FrameMain;
import gui.NotificationFrame;
import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.Timer;

import gui.FrameLogin;

public class Scheduler extends TimerTask {

    private int status;


    //private User user = new User();

    private static DBManager dbManager = new DBManager();
    private static User myuser;
    private static Scheduler instance;
    private ArrayList<Task> observers = new ArrayList<>();

    public Scheduler(){
        System.out.println("RUNNING SCHEDULER");
        this.instance = this;
        this.status = 0;
    }

    private static DBManager getDBManager(){
        return dbManager;
    }

    public static void updateProjects(JSONArray projects){
        dbManager.updateProject(myuser, projects);

    }

    public static JSONArray getProjectFromUser(){
        return dbManager.getProject(myuser);

    }

    public static void createUser(String username, String password){
        myuser = dbManager.createUser(username, password);
    }

    public static int loadUser(String username, String password) {


        User user = dbManager.checkLogin(username, password);
        if (user != null) {
                myuser = user;
                myuser.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(instance);
                Scheduler.load();
                return 0;
        }
        return 1;
    }

    public static void setProjectBuilderScheduler(Scheduler scheduler){
        myuser.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(scheduler);
    }

    public static void createProject(String name, String description, int Hduration, LocalDateTime deadline) {
        myuser.getCalendar().addProject(
                name,
                description,
                new ArrayList<String>(),
                Duration.ofHours(Hduration),
                deadline);
    }


    public static ArrayList<Project> getProjects(){
        return myuser.getCalendar().getProjects();
    }

    /**
     * This method is run every minute
     */
    public void run(){
        this.notifyObserver();
    }

    public void registerObserver(Task task){
        this.observers.add(task);
    }

    public void unregisterObserver(Task task){
        this.observers.remove(task);
    }

    public void notifyObserver(){
        for(Task task : this.observers){
            //notify only the none finished task
            if(task.getStatus() != 2 && task.getStatus() != 3){
                int prev_status = task.getStatus();
                int new_status = task.update(LocalDateTime.now());
                if(prev_status == 0 && new_status == 1){
                    System.out.println("A new task is starting now.");
                }
            }
        }
    }

    /**
     * Executed when a task is updated
     * @param task
     */
    public void taskUpdate(Task task) {

    }

    public void stop(){
        this.status = 0;
    }

    public void start(){
        this.status = 1;
    }

    public static void save(){
        JSONArray projectList = new JSONArray();
        for(Project project : Scheduler.myuser.getCalendar().getProjects()){
            JSONObject jsonProject = project.toJSON();
            projectList.add(jsonProject);
        }
        Scheduler.getDBManager().updateProject(myuser, projectList);
        System.out.println("Project saved!");

    }

    public static void load(){
        JSONArray prjJSON = Scheduler.getDBManager().getProject(myuser);
        Iterator i = prjJSON.iterator();

        while (i.hasNext()) {
            JSONObject prj = (JSONObject) i.next();
            Project project = myuser.getCalendar().getProjectBuilder().loadProjectJSON(prj.toJSONString());
            myuser.getCalendar().addProject(project);
        }
    }

    public static User getMyuser() {
        return myuser;
    }

    public static void main(String[] args) {


        JSONParser parser = new JSONParser();


        try (Reader reader = new FileReader("database.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




        //main scheduler declaration
        //use methods to change the values inside this

        // Main scheduler declaration

        Scheduler scheduler = new Scheduler();
        Timer timer = new Timer();
        timer.schedule(scheduler, 0,60000);

        // Create test user
        //scheduler.loadUser("Hasaan", "123");
        //scheduler.myuser.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(scheduler);
        //scheduler.load();


        // Create test project
        //scheduler.createProject("Project1", "Finish the scheduler code", 4, LocalDateTime.of(2019, Month.MAY, 28, 00, 00, 00));
        //scheduler.createProject("Project2", "Remember to test everything", 2, LocalDateTime.of(2019, Month.MAY, 29, 00, 00, 00));
        //System.out.println(jsonTask);

        //scheduler.save();


        //scheduler.myuser.getCalendar().getProjectBuilder().loadProjectJSON(jsonTask);

        // Starts the GUI
        // Launches the Login frame

        new FrameLogin("");
        //new FrameMain();
    }
}
