package gui;

import javax.swing.*;
import java.awt.*;

public class BodyPanel extends JPanel {

    private JTextArea textArea;

    public BodyPanel() {
        textArea = new JTextArea();
        setLayout(new BorderLayout());
        add(textArea, BorderLayout.CENTER);

        Dimension dim = new Dimension();
        dim.width = 700;
        setPreferredSize(dim);
    }

    public void appendText(String text) {
        textArea.append(text);
    }
}
