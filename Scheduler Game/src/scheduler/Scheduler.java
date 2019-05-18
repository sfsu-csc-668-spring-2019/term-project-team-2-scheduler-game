package scheduler;

import org.json.simple.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.FileWriter;
import  org.json.simple.parser.*;

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

    private User user = new User();
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;
    private ArrayList<Task> observers = new ArrayList<>();



    public Scheduler(){

        System.out.println("RUNNING SCHEDULER");

        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();


    }


    private void createUser(String username, String password){
        this.user.createUser(username, password);

    }

    private int loadUser(String username, String password){

        if(this.user.checkLogin(username, password) == 0){
            return 0;
        }
        else {
            return 1;
        }
        //return new User(username, password);

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



        //System.exit(1);




        String username = "user1";
        String password = "qwerty";

        Scheduler scheduler = new Scheduler();

        int check = scheduler.loadUser("Hasaan","123");

        System.out.println(check);

        //scheduler.createUser("bobby","asd");


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~REMOVE THE STATEMENT BELOW THIS IF YOU WANT THE ENTIRE PROGRAM TO RUN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.exit(1);

        Timer t1 = new Timer();
        t1.schedule(scheduler, 0,60000);


        System.out.println("Schedueler is running...");

        new FrameLogin("");


        System.out.println("Schedueler is running...");

        Project project = scheduler.user.getCalendar().getProjectBuilder().build("Project1",
                                                                        "description of the project",
                                                                        new ArrayList<String>(),
                                                                        Duration.ofHours(2),

                                                                        LocalDateTime.of(2019, Month.MAY, 10, 00, 00, 00));
        scheduler.user.getCalendar().getProjectBuilder().buildWorkSessions(project);

        
        //Left as result of merge conflict. If causing problems please delete
        LocalDateTime.of(2019, Month.MAY, 25, 00, 00, 00);
        scheduler.user.getCalendar().getProjectBuilder().buildWorkSessions(project);
        project.getTasks().get(0).setStatus(1);

        FrameMain mf = new FrameMain();
        NotificationFrame nf = new NotificationFrame(project.getTasks().get(0));

    }



}
