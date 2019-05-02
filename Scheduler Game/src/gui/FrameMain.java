package gui;

import javax.swing.*;
import java.awt.*;

// This class is the gui controller

public class FrameMain extends JFrame {

    private PanelBody textArea;
    private PanelDashboard dashboard;

    public FrameMain() {
        super("Scheduler Game");
        this.setLayout(new BorderLayout());

        dashboard = new PanelDashboard();
        textArea = new PanelBody();

        Color dashboardBg = Color.decode("#262a33");
        dashboard.setBackground(dashboardBg);

        dashboard.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textArea.appendText(text);
            }
        });

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
}