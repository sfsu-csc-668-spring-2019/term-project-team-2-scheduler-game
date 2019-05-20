package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProject extends JPanel implements ActionListener, ComponentProject {

    private JLabel panelTitle;
    private int taskCount;
    private PanelTask[] taskArray = new PanelTask[6];
    private JPanel tasksContainer;
    private int projectID;

    private Font font;
    private Dimension dim;

    public PanelProject(int projectID) {

        // Stores project ID
        this.projectID = projectID;

        // Implements methods from ComponentProject interface
        this.setHelpersDetails();
        this.setLabelsAndContent();
        this.setContainerPanel();
        this.addChildComponents();
    }

    @Override
    public void setHelpersDetails() {
        this.font = new Font("Gill Sans MT",Font.BOLD,18);
        this.dim = new Dimension();
    }

    @Override
    public void setLabelsAndContent() {

        // Panel with project title
        panelTitle = new JLabel("Project " + (projectID+1), SwingConstants.CENTER);
        panelTitle.setFont(this.font);
        panelTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // @TODO - Get tasks count from project
        taskCount = 6;

        // Get all tasks from project
        tasksContainer = new JPanel(new GridLayout(3, 2));
        for(int i=0; i<taskCount; i++) {
            taskArray[i] = new PanelTask(i);
            taskArray[i].setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            tasksContainer.add(taskArray[i]);
        }
    }

    @Override
    public void setContainerPanel() {
        this.dim.width = 600;
        this.setPreferredSize(this.dim);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addChildComponents() {
        this.add(panelTitle, BorderLayout.NORTH);
        this.add(tasksContainer, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
