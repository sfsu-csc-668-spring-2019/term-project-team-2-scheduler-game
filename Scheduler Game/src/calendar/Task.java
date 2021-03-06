package calendar;

import gui.NotificationFrame;
import org.json.simple.JSONObject;
import scheduler.Scheduler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

public class Task {

    private String id;
    private Duration duration;
    private LocalDateTime begin;
    private LocalDateTime end;
    private int status;         //0:todoo, 1:in-progress, 2:Done, 3:Not-finish
    private String projectName; // TODO: 12/05/19
    private String description;
    private HashMap<String, Boolean> todoList;
    private float productivity;

    public Task(String projectName, LocalDateTime begin, Duration duration) {
        this.id = UUID.randomUUID().toString();
        this.projectName = projectName;
        this.begin = begin;
        this.duration = duration;
        this.end = this.begin.plusMinutes(this.duration.toMinutes());
        this.status = 0;
        this.productivity = (float) 0.0;
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public void addTodoList(HashMap<String, Boolean> todoList) {
        this.todoList = todoList;
    }

    public int update(LocalDateTime currentTime){
        if(this.status == 0){
            if(this.compareLocalDateTime(this.begin, currentTime)){
                NotificationFrame nf = new NotificationFrame(this);
            }
        }
        if(this.status == 1){
            if(this.compareLocalDateTime(this.end, currentTime)){
                NotificationFrame nf = new NotificationFrame(this);
            }
        }
        return this.status;
    }

    private Boolean compareLocalDateTime(LocalDateTime ldt1, LocalDateTime ldt2) {
        if(ldt1.getYear() == ldt2.getYear()) {
            if(ldt1.getMonth() == ldt2.getMonth()) {
                if(ldt1.getDayOfMonth() == ldt2.getDayOfMonth()){
                    if(ldt1.getHour() == ldt2.getHour()) {
                        if(ldt1.getMinute() == ldt2.getMinute()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, Boolean> getTodoList() {
        return todoList;
    }

    public float getProductivity() {
        return productivity;
    }

    public void setProductivity(float productivity) {
        this.productivity = productivity;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setId(String id) { this.id = id; }

    public void setEnd(LocalDateTime end) { this.end = end; }

    public void setDescription(String description) { this.description = description; }

    public void setTodoList(HashMap<String, Boolean> todoList) { this.todoList = todoList; }

    public String toString(){
        String str = "";
        str += "id: " + this.id + "\n";
        str += "Begin: " + this.begin + "\tEnd: " + this.end +  "\tDuration: " + this.duration + "\n";
        str += "Status: " + this.status ;
        return str;
    }

    public JSONObject toJSON(){
        /*String str = "{";
        str += '"'+ this.id+"\":{";
            str += "\"ProjectName\": "+ this.projectName + ",";
            str += "\"Status\": "+ this.status + ",";
            str += "\"Duration\": "+ this.duration.toHours() + ",";
            str += "\"Description\": "+ this.description + ",";
            str += "\"Productivity\": "+ this.productivity + ",";
            str += "\"BeginTime\": "+ this.begin + ",";
            str += "\"EndTime\": "+ this.end ;
        str += "}";

        //System.out.println(str+"}");
        return str+"}";*/
        JSONObject taskDetails = new JSONObject();
        taskDetails.put("Id", this.id);
        taskDetails.put("ProjectName", this.projectName);
        taskDetails.put("Status", Integer.toString(this.status));
        taskDetails.put("Duration", Long.toString(this.duration.toHours()));
        taskDetails.put("Description", this.description);
        taskDetails.put("Productivity", Float.toString(this.productivity));
        taskDetails.put("BeginTime", this.begin.toString());
        taskDetails.put("EndTime", this.end.toString());

        return taskDetails;
    }
}
