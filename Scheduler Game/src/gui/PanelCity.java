package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCity extends JPanel implements ActionListener {

    private PanelDashboard dashboardCity;
    private JLabel panelTitle;
    private JPanel[] panelArray = new JPanel[12];
    private CustomButton[] btnArray = new CustomButton[12];

    public PanelCity() {

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("src/images/logo-city.png", 4);

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("src/images/logo-city.png", 12);
        for(int i=0; i<12; i++) {
            panelArray[i] = new JPanel();
        }

        // Create the dashboard button for each of the main panels
        btnArray[0] = dashboardCity.newDashButton("One");
        btnArray[1] = dashboardCity.newDashButton("Two");
        btnArray[2] = dashboardCity.newDashButton("Three");
        btnArray[0].addActionListener(this);
        btnArray[1].addActionListener(this);
        btnArray[2].addActionListener(this);

        // Create all the other empty buttons
        for(int i=3; i<12; i++) {
            btnArray[i] = dashboardCity.newDashButton("");
        }

        // Set dashboard style
        Color dashboardBg = Color.decode("#262A34");
        dashboardCity.setBackground(dashboardBg);

        // Add initial components to FrameMain
        this.setLayout(new BorderLayout());
        this.add(dashboardCity, BorderLayout.WEST);
        this.add(panelArray[0], BorderLayout.EAST);

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

        for(int i=0; i<12; i++) {
            if (clicked == btnArray[i]) {
                this.panelTitle.setText("City " + (i+1));
                break;
            }
        }

        this.revalidate();
        this.repaint();
    }
}
