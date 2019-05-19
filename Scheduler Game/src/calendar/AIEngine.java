package calendar;

import scheduler.Scheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;

public class AIEngine {

    private Calendar calendar;
    private Scheduler scheduler;
    private Random randomGenerator = new Random();

    public AIEngine(Calendar calendar) {
        this.calendar = calendar;
        this.scheduler = scheduler;
    }

    public void scheduleProject(Project project) {
        Duration totalDuration = project.getDuration();
        int nbTask = (int)totalDuration.toHours();
        Duration taskDuration = totalDuration.dividedBy(nbTask);
        System.out.println(taskDuration.toMinutes());

        ArrayList<LocalDateTime> sessions = this.scheduleTask(LocalDateTime.now(), project.getDeadline(), nbTask);

        ArrayList<Task> tasks = new ArrayList<>();
        for(int i=0; i<nbTask; i++){
            LocalDateTime beginTask = sessions.get(i);
            Task task = new Task(project.getName(), beginTask, taskDuration);
            System.out.println(this.scheduler);
            this.scheduler.registerObserver(task);
            tasks.add(task);
            System.out.println(task.toString());
        }
        project.setTasks(tasks);
    }

    private ArrayList<LocalDateTime> scheduleTask(LocalDateTime begin, LocalDateTime deadline, int nbTask) {
        LocalDateTime current = begin;
        ArrayList<LocalDateTime> possibleDays = new ArrayList<>();
        while(!this.compareLocalDateTime(current, deadline)) {
            possibleDays.add(current);
            current = current.plusDays(1);
            System.out.println(current);
        }

        ArrayList<LocalDateTime> selectedSchedule = new ArrayList<>();
        int firstIndex = possibleDays.size()/nbTask/2;
        int spaceBetweenDays = possibleDays.size()/nbTask;
        for(int i=0; i<nbTask; i++) {
            int idx = firstIndex + i*spaceBetweenDays;
            ArrayList<Integer> freeHours = this.calendar.dayFreeHours(possibleDays.get(idx));
            if(!freeHours.isEmpty()){
                int selectedHour = this.randomGenerator.nextInt(freeHours.size()-1);
                selectedSchedule.add(possibleDays.get(idx).withHour(selectedHour).withMinute(0).withSecond(0));
            }
            else {
                possibleDays.set(idx, possibleDays.get(idx).minusDays(1));
                i--;
            }
        }
        return selectedSchedule;
    }

    private Boolean compareLocalDateTime(LocalDateTime ldt1, LocalDateTime ldt2) {
        if(ldt1.getYear() == ldt2.getYear()) {
            if(ldt1.getMonth() == ldt2.getMonth()) {
                if(ldt1.getDayOfMonth() == ldt2.getDayOfMonth()){
                    return true;
                }
            }
        }
        return false;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
}
