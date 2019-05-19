package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class PanelCalendar extends JPanel implements ActionListener {

    private PanelDashboard dashboardCalendar;
    private JLabel panelTitle;
    private String newProject;

    private int projectCount;
    private String[] projects = new String[12];;
    private JPanel[] panelArray = new JPanel[12];
    private CustomButton[] btnArray = new CustomButton[12];

    public PanelCalendar() {

        // Get count of projects
        projectCount = 3;
        projects[0] = "Project 1";
        projects[1] = "Project 2";
        projects[2] = "Project 3";

        // Create the main panels that will have the main content
        dashboardCalendar = new PanelDashboard("src/images/logo-calendar.png", 12);
        for(int i=0; i<projectCount; i++) {
            panelArray[i] = new JPanel();
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
        this.add(panelArray[0], BorderLayout.EAST);

        // Set panel header text
        panelTitle = new JLabel("Calendar");
        this.add(panelTitle, BorderLayout.CENTER);

        // Set panel dimensions
        Dimension dim = new Dimension();
        dim.width = 600;
        this.setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        for(int i=0; i<projectCount; i++) {
            if (clicked == btnArray[i]) {
                this.panelTitle.setText("Project " + (i+1));
                break;
            }
        }

        if (clicked == btnArray[11]) {
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
