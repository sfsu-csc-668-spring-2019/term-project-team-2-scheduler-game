package calendar;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ProjectBuilder {

    public ProjectBuilder() {

    }

    public Project build(String name, String description, ArrayList<String> tags, Duration duration, Date deadline) {
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName(name);
        project.setDescription(description);
        project.setTags(tags);
        project.setDuration(duration);
        project.setDeadline(deadline);

        return project;
    }
}
