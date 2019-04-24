package calendar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

public class Calendar {

    private ProjectBuilder projectBuilder;
    private ArrayList<Project> projects;

    public Calendar() {
        this.projectBuilder = new ProjectBuilder();
        this.projects = new ArrayList<Project>();
    }

    public void addProject(String name, String description, ArrayList<String> tags, Duration duration, Date deadline){
        Project project = this.projectBuilder.build(name, description, tags, duration, deadline);
        this.projects.add(project);
    }
}
