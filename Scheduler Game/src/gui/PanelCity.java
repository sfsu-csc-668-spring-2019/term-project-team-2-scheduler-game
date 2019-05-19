package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCity extends JPanel implements ActionListener {

    private PanelDashboard dashboardCity;
    private CustomButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    private JPanel p1, p2, p3, p4;
    private JLabel panelTitle;

    public PanelCity() {

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("src/images/logo-city.png", 4);
        p1 = new JPanel();
        p2 = new JPanel();
        p4 = new JPanel();

        // Create the dashboard button for each of the main panels
        btn1 = dashboardCity.newDashButton("One");
        btn2 = dashboardCity.newDashButton("Two");
        btn3 = dashboardCity.newDashButton("Three");
        btn4 = dashboardCity.newDashButton("");
        btn5 = dashboardCity.newDashButton("");
        btn6 = dashboardCity.newDashButton("");
        btn7 = dashboardCity.newDashButton("");
        btn8 = dashboardCity.newDashButton("");
        btn9 = dashboardCity.newDashButton("");
        btn10 = dashboardCity.newDashButton("");
        btn11 = dashboardCity.newDashButton("");
        btn12 = dashboardCity.newDashButton("");

        // Add action listeners to all buttons
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        // Set dashboard style
        Color dashboardBg = Color.decode("#262A34");
        dashboardCity.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());
        this.add(dashboardCity, BorderLayout.WEST);
        this.add(p1, BorderLayout.EAST);

        // Set panel header text
        panelTitle = new JLabel("City");
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
            this.panelTitle.setText("City - ONE");
        }
        else if (clicked == btn2) {
            this.panelTitle.setText("City - TWO");
        }
        else if (clicked == btn3) {
            this.panelTitle.setText("City - THREE");
        }

        this.revalidate();
        this.repaint();
    }
}
