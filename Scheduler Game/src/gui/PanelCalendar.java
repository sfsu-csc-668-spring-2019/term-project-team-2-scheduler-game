package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCalendar extends JPanel implements ActionListener {

    private PanelDashboard dashboardCalendar;
    private CustomButton btn1, btn2, btn3, btn4;
    private JPanel p1, p2, p3, p4;
    private JLabel panelTitle;

    public PanelCalendar() {

        // Create the main panels that will have the main content
        dashboardCalendar = new PanelDashboard("images/logo-calendar.png", 4);
        p1 = new JPanel();
        p2 = new JPanel();
        p4 = new JPanel();

        // Create the dashboard button for each of the main panels
        btn1 = dashboardCalendar.newDashButton("One");
        btn2 = dashboardCalendar.newDashButton("Two");
        btn3 = dashboardCalendar.newDashButton("Three");
        btn4 = dashboardCalendar.newDashButton("Four");

        // Add action listeners to all buttons
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);

        // Set dashboard style
        Color dashboardBg = Color.decode("#262A34");
        dashboardCalendar.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());
        this.add(dashboardCalendar, BorderLayout.WEST);
        this.add(p1, BorderLayout.EAST);

        // Set panel header text
        panelTitle = new JLabel("Calendar");
        add(panelTitle, BorderLayout.CENTER);

        // Set panel dimensions
        Dimension dim = new Dimension();
        dim.width = 700;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == btn1) {
            this.panelTitle.setText("Calendar - ONE");
        }
        else if (clicked == btn2) {
            this.panelTitle.setText("Calendar - TWO");
        }
        else if (clicked == btn3) {
            this.panelTitle.setText("Calendar - THREE");
        }
        else if (clicked == btn4) {
            this.panelTitle.setText("Calendar - FOUR");
        }

        this.revalidate();
        this.repaint();
    }
}
