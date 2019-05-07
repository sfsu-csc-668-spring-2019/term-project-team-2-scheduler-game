package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class is the gui controller

public class FrameMain extends JFrame implements ActionListener {

    private PanelBody pbHome, pbCalendar, pbCity;
    private PanelDashboard dashboard;
    private CustomButton btnHome, btnCalendar, btnCity, btnLogout;

    public FrameMain() {
        super("Scheduler Game");
        this.setLayout(new BorderLayout());

        // Create the main panels that will have the main content
        dashboard = new PanelDashboard();
        pbHome = new PanelBody();
        pbCalendar = new PanelBody();
        pbCity = new PanelBody();

        // Create the dashboard button for each of the main panels
        btnHome = dashboard.newDashButton("Home");
        btnCalendar = dashboard.newDashButton("Calendar");
        btnCity = dashboard.newDashButton("City");
        btnLogout = dashboard.newDashButton("Logout");

        // Add action listeners to all buttons
        btnHome.addActionListener(this);
        btnCalendar.addActionListener(this);
        btnCity.addActionListener(this);
        btnLogout.addActionListener(this);

        // Set dashboard style
        Color dashboardBg = Color.decode("#262a33");
        dashboard.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.add(dashboard, BorderLayout.WEST);
        this.add(pbHome, BorderLayout.EAST);

        // Finish settings for FrameMain
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(900, 600));
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == btnHome) {
            
        }
        else if (clicked == btnCalendar) {

        }
        else if (clicked == btnCity) {

        }
        else if (clicked == btnLogout) {
            this.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new FrameLogin("Logged out successfully!");
                }
            });
        }
    }
}