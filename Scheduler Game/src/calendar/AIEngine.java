package calendar;

import scheduler.Scheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class AIEngine {

    private Calendar calendar;
    private Scheduler scheduler;

    public AIEngine(Calendar calendar) {
        this.calendar = calendar;
        this.scheduler = scheduler;
    }

    public void scheduleProject(Project project) {
        Duration totalDuration = project.getDuration();
        int nbTask = (int)totalDuration.toHours();
        Duration taskDuration = totalDuration.dividedBy(nbTask);
        System.out.println(taskDuration.toMinutes());

        ArrayList<Task> tasks = new ArrayList<>();
        for(int i=0; i<nbTask; i++){
            // TODO: 28/04/19 function to choose the beginTask
            LocalDateTime beginTask = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
            tasks.add(new Task(beginTask, taskDuration));
            System.out.println(tasks.get(i).toString());
        }
        project.setTasks(tasks);
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
