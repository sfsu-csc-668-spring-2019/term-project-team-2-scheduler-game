package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTask extends JPanel implements ActionListener {

    private JLabel lbName, lbDescription, lbTags, lbDurantion, lbDeadline;
    private JPanel buttonsPanel;
    private CustomButton btnEdit, btnCancel;

    public PanelTask(int taskID) {

        // Add initial components to FrameMain
        this.setLayout(new GridLayout(6, 1));

        // Get Task info
        // @TODO - Replace with getters
        lbName = new JLabel("task name" + (taskID+1));
        lbDescription = new JLabel("description" + (taskID+1));
        lbTags = new JLabel("tags" + (taskID+1));
        lbDurantion = new JLabel("duration" + (taskID+1));
        lbDeadline = new JLabel("deadline" + (taskID+1));

        Font taskLabel = new Font("Gill Sans MT",Font.BOLD,15);
        lbName.setFont(taskLabel);

        this.add(lbName);
        this.add(lbDescription);
        this.add(lbTags);
        this.add(lbDurantion);
        this.add(lbDeadline);

        // Helpers
        Dimension dim = new Dimension();
        Color bgColor = Color.decode("#262a33");

        // Buttons
        buttonsPanel = new JPanel(new GridLayout(1,2));
        buttonsPanel.setBackground(bgColor);
        dim.height = 150;
        dim.width = 150;
        buttonsPanel.setPreferredSize(dim);
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 50, Color.decode("#EEEEEE")));
        this.add(buttonsPanel);

        btnEdit = new CustomButton("Edit", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        btnEdit.addActionListener(this);
        btnEdit.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#EEEEEE")));

        btnCancel = new CustomButton("Cancel", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnCancel.addActionListener(this);
        btnCancel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#EEEEEE")));

        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnCancel);

        // Set panel dimensions
        dim.width = 300;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == btnEdit) {

        }
        else if (clicked == btnCancel) {

        }
    }
}
