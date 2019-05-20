package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class is the gui controller

public class FrameMain extends JFrame implements ActionListener {

    private PanelDashboard dashboardIcons;
    private String iconHome, iconCalendar, iconCity, iconLogout;
    private CustomButton btnHome, btnCalendar, btnCity, btnLogout;
    private PanelHome pHome;
    private PanelCalendar pCalendar;
    private PanelCity pCity;

    public FrameMain() {
        super("Scheduler Game");
        this.setLayout(new BorderLayout());

        // Create the main panels that will have the main content
        dashboardIcons = new PanelDashboard();
        pHome          = new PanelHome();
        pCalendar      = new PanelCalendar();
        pCity          = new PanelCity();

        // Set dashboard style
        Color dashboardBg = Color.decode("#5D00A2");
        dashboardIcons.setBackground(dashboardBg);

        // Set paths for all icons
        iconHome     = "Scheduler Game/src/images/icon-home.png";
        iconCalendar = "Scheduler Game/src/images/icon-calendar.png";
        iconCity     = "Scheduler Game/src/images/icon-city.png";
        iconLogout   = "Scheduler Game/src/images/icon-logout.png";

        // Create the dashboard button for each of the main panels
        Color btnHover = Color.decode("#262A34");
        btnHome     = dashboardIcons.newDashButton("Home\n", iconHome, dashboardBg, btnHover);
        btnCalendar = dashboardIcons.newDashButton("Calendar", iconCalendar, dashboardBg, btnHover);
        btnCity     = dashboardIcons.newDashButton("City", iconCity, dashboardBg, btnHover);
        btnLogout   = dashboardIcons.newDashButton("Logout", iconLogout, dashboardBg, btnHover);

        // Add action listeners to all buttons
        btnHome.addActionListener(this);
        btnCalendar.addActionListener(this);
        btnCity.addActionListener(this);
        btnLogout.addActionListener(this);

        // Add initial components to FrameMain
        this.add(dashboardIcons, BorderLayout.WEST);
        this.add(pHome, BorderLayout.CENTER);

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

        // Reset panels
        this.remove(pHome);
        this.remove(pCalendar);
        this.remove(pCity);

        // Activate element from button clicked
        JButton clicked = (JButton)e.getSource();
        if (clicked == btnHome) {
            this.add(pHome);
        }
        else if (clicked == btnCalendar) {
            this.add(pCalendar);
        }
        else if (clicked == btnCity) {
            this.add(pCity);
        }
        else if (clicked == btnLogout) {
            this.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new FrameLogin("Logged out successfully!");
                }
            });
        }

        // Repaint the menu
        this.revalidate();
        this.repaint();
        pack();
    }
}