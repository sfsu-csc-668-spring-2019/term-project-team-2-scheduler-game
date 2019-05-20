package calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class ProjectBuilder {

    private AIEngine taskScheduler;
    private ArrayList<Project> context;

    public ProjectBuilder(Calendar calendar) {
        this.taskScheduler = new AIEngine(calendar);
    }

    /**
     * Build a project given basic information
     * @param name
     * @param description
     * @param tags
     * @param duration
     * @param deadline
     * @return Project with a empty list of task
     */
    public Project build(String name, String description, ArrayList<String> tags, Duration duration, LocalDateTime deadline) {
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName(name);
        project.setDescription(description);
        project.setTags(tags);
        project.setDuration(duration);
        project.setDeadline(deadline);

        return project;
    }

    public Project loadProjectJSON(String jsonProject){
        //jsonProject = "{\"25df4fda-d728-4877-a99c-ba12d351a94a\":{\"Name\": Project1,\"Description\": Finish the scheduler before monday !,\"Duration\": 4,\"Deadline\": 2019-05-28T00:00,\"Tasks\": {{\"0ee17128-cf76-4473-81e5-d71eedd95984\":{\"ProjectName\": Project1,\"Status\": 0,\"Duration\": 1,\"Description\": null,\"Productivity\": 0.0,\"BeginTime\": 2019-05-20T02:00:00.760,\"EndTime\": 2019-05-20T03:00:00.760}},{\"6155df9e-59af-49a5-8cfd-8e4b9e39d0d1\":{\"ProjectName\": Project1,\"Status\": 0,\"Duration\": 1,\"Description\": null,\"Productivity\": 0.0,\"BeginTime\": 2019-05-22T03:00:00.760,\"EndTime\": 2019-05-22T04:00:00.760}},{\"c09fe327-1fd1-48ed-b5ac-00318119e679\":{\"ProjectName\": Project1,\"Status\": 0,\"Duration\": 1,\"Description\": null,\"Productivity\": 0.0,\"BeginTime\": 2019-05-24T12:00:00.760,\"EndTime\": 2019-05-24T13:00:00.760}},{\"b27c9b1b-a9ba-4022-ab79-e9a669ab34ed\":{\"ProjectName\": Project1,\"Status\": 0,\"Duration\": 1,\"Description\": null,\"Productivity\": 0.0,\"BeginTime\": 2019-05-26T01:00:00.760,\"EndTime\": 2019-05-26T02:00:00.760}}}}}";
        Project project = new Project();
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(jsonProject);

            project.setId((String)jsonObject.get("Id"));
            project.setName((String)jsonObject.get("Name"));
            project.setDescription((String)jsonObject.get("Description"));
            project.setDuration(Duration.ofHours(Long.parseLong((String)jsonObject.get("Duration"))));
            project.setDeadline(LocalDateTime.parse((String)jsonObject.get("Deadline")));

            System.out.println(project.getId());
            System.out.println(project.getName());
            System.out.println(project.getDescription());
            System.out.println(project.getDuration());
            System.out.println(project.getDeadline());

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("Tasks");
            Iterator<JSONObject> iterator = msg.iterator();
            while (iterator.hasNext()) {
                Task task = this.loadTaskJSON(iterator.next());
                System.out.println(task);
                project.getTasks().add(task);
                //System.out.println(iterator.next());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return project;
    }

    private Task loadTaskJSON(JSONObject taskJSON){

        /*taskDetails.put("Id", this.id);
        taskDetails.put("ProjectName", this.projectName);
        taskDetails.put("Status", Integer.toString(this.status));
        taskDetails.put("Duration", Long.toString(this.duration.toHours()));
        taskDetails.put("Description", this.description);
        taskDetails.put("Productivity", Float.toString(this.productivity));
        taskDetails.put("BeginTime", this.begin.toString());
        taskDetails.put("EndTime", this.end.toString());*/

        String projectName = (String)taskJSON.get("ProjectName");
        LocalDateTime begin = LocalDateTime.parse((String)taskJSON.get("BeginTime"));
        Duration duration = Duration.ofHours(Long.parseLong((String)taskJSON.get("Duration")));
        Task task = new Task(projectName, begin, duration);
        task.setId((String)taskJSON.get("Id"));
        task.setStatus(Integer.parseInt((String)taskJSON.get("Status")));
        task.setDescription((String)taskJSON.get("Description"));
        task.setProductivity(Float.parseFloat((String)taskJSON.get("Productivity")));

        return task;
    }

    /**
     * Given a initialized Project, return the associated list of task
     * @param project
     * @return
     */
    public void buildWorkSessions(Project project) {
        this.taskScheduler.scheduleProject(project);
        //System.out.println("project well schedule");
    }

    public ArrayList<Project> getContext() {
        return context;
    }

    public void setContext(ArrayList<Project> context) {
        this.context = context;
    }

    public AIEngine getTaskScheduler() {
        return taskScheduler;
    }
}
