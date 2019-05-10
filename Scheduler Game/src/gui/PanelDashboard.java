package gui;

import javax.swing.*;
import java.awt.*;

public class PanelDashboard extends JPanel {

    private CustomButton btn;
    private CustomImage pLogo;
    private JPanel pMenu;

    public PanelDashboard() {
        Dimension dim = new Dimension();
        dim.width = 200;
        setPreferredSize(dim);

        pLogo = new CustomImage(new ImageIcon("images/logo-icon.png").getImage());
        pMenu = new JPanel();

        this.setLayout(new GridLayout(4, 1));
        this.add(pLogo);
        this.add(pMenu);

        pMenu.setLayout(new GridLayout(4, 1));
    }

    public CustomButton newDashButton(String s) {
        btn = new CustomButton(s);
        pMenu.add(btn);
        return btn;
    }
}