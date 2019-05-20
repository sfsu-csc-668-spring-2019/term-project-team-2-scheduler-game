package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHome extends JPanel implements ActionListener {

    public PanelHome() {

        // Add initial components to FrameMain
        this.setLayout(new GridLayout(18, 1));
        Color bgColor = Color.decode("#EEEEEE");

        // Set panel header text
        JLabel lbTitle = new JLabel("Scheduler Game");
        lbTitle.setFont(new Font("Gill Sans MT",Font.BOLD,30));
        this.add(lbTitle);

        JLabel nada = new JLabel("");
        this.add(nada);

        JLabel team = new JLabel("Team:");
        team.setFont(new Font("Gill Sans MT",Font.BOLD,22));

        JLabel team1 = new JLabel("Hasaan Javed");
        team1.setFont(new Font("Gill Sans MT",Font.PLAIN,18));
        this.add(team);

        JLabel team2 = new JLabel("Matthieu Vilain");
        team2.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        JLabel team3 = new JLabel("Paul Uhlenkott");
        team3.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        JLabel team4 = new JLabel("Vinícius Miazaki");
        team4.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        this.add(team1);
        this.add(team2);
        this.add(team3);
        this.add(team4);

        this.setBorder(BorderFactory.createMatteBorder(40, 60, 0, 0, bgColor));

        // Set panel dimensions
        Dimension dim = new Dimension();
        dim.width = 600;
        setPreferredSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
