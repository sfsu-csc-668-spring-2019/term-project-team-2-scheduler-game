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

    public boolean hasUser(){
        if(this.user == null){
            System.out.println("No user Exists");
            return false;
        }
        System.out.println("User Exists");
        return true;
    }

    //check user against db or whatevers on the
    public boolean checkUserInDB(String username){
        return true;
    }


    public Scheduler(String username, String password){
        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();
        

        boolean userExists = checkUserInDB(username);


        if(userExists){

            User tempUser = loadUser(username, password);
            while(tempUser == null){
                //TODO: have a way to give another password
                String newPassword = "";
                System.out.println("Password was incorrect. Try Again.");
                tempUser = loadUser(username, newPassword);
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


    // check if a user exist, if not, propose to create one
    //private User loadUser(String username, String password){

    //TODO: Need this to be able to send back a null user if password is wrong
    private User loadUser(String username, String password){

        if(true) {
            User tempUser = new User(username, password);
            tempUser.checkLogin(username, password)
            return tempUser;
        }
        else {
            return null;
        }


    }

    private void newUser(String username, String password){

        while(true){
            this.user = new User(username, password);
            //TODO: validate new created user before making new account
            break;
        }
        //return new User("user1", "qwerty");

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


    public static boolean userCheckInScheduler(Scheduler scheduler){
        boolean userExists = scheduler.hasUser();
        if(!userExists){
            System.out.println("User DNE. Create new user?");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println("Hello World!");

        String username = "user1";
        String password = "qwerty";

        Scheduler scheduler = new Scheduler(username, password);

        boolean userExists = userCheckInScheduler(scheduler);

        while(true) {
            if (!userExists) {
                scheduler.newUser(username, password);
            }

        }
        //scheduler.run();



        //TODO: Check if this is still fine after new changes to scheduler/user files
        /*System.out.println("Schedueler is running...");

        new Login();

        Scheduler s = new Scheduler();

        Project project = s.user.getCalendar().getProjectBuilder().build("Project1",
                                                                        "description of the project",
                                                                        new ArrayList<String>(),
                                                                        Duration.ofHours(2),
                                                                        LocalDateTime.of(2019, Month.MAY, 10, 00, 00, 00));
        s.user.getCalendar().getProjectBuilder().buildWorkSessions(project);
        */
    }

}
