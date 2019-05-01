package scheduler;

import calendar.Project;
import calendar.Task;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

public class Scheduler {

    private int status;

    private User user;
    private String username;
    private String password;
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Scheduler(String username, String password){
        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();
        
      
      //TODO: Check if this portion of code is still necessary
        this.user = this.loadUser(username, password);

        this.user = this.loadUser();
        this.user.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(this);

    }


    // check if a user exist, if not, propose to create one
    //private User loadUser(String username, String password){
    private User loadUser(String username, String password){

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
        }

        //return new User("user1", "qwerty");
        //return new User(username, password);

    }



    public void run(){
        this.status = 1;
        while(this.status == 1){
            System.out.println("It's run!");
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

        System.out.println("Hello World!");

        String username = "user1";
        String password = "qwerty";

        Scheduler scheduler = new Scheduler(username, password);

        /*
        User checkUser = scheduler.loadUser(username, password);
        if(checkUser == null){
            //have some method to create new user
            System.out.println("Create new user here.");

            //scheduler.setUser();
        }
        */
        scheduler.run();

        System.out.println("Schedueler is running...");
        new Login();

        Scheduler s = new Scheduler();

        Project project = s.user.getCalendar().getProjectBuilder().build("Project1",
                                                                        "description of the project",
                                                                        new ArrayList<String>(),
                                                                        Duration.ofHours(2),
                                                                        LocalDateTime.of(2019, Month.MAY, 10, 00, 00, 00));
        s.user.getCalendar().getProjectBuilder().buildWorkSessions(project);
    }

}
