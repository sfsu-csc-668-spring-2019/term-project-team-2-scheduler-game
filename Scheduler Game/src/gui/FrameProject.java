package gui;

import calendar.ProjectBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.Month;
import scheduler.Scheduler;

public class FrameProject extends JFrame implements ActionListener, TemplateFrame {

    private JPanel frameContainer, formPanel, buttonsPanel;
    private CustomButton btnDone, btnCancel;
    private JLabel lbName, lbDescription, lbTags, lbDurantion, lbDeadline, lbMessage, lbTitle;
    private JTextField txtName, txtDescription, txtTags, txtDuration, day, month, year;
    private String name, description, tags, duration, sDay, sMonth, sYear;

    private String message;
    private Color color;
    private Dimension dim;

    public FrameProject(String message) {

        // Stores parameter
        this.message = message;

        // Implements methods from TemplateComponent interface
        setHelpers();
        setForm();
        setButtons();
        addChildren();
        setFrame();
    }

    @Override
    public void setHelpers() {
        dim = new Dimension();
        color = Color.decode("#262a33");
    }

    @Override
    public void setForm() {

        // Form (Step 1) - Create and populate the panel
        JPanel p = new JPanel(new SpringLayout());
        p.setBackground(color);

        lbTitle = new JLabel(message, SwingConstants.CENTER);
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

        lbDeadline = new JLabel("Deadline (M/D/Y): ", JLabel.TRAILING);
        lbDeadline.setForeground(Color.WHITE);
        p.add(lbDeadline);

        day = new JTextField(4);
        month = new JTextField(4);
        year = new JTextField(4);
        JPanel datePanel = new JPanel(new GridLayout(1, 3));
        datePanel.setBackground(color);
        datePanel.add(month);
        datePanel.add(day);
        datePanel.add(year);
        p.add(datePanel);

        // Form (Step 2)  - Lay out the panel
        CustomForm.makeCompactGrid(p, 5 , 2, 60, 0, 5, 10);

        // Form (Step 3)  - Add final components
        formPanel = new JPanel(new BorderLayout());
        formPanel.setBackground(color);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 42));
        formPanel.add(p);
    }

    @Override
    public void setButtons() {
        buttonsPanel = new JPanel(new GridLayout(3,1));
        buttonsPanel.setBackground(color);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        dim.height = 130;
        buttonsPanel.setPreferredSize(dim);

        if(message == "Add Project") addProject();
        else editProject();

        btnDone.addActionListener(this);
        btnDone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color));

        btnCancel = new CustomButton("CANCEL", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnCancel.addActionListener(this);
        btnCancel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, color));

        lbMessage = new JLabel("", SwingConstants.CENTER);
        lbMessage.setForeground(Color.WHITE);

        buttonsPanel.add(btnDone);
        buttonsPanel.add(btnCancel);
        buttonsPanel.add(lbMessage);
    }

    @Override
    public void setFrame() {
        this.setLayout(new BorderLayout());
        this.add(frameContainer, BorderLayout.CENTER);

        this.setSize(400, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void addChildren() {
        frameContainer = new JPanel(new BorderLayout());
        frameContainer.setBackground(color);
        frameContainer.add(lbTitle, BorderLayout.NORTH);
        frameContainer.add(formPanel, BorderLayout.CENTER);
        frameContainer.add(buttonsPanel, BorderLayout.SOUTH);
        frameContainer.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
    }

    private void addProject(){
        this.setTitle("Add Project");
        btnDone = new CustomButton("ADD PROJECT", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
    }

    private void editProject(){
        this.setTitle("Edit Project");
        btnDone = new CustomButton("EDIT PROJECT", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        name = txtName.getText();
        description = txtDescription.getText();
        tags = txtTags.getText();
        duration = txtDuration.getText();
        sDay = day.getText();
        sMonth = month.getText();
        sYear = year.getText();

        if (clicked == btnDone) {
            if (!name.isEmpty() && !duration.isEmpty() & !sDay.isEmpty() & !sMonth.isEmpty() & !sYear.isEmpty()) {
                Scheduler.createProject(
                        name,
                        description,
                        Integer.parseInt(duration),
                        LocalDateTime.of(Integer.parseInt(sYear), Month.of(Integer.parseInt(sMonth)), Integer.parseInt(sDay), 00, 00, 00));
                this.dispose();
            } else {
                lbMessage.setText("Name, Duration and Deadline are required!");
            }
        }
        else if (clicked == btnCancel) {
            this.dispose();
        }
    }
}