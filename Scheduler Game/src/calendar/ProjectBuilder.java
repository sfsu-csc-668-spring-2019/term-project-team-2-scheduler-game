package calendar;

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

    /**
     * Given a initialized Project, return the associated list of task
     * @param project
     * @return
     */
    public void buildWorkSessions(Project project) {
        this.taskScheduler.scheduleProject(project);
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
