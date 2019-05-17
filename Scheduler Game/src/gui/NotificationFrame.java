package gui;

import calendar.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationFrame extends JFrame implements ActionListener {

    private Task task;
    private JPanel notificationPanel, namePanel, detailPanel, beginPanel, endPanel;
    private JSlider slider;
    private CustomButton beginButton, endButton, rescheduleButton, notFinishedButton;

    public NotificationFrame(Task task) {
        this.task = task;

        // Helpers
        Dimension dim = new Dimension();
        Color bgColor = Color.decode("#262a33");


        // Name part
        this.namePanel = new JPanel();
        this.namePanel.setBackground(bgColor);
        JLabel pName = new JLabel(this.task.getProjectName(), JLabel.TRAILING);
        pName.setForeground(Color.WHITE);
        pName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        this.namePanel.add(pName);

        // Detail part
        this.detailPanel = new JPanel(new GridLayout(4, 1));
        this.detailPanel.setBackground(bgColor);
        //this.detailPanel.setLayout(new BoxLayout(this.detailPanel, BoxLayout.LINE_AXIS));
        JLabel descript = new JLabel("Description:");
        descript.setForeground(Color.WHITE);
        JLabel description = new JLabel(this.task.getDescription());
        description.setForeground(Color.WHITE);
        JLabel deadline = new JLabel("Deadline: "+this.task.getEnd());
        deadline.setForeground(Color.WHITE);
        JLabel duration = new JLabel("Duration: "+this.task.getDuration());
        duration.setForeground(Color.WHITE);
        this.detailPanel.add(descript);
        this.detailPanel.add(description);
        this.detailPanel.add(deadline);
        this.detailPanel.add(duration);

        // begin part
        this.beginPanel = new JPanel();
        this.beginPanel.setBackground(bgColor);
        this.beginPanel.setLayout(new GridLayout(2, 1));
        this.beginButton = new CustomButton("Work on this task!");
        this.beginButton.setActionCommand("Start");
        this.rescheduleButton = new CustomButton("Reschedule");
        this.rescheduleButton.setActionCommand("Reschedule");
        this.rescheduleButton.addActionListener(this);
        this.beginPanel.add(this.beginButton);
        this.beginPanel.add(this.rescheduleButton);
        this.beginButton.addActionListener(this);

        // end part
        this.endPanel = new JPanel();
        this.endPanel.setBackground(bgColor);
        this.endPanel.setLayout(new GridLayout(4, 1));
        JLabel productLabel = new JLabel("Your productivity:", SwingConstants.CENTER);
        productLabel.setForeground(Color.WHITE);
        this.endPanel.add(productLabel);
        this.slider = new JSlider(0, 100, 50);
        this.slider.setBackground(bgColor);
        this.slider.setForeground(Color.WHITE);
        this.endPanel.add(slider);
        this.endButton = new CustomButton("Work done!");
        this.endButton.setActionCommand("Done");
        this.endButton.addActionListener(this);
        this.notFinishedButton = new CustomButton("Not finished...");
        this.notFinishedButton.setActionCommand("NotFinished");
        this.notFinishedButton.addActionListener(this);
        this.endPanel.add(this.endButton);
        this.endPanel.add(this.notFinishedButton);



        this.notificationPanel = new JPanel(new GridLayout(4, 1));
        this.notificationPanel.add(this.namePanel, BorderLayout.NORTH);
        this.notificationPanel.add(this.detailPanel, BorderLayout.CENTER);
        // TODO: 12/05/19 change for design pattern
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(bgColor);
        this.notificationPanel.add(emptyPanel);
        if(this.task.getStatus() == 0){
            this.notificationPanel.add(this.beginPanel, BorderLayout.SOUTH);
        }
        else if(this.task.getStatus() == 1){
            this.notificationPanel.add(this.endPanel, BorderLayout.SOUTH);
        }



        this.pack();
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(this.notificationPanel, BorderLayout.CENTER);
        this.setTitle("You have a new task todo!");
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void CloseFrame(){
        super.dispose();
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if (action.equals("Start")) {
            this.task.setStatus(1);
            this.CloseFrame();
        }
        else if(action.equals("Reschedule")){
            System.out.println("Reschedule");
            // TODO: 12/05/19 Little form
        }
        else if(action.equals("Done")){
            this.task.setStatus(2);
            this.task.setProductivity(this.slider.getValue());
            this.CloseFrame();
        }
        else if(action.equals("NotFinished")){
            this.task.setStatus(3);
            this.task.setProductivity(this.slider.getValue());
            this.CloseFrame();
        }
    }
}
