package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCalendar extends JPanel implements ActionListener {

    private PanelDashboard dashboardCalendar;
    private CustomButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btnAdd;
    private JPanel p1, p2, p3, p4, p5, p6, p7, p8;
    private JLabel panelTitle;
    private String newProject;

    public PanelCalendar() {

        // Create the main panels that will have the main content
        dashboardCalendar = new PanelDashboard("images/logo-calendar.png", 12);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        p8 = new JPanel();

        // Create the dashboard button for each of the main panels
        btn1 = dashboardCalendar.newDashButton("Project 1");
        btn2 = dashboardCalendar.newDashButton("Project 2");
        btn3 = dashboardCalendar.newDashButton("Project 3");
        btn4 = dashboardCalendar.newDashButton("");
        btn5 = dashboardCalendar.newDashButton("");
        btn6 = dashboardCalendar.newDashButton("");
        btn7 = dashboardCalendar.newDashButton("");
        btn8 = dashboardCalendar.newDashButton("");
        btn9 = dashboardCalendar.newDashButton("");
        btn10 = dashboardCalendar.newDashButton("");
        btn11 = dashboardCalendar.newDashButton("");
        btnAdd = dashboardCalendar.newDashButton("Add New Project");

        // Add action listeners to all buttons
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btnAdd.addActionListener(this);
        /*btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);*/

        // Set dashboard style
        Color dashboardBg = Color.decode("#262A34");
        dashboardCalendar.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());
        this.add(dashboardCalendar, BorderLayout.WEST);
        this.add(p1, BorderLayout.EAST);

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

        if (clicked == btn1) {
            this.panelTitle.setText("Project 1");
        }
        else if (clicked == btn2) {
            this.panelTitle.setText("Project 2");
        }
        else if (clicked == btn3) {
            this.panelTitle.setText("Project 3");
        }
        else if (clicked == btn4) {
            this.panelTitle.setText("Project 4");
        }
        else if (clicked == btn5) {
            this.panelTitle.setText("Project 5");
        }
        else if (clicked == btn6) {
            this.panelTitle.setText("Project 6");
        }
        else if (clicked == btn7) {
            this.panelTitle.setText("Project 7");
        }
        else if (clicked == btn8) {
            this.panelTitle.setText("Project 8");
        }
        else if (clicked == btn9) {
            this.panelTitle.setText("Project 9");
        }
        else if (clicked == btn10) {
            this.panelTitle.setText("Project 10");
        }
        else if (clicked == btn11) {
            this.panelTitle.setText("Project 11");
        }
        else if (clicked == btnAdd) {
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
