package gui;

import javax.swing.*;
import java.awt.*;

public class PanelDashboard extends JPanel {

    private CustomButton btn;
    private CustomImage pLogo;
    private JPanel pMenu;

    // Used for the top level menu (with the icons)
    public PanelDashboard(int numItems) {
        Dimension dim = new Dimension();
        dim.width = 100;
        setPreferredSize(dim);

        pMenu = new JPanel();
        this.setLayout(new GridLayout(numItems, 1));
        this.add(pMenu);
        pMenu.setLayout(new GridLayout(numItems, 1));
    }

    // Used for the lower level menu (for each panel)
    public PanelDashboard(String iconPath, int numItems) {
        Dimension dim = new Dimension();
        dim.width = 200;
        setPreferredSize(dim);

        pLogo = new CustomImage(new ImageIcon(iconPath).getImage());
        pMenu = new JPanel();
        this.setLayout(new GridLayout(numItems, 1));
        this.add(pLogo);
        this.add(pMenu);
        pMenu.setLayout(new GridLayout(numItems, 1));
    }

    public CustomButton newDashButton(String s) {
        btn = new CustomButton(s);
        pMenu.add(btn);
        return btn;
    }

    public CustomButton newDashButton(String s, Color c1, Color c2) {
        btn = new CustomButton(s, c1, c2);
        pMenu.add(btn);
        return btn;
    }
}