package calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {

    private String id;
    private String name;
    private String description;
    private ArrayList<String> tags = new ArrayList<>();
    private Duration duration;
    private LocalDateTime deadline;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Project(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public JSONObject toJSON(){
        /*String str = "{";
        str += '"'+ this.id+"\":{";
            str += "\"Name\": "+ this.name + ",";
            str += "\"Description\": "+ this.description + ",";
            str += "\"Duration\": "+ this.duration.toHours() + ",";
            str += "\"Deadline\": "+ this.deadline + ",";
            str += "\"Tasks\": {";
                for(int i=0; i<this.getTasks().size(); i++){
                    str += this.getTasks().get(i).toJSON();
                    if(i < this.getTasks().size()-1){str += ",";}
                }
            str += "}";
        str += "}";*/

        //System.out.println(str+"}");
        JSONObject projectDetails = new JSONObject();
        projectDetails.put("Id", (String)this.id);
        projectDetails.put("Name", this.name);
        projectDetails.put("Description", this.description);
        projectDetails.put("Duration", Long.toString(duration.toHours()));
        projectDetails.put("Deadline", this.deadline.toString());

        JSONArray taskList = new JSONArray();
        for(int i=0; i<this.getTasks().size(); i++){
            taskList.add(this.getTasks().get(i).toJSON());
        }
        projectDetails.put("Tasks", taskList);

        return projectDetails;
    }
}
