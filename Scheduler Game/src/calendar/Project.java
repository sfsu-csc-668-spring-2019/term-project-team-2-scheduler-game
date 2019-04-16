package calendar;

import java.util.ArrayList;
import java.util.Date;

public class Project {

    private int id;
    private String name;
    private String description;
    private ArrayList<String> tags;
    private float duration;
    private Date deadline;


    public Project(int id, String name, String description, ArrayList<String> tags, float duration, Date deadline){
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.duration = duration;
        this.deadline = deadline;
    }
}
