package gui;

import javax.swing.*;
import java.awt.*;

public class PanelDashboard extends JPanel {

    private CustomButton btn;
    private CustomImage pLogo;
    private JPanel pMenu;

    // Used for the top level menu (with the icons)
    public PanelDashboard() {
        Dimension dim = new Dimension();
        dim.width = 100;

        pMenu = new JPanel();
        pMenu.setLayout(new GridLayout(6, 1));
        pMenu.setBackground(Color.decode("#5D00A2"));

        this.setPreferredSize(dim);
        this.setLayout(new GridLayout(1, 1));
        this.add(pMenu);
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


    public CustomButton newDashButton(String s, String iconPath, Color c1, Color c2) {
        btn = new CustomButton(s, iconPath, c1, c2);
        pMenu.add(btn);
        return btn;
    }

}