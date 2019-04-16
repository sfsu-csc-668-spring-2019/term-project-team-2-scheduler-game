package calendar;

import java.util.ArrayList;
import java.util.Date;


public class Calendar {

    private ArrayList<Project> projects;
    private Synchronizer synchronizer;
    private ProjectBuilder projectBuilder;

    public Calendar(){
        this.synchronizer = new Synchronizer();
        this.projectBuilder = new ProjectBuilder();

        this.projects = new ArrayList<Project>();
    }

    public void addProject(int id, String name, String description, ArrayList<String> tags, float duration, Date deadline){
        Project project = this.projectBuilder.build(id, name, description, tags, duration, deadline);
        this.projects.add(project);
    }
}
