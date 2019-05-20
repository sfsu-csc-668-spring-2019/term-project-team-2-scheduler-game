package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTask extends JPanel implements ActionListener, ComponentProject {

    private JLabel lbName, lbDescription, lbTags, lbDurantion, lbDeadline;
    private JPanel buttonsPanel;
    private CustomButton btnEdit, btnCancel;
    private int taskID;

    private Font font;
    private Dimension dim;
    private Color color;

    public PanelTask(int taskID) {

        // Stores task ID
        this.taskID = taskID;

        // Implements methods from ComponentProject interface
        this.setHelpersDetails();
        this.setLabelsAndContent();
        this.setContainerPanel();
        this.addChildComponents();
    }

    @Override
    public void setHelpersDetails() {
        this.font = new Font("Gill Sans MT",Font.BOLD,15);
        this.dim = new Dimension();
        this.color = Color.decode("#262a33");
    }

    @Override
    public void setLabelsAndContent() {
        // @TODO - Replace with getters
        lbName = new JLabel("task name" + (taskID+1));
        lbDescription = new JLabel("description" + (taskID+1));
        lbTags = new JLabel("tags" + (taskID+1));
        lbDurantion = new JLabel("duration" + (taskID+1));
        lbDeadline = new JLabel("deadline" + (taskID+1));
    }

    @Override
    public void setContainerPanel() {
        this.dim.width = 300;
        this.setPreferredSize(this.dim);
        this.setLayout(new GridLayout(6, 1));
    }

    @Override
    public void addChildComponents() {

        // Buttons
        buttonsPanel = new JPanel(new GridLayout(1,2));
        buttonsPanel.setBackground(color);
        dim.height = 150;
        dim.width = 150;
        buttonsPanel.setPreferredSize(dim);
        buttonsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 50, Color.decode("#EEEEEE")));

        btnEdit = new CustomButton("Edit", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        btnEdit.addActionListener(this);
        btnEdit.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.decode("#EEEEEE")));

        btnCancel = new CustomButton("Cancel", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnCancel.addActionListener(this);
        btnCancel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#EEEEEE")));

        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnCancel);

        // Task details
        lbName.setFont(this.font);
        this.add(lbName);
        this.add(lbDescription);
        this.add(lbTags);
        this.add(lbDurantion);
        this.add(lbDeadline);
        this.add(buttonsPanel);
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
