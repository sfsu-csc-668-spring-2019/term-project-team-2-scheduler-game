package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDashboard extends JPanel implements ActionListener {

    private CustomButton btnHome, btnCalendar, btnCity, btnLogout;
    private CustomImage pLogo;
    private JPanel pMenu;
    private StringListener textListener;

    public PanelDashboard() {
        Dimension dim = new Dimension();
        dim.width = 200;
        setPreferredSize(dim);

        // Panels
        pLogo = new CustomImage(new ImageIcon("images/logo-icon.png").getImage());
        pMenu = new JPanel();

        this.setLayout(new GridLayout(4, 1));
        this.add(pLogo);
        this.add(pMenu);

        // Buttons
        btnHome = new CustomButton("Home");
        btnCalendar = new CustomButton("Calendar");
        btnCity = new CustomButton("City");
        btnLogout = new CustomButton("Logout");

        btnHome.addActionListener(this);
        btnCalendar.addActionListener(this);
        btnCity.addActionListener(this);
        btnLogout.addActionListener(this);

        pMenu.setLayout(new GridLayout(4, 1));
        pMenu.add(btnHome);
        pMenu.add(btnCalendar);
        pMenu.add(btnCity);
        pMenu.add(btnLogout);
    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if (clicked == btnHome) {
            if(textListener != null) {
                textListener.textEmitted("btnHome\n");
            }
        }
        else if (clicked == btnCalendar) {
            if(textListener != null) {
                textListener.textEmitted("btnCalendar\n");
            }
        }
        else if (clicked == btnCity) {
            if(textListener != null) {
                textListener.textEmitted("btnCity\n");
            }
        }
        else if (clicked == btnLogout) {
            if(textListener != null) {
                textListener.textEmitted("btnLogout\n");
            }
        }
    }
}