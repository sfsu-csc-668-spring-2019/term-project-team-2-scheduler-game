package gui;

import calendar.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PanelTask extends JPanel implements ActionListener, ComponentProject {

    private JLabel lbName, lbDate, lbBegin, lbEnd, lbStatus;
    private JPanel buttonsPanel;
    private CustomButton btnEdit, btnCancel;
    private int taskID;

    private Task task;

    private Font font;
    private Dimension dim;
    private Color color;

    public PanelTask(Task task) {

        // Stores task
        this.task = task;

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

        // Task title
        lbName = new JLabel("TASK");
        Date aux;
        SimpleDateFormat formatter;

        // Date
        aux = Date.from( task.getBegin().atZone( ZoneId.systemDefault()).toInstant());
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date = formatter.format(aux);
        lbDate = new JLabel("Date: " + date);

        // Begin
        aux = Date.from( task.getBegin().atZone( ZoneId.systemDefault()).toInstant());
        formatter = new SimpleDateFormat("hh:mm");
        String begin = formatter.format(aux);
        lbBegin = new JLabel("Begin: " + begin);

        // End
        aux = Date.from( task.getEnd().atZone( ZoneId.systemDefault()).toInstant());
        formatter = new SimpleDateFormat("hh:mm");
        String end = formatter.format(aux);
        lbEnd = new JLabel("End: " + end);

        // Status
        lbStatus = new JLabel("Status: " + task.getStatus());

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
        this.add(lbDate);
        this.add(lbBegin);
        this.add(lbEnd);
        this.add(lbStatus);
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
