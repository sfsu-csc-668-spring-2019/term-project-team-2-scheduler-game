package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

// Source: https://gist.github.com/dreger/4646029

public class CustomButton extends JButton implements MouseListener {

    private Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    private Color textColor = Color.decode("#ffffff");
    private Color backgroundColor, hoverColor;
    private CustomImage icon;

    // Used for Login and Sign Up
    public CustomButton(String s, Color backgroundColor, Color hoverColor) {
        s = s.toUpperCase();
        this.backgroundColor = backgroundColor;
        this.hoverColor = hoverColor;
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setForeground(textColor);
        this.setHoverColor(hoverColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        this.addMouseListener(this);
    }

    // Used for the top level menu (with the icons)
    public CustomButton(String s, String iconPath, Color backgroundColor, Color hoverColor) {
        s = s.toUpperCase();
        this.backgroundColor = backgroundColor;
        this.hoverColor = hoverColor;
        this.setFocusPainted(false);
        this.setText(s);
        this.setBorder(null);
        this.setForeground(textColor);
        this.setHoverColor(hoverColor);
        this.setBackground(backgroundColor);
        this.setFont(defaultFont);
        this.setOpaque(true);
        this.addMouseListener(this);

        icon = new CustomImage(new ImageIcon(iconPath).getImage());
        this.add(icon);
    }

    // Used for the lower level menu (for each panel)
    public CustomButton(String s) {
        s = s.toUpperCase();

        if(!s.isEmpty()) {
            this.backgroundColor = Color.decode("#262A34");
            this.hoverColor = Color.decode("#9d3deb");
            this.setFocusPainted(false);
            this.setText(s);
            this.setBorder(null);
            this.setForeground(textColor);
            this.setBackground(backgroundColor);
            this.setFont(defaultFont);
            this.setOpaque(true);
            this.addMouseListener(this);
        }
        else {
            this.backgroundColor = Color.decode("#262A34");
            this.hoverColor = Color.decode("#262A34");
            this.setFocusPainted(false);
            this.setText(s);
            this.setBorder(null);
            this.setForeground(textColor);
            this.setBackground(backgroundColor);
            this.setFont(defaultFont);
            this.setOpaque(true);
        }
    }

    public void setBackgroundColor(Color color) { backgroundColor = color; }
    public void setHoverColor(Color color) {
        hoverColor = color;
    }

    @Override public void mouseClicked(MouseEvent me) {

    }

    @Override public void mouseReleased(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.hoverColor);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource()==this) {
            this.setBackground(this.backgroundColor);
        }
    }
}
