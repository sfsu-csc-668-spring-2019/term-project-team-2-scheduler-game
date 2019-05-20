package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCity extends JPanel implements ActionListener, ComponentTemplate {

    private PanelDashboard dashboardCity;
    private JLabel panelTitle;
    private JPanel[] panelArray = new JPanel[12];
    private CustomButton[] btnArray = new CustomButton[12];
    private Color color;
    private Dimension dim;

    public PanelCity() {

        // Implements methods from ComponentTemplate interface
        setHelpers();
        setContent();
        setContainer();
        addChild();
    }

    @Override
    public void setHelpers() {
        this.dim = new Dimension();
        this.color = Color.decode("#262A34");
    }

    @Override
    public void setContent() {

        // Set panel header text
        panelTitle = new JLabel("City");

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("Scheduler Game/src/images/logo-city.png", 4);

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("Scheduler Game/src/images/logo-city.png", 12);
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

        dashboardCity.setBackground(color);
    }

    @Override
    public void setContainer() {
        dim.width = 600;
        this.setPreferredSize(dim);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addChild() {
        this.add(dashboardCity, BorderLayout.WEST);
        this.add(panelArray[0], BorderLayout.EAST);
        this.add(panelTitle, BorderLayout.CENTER);
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
