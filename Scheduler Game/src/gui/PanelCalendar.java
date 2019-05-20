package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class PanelCalendar extends JPanel implements ActionListener {

    private PanelDashboard dashboardCalendar;
    private CustomButton[] btnArray = new CustomButton[12];
    private PanelProject[] projectArray = new PanelProject[10];
    private int projectCount;

    public PanelCalendar() {

        // @TODO - Replace 3 with a getProjectsCount()
        projectCount = 3; //PLACEHOLDER

        // @TODO - Delete lines below
        String[] projects = new String[10]; //PLACEHOLDER
        projects[0] = "Project 1"; //PLACEHOLDER
        projects[1] = "Project 2"; //PLACEHOLDER
        projects[2] = "Project 3"; //PLACEHOLDER

        // Create the main panels that will have the main content
        dashboardCalendar = new PanelDashboard("src/images/logo-calendar.png", 12);
        for(int i=0; i<10; i++) {
            projectArray[i] = new PanelProject(i);
        }

        // Create the dashboard button for each of the main panels
        for(int i=0; i<projectCount; i++) {
            btnArray[i] = dashboardCalendar.newDashButton(projects[i]);
            btnArray[i].addActionListener(this);
        }

        // Create all the other empty buttons
        for(int i=projectCount; i<10; i++) {
            btnArray[i] = dashboardCalendar.newDashButton("");
        }

        // Add last button
        btnArray[10] = dashboardCalendar.newDashButton("Add New Project");
        btnArray[10].addActionListener(this);
        btnArray[11] = dashboardCalendar.newDashButton("");

        // Set dashboard style
        Color dashboardBg = Color.decode("#262A34");
        dashboardCalendar.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());
        this.add(dashboardCalendar, BorderLayout.WEST);
        this.add(projectArray[0], BorderLayout.EAST);

        // Set panel dimensions
        Dimension dim = new Dimension();
        dim.width = 600;
        this.setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        // Reset panels
        for(int i=0; i<10; i++) {
            this.remove(projectArray[i]);
        }

        // Display only the correct panel
        for(int i=0; i<10; i++) {
            if (clicked == btnArray[i]) {
                this.add(projectArray[i], BorderLayout.EAST);
                break;
            }
        }

        if (clicked == btnArray[10]) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new FrameProject("Add Project");
                }
            });
        }

        this.revalidate();
        this.repaint();
    }
}
