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
    private StatsManager statsManager;
    private Notifier notifier;
    private UIManager uiManager;

    public Scheduler(){
        this.status = 0;

        this.statsManager = new StatsManager();
        this.notifier = new Notifier();
        this.uiManager = new UIManager();
        this.user = this.loadUser();
        this.user.getCalendar().getProjectBuilder().getTaskScheduler().setScheduler(this);
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

        Scheduler s = new Scheduler();

        Project project = s.user.getCalendar().getProjectBuilder().build("Project1",
                                                                        "description of the project",
                                                                        new ArrayList<String>(),
                                                                        Duration.ofHours(2),
                                                                        LocalDateTime.of(2019, Month.MAY, 10, 00, 00, 00));
        s.user.getCalendar().getProjectBuilder().buildWorkSessions(project);

    }

}
