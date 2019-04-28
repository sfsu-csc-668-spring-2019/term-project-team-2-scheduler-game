package calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        this.projects.add(project);
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
