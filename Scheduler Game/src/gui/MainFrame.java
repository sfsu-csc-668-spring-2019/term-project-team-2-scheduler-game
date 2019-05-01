package gui;

import javax.swing.*;
import java.awt.*;

// This class is the gui controller

public class MainFrame extends JFrame {

    private BodyPanel textArea;
    private DashboardPanel dashboard;

    public MainFrame() {
        super("Scheduler Game");
        this.setLayout(new BorderLayout());

        dashboard = new DashboardPanel();
        textArea = new BodyPanel();

        Color dashboardBg = Color.decode("#262a33");
        dashboard.setBackground(dashboardBg);

        dashboard.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textArea.appendText(text);
            }
        });

        // Add components to MainFrame
        add(dashboard, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);

        // Finish settings for MainFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(900, 600));
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}