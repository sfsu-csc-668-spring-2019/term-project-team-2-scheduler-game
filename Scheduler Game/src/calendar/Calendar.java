package calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Calendar {

    private ProjectBuilder projectBuilder;
    private ArrayList<Project> projects;

    public Calendar() {
        this.projectBuilder = new ProjectBuilder(this);
        this.projects = new ArrayList<Project>();
    }

    public void addProject(String name, String description, ArrayList<String> tags, Duration duration, LocalDateTime deadline){
        this.projectBuilder.setContext(this.projects);
        Project project = this.projectBuilder.build(name, description, tags, duration, deadline);
        this.projectBuilder.buildWorkSessions(project);
        this.projects.add(project);
    }

    public Boolean isFree(LocalDateTime time) {
        for(Project project : this.projects) {
            for(Task task : project.getTasks()) {
                //System.out.println(task.getBegin());
                Duration duration = Duration.between(task.getBegin(), time);
                if(Math.abs(duration.toMinutes()) < 59) {
                    return false;
                }
            }
        }
        return true;
    }

    private int deltaLocalDateTime(LocalDateTime t1, LocalDateTime t2) {
        //System.out.println("T1: "+t1);
        //System.out.println("T2: "+t2);
        LocalDateTime tempDateTime = LocalDateTime.from(t1);

        long years = tempDateTime.until(t2, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears( years );

        long months = tempDateTime.until(t2, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths( months );

        long days = tempDateTime.until(t2, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( days );


        long hours = tempDateTime.until(t2, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( hours );

        long minutes = tempDateTime.until(t2, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes( minutes );

        long seconds = tempDateTime.until(t2, ChronoUnit.SECONDS);

        //System.out.println(tempDateTime);
        return tempDateTime.getMinute();

    }

    public ArrayList<Integer> dayFreeHours(LocalDateTime day) {
        ArrayList<Integer> freeHours = new ArrayList<>();
        for(int i=6; i<24; i++) {
            if(this.isFree(day.withHour(i).withMinute(0).withSecond(0))) {
                freeHours.add(i);
            }
        }
        return freeHours;
    }

    public ProjectBuilder getProjectBuilder() {
        return projectBuilder;
    }

    public void setProjectBuilder(ProjectBuilder projectBuilder) {
        this.projectBuilder = projectBuilder;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
