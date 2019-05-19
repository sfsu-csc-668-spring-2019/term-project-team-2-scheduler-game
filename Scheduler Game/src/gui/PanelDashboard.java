package gui;

import javax.swing.*;
import java.awt.*;

public class PanelDashboard extends JPanel {

    private CustomButton btn;
    private CustomImage pLogo;
    private JPanel pMenu1, pMenu2, pMenu3;
    private int btnCount;

    // Used for the top level menu (NARROW - with the icons)
    public PanelDashboard() {
        Dimension dim = new Dimension();
        dim.width = 100;

        pMenu1 = new JPanel();
        pMenu1.setLayout(new GridLayout(6, 1));
        pMenu1.setBackground(Color.decode("#5D00A2"));

        this.setPreferredSize(dim);
        this.setLayout(new GridLayout(1, 1));
        this.add(pMenu1);
    }

    // Used for the lower level menu (WIDE - for each panel)
    public PanelDashboard(String iconPath, int numItems) {
        Dimension dim = new Dimension();
        dim.width = 200;
        setPreferredSize(dim);
        btnCount = 0;

        pLogo = new CustomImage(new ImageIcon(iconPath).getImage());
        pMenu1 = new JPanel();
        pMenu1.setLayout(new GridLayout(4, 1));
        pMenu2 = new JPanel();
        pMenu2.setLayout(new GridLayout(4, 1));
        pMenu3 = new JPanel();
        pMenu3.setLayout(new GridLayout(4, 1));

        this.setLayout(new GridLayout(4, 1));
        this.add(pLogo);
        this.add(pMenu1);
        this.add(pMenu2);
        this.add(pMenu3);
    }

    // Used for the top level menu (NARROW - with the icons)
    public CustomButton newDashButton(String s, String iconPath, Color c1, Color c2) {
        btn = new CustomButton(s, iconPath, c1, c2);
        pMenu1.add(btn);
        return btn;
    }

    // Used for the lower level menu (WIDE - for each panel)
    public CustomButton newDashButton(String s) {
        btn = new CustomButton(s);

        if(btnCount < 4) pMenu1.add(btn);
        else if(btnCount < 8) pMenu2.add(btn);
        else pMenu3.add(btn);

        btnCount++;
        return btn;
    }

}