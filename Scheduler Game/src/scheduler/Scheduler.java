package scheduler;

import javax.swing.*;

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
        this.user = this.loadUser(username, password);
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


    }

}
