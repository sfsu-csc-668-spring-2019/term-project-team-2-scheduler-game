package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class is the gui controller

public class FrameMain extends JFrame implements ActionListener {

    private PanelBody textArea;
    private PanelDashboard dashboard;
    private CustomButton btnHome, btnCalendar, btnCity, btnLogout;

    public FrameMain() {
        super("Scheduler Game");
        this.setLayout(new BorderLayout());

        dashboard = new PanelDashboard();
        textArea = new PanelBody();

        btnHome = dashboard.newDashButton("Home");
        btnCalendar = dashboard.newDashButton("Calendar");
        btnCity = dashboard.newDashButton("City");
        btnLogout = dashboard.newDashButton("Logout");

        btnHome.addActionListener(this);
        btnCalendar.addActionListener(this);
        btnCity.addActionListener(this);
        btnLogout.addActionListener(this);

        Color dashboardBg = Color.decode("#262a33");
        dashboard.setBackground(dashboardBg);

        // Add components to FrameMain
        this.add(dashboard, BorderLayout.WEST);
        this.add(textArea, BorderLayout.EAST);

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
                    new FrameLogin();
                }
            });
        }
    }
}