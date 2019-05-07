package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCity extends JPanel implements ActionListener {

    private JLabel panelTitle;

    public PanelCity() {
        panelTitle = new JLabel("City");
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
