package gui;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;

public class Login extends JFrame implements ActionListener {

    JPanel containerPanel, loginPanel;
    JLabel lbUsername, lbPassword, lbMessage;
    JTextField txtUsername;
    JPasswordField txtPassword;
    JButton btnEnter;

    public Login() {

        // User Label
        lbUsername = new JLabel();
        lbUsername.setText("Username :");
        txtUsername = new JTextField();

        // Password
        lbPassword = new JLabel();
        lbPassword.setText("Password :");
        txtPassword = new JPasswordField();

        lbMessage = new JLabel();
        btnEnter = new JButton("SUBMIT");
        btnEnter.addActionListener(this);

        loginPanel = new JPanel(new GridLayout(3, 1));
        loginPanel.setMaximumSize(new Dimension(300, 100));
        loginPanel.add(lbUsername);
        loginPanel.add(txtUsername);
        loginPanel.add(lbPassword);
        loginPanel.add(txtPassword);
        loginPanel.add(lbMessage);
        loginPanel.add(btnEnter);

        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
        containerPanel.add(loginPanel);

        // JFrame settings
        try {this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg"))))); }
        catch (IOException e) {e.printStackTrace();}
        this.pack();
        this.setVisible(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(containerPanel, BorderLayout.CENTER);
        this.setTitle("Scheduler Login");
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
            new MainGUI();
            this.dispose();
        } else {
            lbMessage.setText(" Invalid user.. ");
        }
    }
}
