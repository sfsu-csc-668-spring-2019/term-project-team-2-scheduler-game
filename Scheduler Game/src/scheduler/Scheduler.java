package scheduler;

import calendar.Project;
import calendar.Task;
import gui.FrameMain;
import gui.NotificationFrame;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

public class Scheduler extends TimerTask {

    private int status;

    private User user;
    private String username;
    private String password;
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;
    private ArrayList<Task> observers = new ArrayList<>();


    //check user against db or whatevers on the
    public boolean checkUser(String userame){
        return true;
    }


    public Scheduler(String username, String password){
        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();

        

        boolean userExists = checkUser(username);

        if(userExists){
            this.user = this.loadUser(username, password);
        }

      //TODO: Check if this portion of code is still necessary


        //this.user = this.loadUser();
        //this.user.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(this);




        //boolean userExists = checkUserInDB(username);


        if(userExists){

            User tempUser = this.loadUser(username, password);
            while(tempUser == null){
                //TODO: have a way to give another password
                String newPassword = "";
                System.out.println("Password was incorrect. Try Again.");
                tempUser = this.loadUser(username, newPassword);
            }
        }
        else{
            System.out.println("User does not exist upon scheduler startup.");
            this.user = null;
        }


      //TODO: Check if this portion of code is still necessary. :should be okay to keep calendar call -Hasaan:
        //this.user = this.loadUser();
        //this.user.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(this);

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

    public boolean hasUser(){
        if(this.user == null){
            return false;
        }
        return true;
    }

    //check user against db or whatevers on the
    public boolean checkUserInDB(String username){
        return true;
    }

    // check if a user exist, if not, propose to create one
    //private User loadUser(String username, String password){

    //TODO: Need this to be able to send back a null user if password is wrong
    private User loadUser(String username, String password){

        /*
        //NEED A DB TO REFERENCE FOR THIS ONE
        if (username.equals("temp")){
            //return user;
            User tempUser = new User(username, password);
            boolean loginVal = tempUser.checkLogin(username, password);

            if(loginVal){
                return tempUser;
            }

        }
        else{
            System.out.println("No user " + username + " found. Create new user?");
            return null;
        }*/

        return new User("user1", "qwerty");
        //return new User(username, password);

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


    public static void userCheckInScheduler(Scheduler scheduler){
        boolean userExists = scheduler.hasUser();
        if(!userExists){
            System.out.println("User DNE. Create new user?");
        }
    }


    public static void main(String[] args) {

        System.out.println("Hello World!");

        String username = "user1";
        String password = "qwerty";

        Scheduler scheduler = new Scheduler(username, password);

        userCheckInScheduler(scheduler);

        Timer t1 = new Timer();
        t1.schedule(scheduler, 0,60000);




        System.out.println("Schedueler is running...");

        //new Login();


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

    public void setUsername(String username){
        this.username = username;

    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUser(User user){
        this.user = user;
    }


}
