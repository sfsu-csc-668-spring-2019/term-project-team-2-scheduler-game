package calendar;

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
    private String description;
    private HashMap<String, Boolean> todoList;
    private float productivity;
    private float satisfaction;

    private Scheduler observer;

    public Task(LocalDateTime begin, Duration duration) {
        this.id = UUID.randomUUID().toString();
        this.begin = begin;
        this.duration = duration;
        this.end = this.begin.plusMinutes(this.duration.toMinutes());
        this.status = 0;
        this.productivity = (float) 0.0;
        this.satisfaction = (float) 0.0;
    }

    public void addDescription(String description) {
        this.description = description;
    }

    public void addTodoList(HashMap<String, Boolean> todoList) {
        this.todoList = todoList;
    }

    public void attach(Scheduler scheduler) {
        this.observer = scheduler;
    }

    public void notifyObserver() {
        this.observer.taskUpdate(this);
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

    public String getDescription() {
        return description;
    }

    public HashMap<String, Boolean> getTodoList() {
        return todoList;
    }

    public float getProductivity() {
        return productivity;
    }

    public float getSatisfaction() {
        return satisfaction;
    }

    public Scheduler getObserver() {
        return observer;
    }


    public String toString(){
        String str = "";
        str += "id: " + this.id + "\n";
        str += "Begin: " + this.begin + "\tEnd: " + this.end +  "\tDuration: " + this.duration + "\n";
        str += "Status: " + this.status ;
        return str;
    }
}
