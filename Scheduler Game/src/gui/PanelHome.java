package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHome extends JPanel implements ActionListener {

    private JLabel panelTitle;

    public PanelHome() {

        // Add initial components to FrameMain
        this.setLayout(new GridLayout(20, 1));

        // Set panel header text
        panelTitle = new JLabel("Home");
        this.add(panelTitle, BorderLayout.CENTER);

        this.add(new JLabel("Team:"));
        this.add(new JLabel("Hasaan Javed"));
        this.add(new JLabel("Matthieu Vilain"));
        this.add(new JLabel("Paul Uhlenkott"));
        this.add(new JLabel("Vinicius Miazaki"));

        // Set panel dimensions
        Dimension dim = new Dimension();
        dim.width = 600;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
