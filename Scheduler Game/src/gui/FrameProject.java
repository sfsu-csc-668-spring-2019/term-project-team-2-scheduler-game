package gui;

import calendar.ProjectBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameProject extends JFrame implements ActionListener {

    private JPanel frameContainer, formPanel, buttonsPanel;
    private CustomButton btnDone, btnCalcel;

    private JLabel lbName, lbDescription, lbTags, lbDurantion, lbDeadline, lbMessage, lbTitle;
    private JTextField txtName, txtDescription, txtTags, txtDuration, txtDeadline;
    private String name, description, tags, duration, deadline;

    public FrameProject(String s) {

        // Helpers
        Dimension dim = new Dimension();
        Color bgColor = Color.decode("#262a33");

        // Form (Step 1) - Create and populate the panel
        JPanel p = new JPanel(new SpringLayout());
        p.setBackground(bgColor);

        lbTitle = new JLabel(s, SwingConstants.CENTER);
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Gill Sans MT",Font.BOLD,20));

        lbName = new JLabel("Project: ", JLabel.TRAILING);
        lbName.setForeground(Color.WHITE);
        p.add(lbName);
        txtName = new JTextField(100);
        lbName.setLabelFor(txtName);
        p.add(txtName);

        lbDescription = new JLabel("Description: ", JLabel.TRAILING);
        lbDescription.setForeground(Color.WHITE);
        p.add(lbDescription);
        txtDescription = new JTextField(100);
        lbDescription.setLabelFor(txtDescription);
        p.add(txtDescription);

        lbTags = new JLabel("Tags: ", JLabel.TRAILING);
        lbTags.setForeground(Color.WHITE);
        p.add(lbTags);
        txtTags = new JTextField(100);
        lbTags.setLabelFor(txtTags);
        p.add(txtTags);

        lbDurantion = new JLabel("Duration: ", JLabel.TRAILING);
        lbDurantion.setForeground(Color.WHITE);
        p.add(lbDurantion);
        txtDuration = new JTextField(100);
        lbDurantion.setLabelFor(txtDuration);
        p.add(txtDuration);

        lbDeadline = new JLabel("Deadline: ", JLabel.TRAILING);
        lbDeadline.setForeground(Color.WHITE);
        p.add(lbDeadline);
        txtDeadline = new JTextField(100);
        lbDeadline.setLabelFor(txtDeadline);
        p.add(txtDeadline);

        // Form (Step 2)  - Lay out the panel
        CustomForm.makeCompactGrid(p, 5 , 2, 60, 0, 5, 10);

        // Form (Step 3)  - Add final components
        formPanel = new JPanel(new BorderLayout());
        formPanel.setBackground(bgColor);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 42));
        formPanel.add(p);

        // Buttons
        buttonsPanel = new JPanel(new GridLayout(3,1));
        buttonsPanel.setBackground(bgColor);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        dim.height = 130;
        buttonsPanel.setPreferredSize(dim);

        if(s == "Add Project") btnDone = new CustomButton("ADD PROJECT", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        else btnDone = new CustomButton("EDIT PROJECT", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        btnDone.addActionListener(this);
        btnDone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bgColor));

        btnCalcel = new CustomButton("CANCEL", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnCalcel.addActionListener(this);
        btnCalcel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, bgColor));

        lbMessage = new JLabel("", SwingConstants.CENTER);
        lbMessage.setForeground(Color.WHITE);

        buttonsPanel.add(btnDone);
        buttonsPanel.add(btnCalcel);
        buttonsPanel.add(lbMessage);

        // frameContainer settings
        frameContainer = new JPanel(new BorderLayout());
        frameContainer.setBackground(bgColor);
        frameContainer.add(lbTitle, BorderLayout.NORTH);
        frameContainer.add(formPanel, BorderLayout.CENTER);
        frameContainer.add(buttonsPanel, BorderLayout.SOUTH);
        frameContainer.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));

        // JFrame
        this.setLayout(new BorderLayout());
        this.add(frameContainer, BorderLayout.CENTER);
        this.setTitle("Scheduler Login");
        this.setSize(400, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        name = txtName.getText();
        description = txtDescription.getText();
        tags = txtTags.getText();
        duration = txtDuration.getText();
        deadline = txtDeadline.getText();

        if (clicked == btnDone) {
            if (!name.isEmpty() && !duration.isEmpty() & !!deadline.isEmpty()) {
                this.dispose();

                //TODO - Call the method to create the project here. Something like:
                //new ProjectBuilder(name, description, tags, duration, deadline);

            } else {
                lbMessage.setText("Name, Duration and Deadline are required!");
            }
        }
        else if (clicked == btnCalcel) {
            this.dispose();
        }
    }
}