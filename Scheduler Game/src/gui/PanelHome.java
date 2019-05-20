package gui;

import javax.swing.*;
import java.awt.*;

public class PanelHome extends JPanel implements ComponentTemplate {

    private JLabel lbTitle, nada, team, team1, team2, team3, team4;
    private Color color;
    private Dimension dim;

    public PanelHome() {

        // Implements methods from ComponentTemplate interface
        setHelpers();
        setContent();
        setContainer();
        addChild();
    }

    @Override
    public void setHelpers() {
        this.color = Color.decode("#EEEEEE");
        this.dim = new Dimension();
    }

    @Override
    public void setContent() {

        lbTitle = new JLabel("Scheduler Game");
        lbTitle.setFont(new Font("Gill Sans MT",Font.BOLD,30));

        nada = new JLabel("");

        team = new JLabel("Team:");
        team.setFont(new Font("Gill Sans MT",Font.BOLD,22));

        team1 = new JLabel("Hasaan Javed");
        team1.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        team2 = new JLabel("Matthieu Vilain");
        team2.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        team3 = new JLabel("Paul Uhlenkott");
        team3.setFont(new Font("Gill Sans MT",Font.PLAIN,18));

        team4 = new JLabel("Vinícius Miazaki");
        team4.setFont(new Font("Gill Sans MT",Font.PLAIN,18));
    }

    @Override
    public void setContainer() {
        dim.width = 600;
        this.setPreferredSize(dim);
        this.setLayout(new GridLayout(18, 1));
        this.setBorder(BorderFactory.createMatteBorder(40, 60, 0, 0, color));
    }

    @Override
    public void addChild() {
        this.add(lbTitle);
        this.add(nada);
        this.add(team);
        this.add(team1);
        this.add(team2);
        this.add(team3);
        this.add(team4);
    }
}
