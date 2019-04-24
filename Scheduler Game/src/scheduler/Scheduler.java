package scheduler;

import javax.swing.*;

public class Scheduler {

    private int status;

    private User user;
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;

    public Scheduler(){
        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();
        this.user = this.loadUser();
    }

    private User loadUser(){
        // check if a user exist, if not, propose to create one
        return new User("user1", "qwerty");
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

    }

}
