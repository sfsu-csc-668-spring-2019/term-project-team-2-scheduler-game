package scheduler;

import org.json.simple.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;
    private static User myuser;
    private ArrayList<Task> observers = new ArrayList<>();

    public Scheduler(){
        System.out.println("RUNNING SCHEDULER");
        this.status = 0;
        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();
    }

    public static void createUser(String username, String password){
        User user = new User();
        user.createUser(username, password);
        myuser = user;
    }

    public static int loadUser(String username, String password){
        User user = new User();
        if(user.checkLogin(username, password) == 0){
            myuser = user;
            return 0;
        }
        else {
            return 1;
        }
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

        // Main scheduler declaration
        Scheduler scheduler = new Scheduler();
        Timer timer = new Timer();
        timer.schedule(scheduler, 0,60000);

        // Create test user
        scheduler.loadUser("Hasaan", "123");
        scheduler.myuser.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(scheduler);

        // Create test project
        scheduler.createProject("Project1", "Finish the scheduler code", 4, LocalDateTime.of(2019, Month.MAY, 28, 00, 00, 00));
        scheduler.createProject("Project2", "Remember to test everything", 2, LocalDateTime.of(2019, Month.MAY, 20, 00, 00, 00));
        String jsonTask = scheduler.myuser.getCalendar().getProjects().get(0).toJSON();
        System.out.println(jsonTask);

        scheduler.myuser.getCalendar().getProjectBuilder().loadProjectJSON(jsonTask);

        // Starts the GUI
        // Launches the Login frame
        //new FrameLogin("");
        new FrameMain();
    }
}
