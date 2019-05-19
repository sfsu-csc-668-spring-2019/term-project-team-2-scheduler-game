package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProject extends JPanel implements ActionListener {

    private JLabel panelTitle;
    private int taskCount;
    private PanelTask[] taskArray = new PanelTask[6];
    private JPanel tasksContainer;

    public PanelProject(int projectID) {

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());

        // @TODO - Replace 6 with a getTaskCount() - 6 TASKS MAXIMUM
        taskCount = 6; //PLACEHOLDER

        // Get all tasks from project
        tasksContainer = new JPanel(new GridLayout(3, 2));
        for(int i=0; i<taskCount; i++) {
            taskArray[i] = new PanelTask(i);
            taskArray[i].setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
            tasksContainer.add(taskArray[i]);
        }

        // Panel settings
        Font projectTitle = new Font("Gill Sans MT",Font.BOLD,18);
        panelTitle = new JLabel("Project " + (projectID+1), SwingConstants.CENTER);
        panelTitle.setFont(projectTitle);
        panelTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        this.add(panelTitle, BorderLayout.NORTH);
        this.add(tasksContainer, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        Dimension dim = new Dimension();
        dim.width = 600;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
