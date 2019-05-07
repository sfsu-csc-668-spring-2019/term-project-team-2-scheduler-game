package gui;

import javax.swing.*;
import java.awt.*;

public class PanelBody extends JPanel {

    private JTextArea textArea;

    public PanelBody() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(textArea, BorderLayout.CENTER);

        Dimension dim = new Dimension();
        dim.width = 700;
        setPreferredSize(dim);
    }
}
