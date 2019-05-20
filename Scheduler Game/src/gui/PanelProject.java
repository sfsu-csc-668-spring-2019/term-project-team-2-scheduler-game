package gui;

import calendar.Project;
import calendar.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelProject extends JPanel implements ActionListener, TemplateComponent {

    private JLabel panelTitle;
    private int taskCount;
    private PanelTask[] taskArray = new PanelTask[6];
    private JPanel tasksContainer;

    private Project project;
    private ArrayList<Task> tasks;

    private Font font;
    private Dimension dim;

    public PanelProject(Project project) {

        // Stores project
        this.project = project;
        this.tasks = project.getTasks();

        // Implements methods from TemplateComponent interface
        this.setHelpers();
        this.setContent();
        this.setContainer();
        this.addChild();
    }

    @Override
    public void setHelpers() {
        this.font = new Font("Gill Sans MT",Font.BOLD,18);
        this.dim = new Dimension();
    }

    @Override
    public void setContent() {

        // Panel with project title
        panelTitle = new JLabel(project.getName(), SwingConstants.CENTER);
        panelTitle.setFont(this.font);
        panelTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Get tasks count from project
        taskCount = project.getTasks().size();

        // Get all tasks from project
        tasksContainer = new JPanel(new GridLayout(3, 2));
        for(int i=0; i<taskCount; i++) {
            taskArray[i] = new PanelTask(tasks.get(i));
            taskArray[i].setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            tasksContainer.add(taskArray[i]);
        }
    }

    @Override
    public void setContainer() {
        this.dim.width = 600;
        this.setPreferredSize(this.dim);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addChild() {
        this.add(panelTitle, BorderLayout.NORTH);
        this.add(tasksContainer, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
