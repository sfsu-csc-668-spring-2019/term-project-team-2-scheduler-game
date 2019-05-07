package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHome extends JPanel implements ActionListener {

    private JLabel panelTitle;

    public PanelHome() {
        panelTitle = new JLabel("Home");
        setLayout(new BorderLayout());
        add(panelTitle, BorderLayout.CENTER);

        Dimension dim = new Dimension();
        dim.width = 700;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
