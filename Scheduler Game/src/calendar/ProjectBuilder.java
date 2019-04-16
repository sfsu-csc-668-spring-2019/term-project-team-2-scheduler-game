package calendar;

import java.util.ArrayList;
import java.util.Date;

public class ProjectBuilder {

    public Project build(int id, String name, String description, ArrayList<String> tags, float duration, Date deadline){
        Project project = new Project(id, name, description, tags, duration, deadline);
        // use AIEngine to create the session list
        return project;
    }
}
