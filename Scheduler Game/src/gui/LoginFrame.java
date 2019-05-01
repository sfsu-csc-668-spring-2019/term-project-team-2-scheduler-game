package gui;

import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;

public class LoginFrame extends JFrame implements ActionListener {

    private JPanel loginContainer, loginPanel;
    private JLabel lbUsername, lbPassword, lbMessage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private CustomButton btnEnter;

    public LoginFrame() {

        // Setup loginPanel components
        lbUsername  = new JLabel("Username :");
        txtUsername = new JTextField(20);
        lbPassword  = new JLabel("Password :");
        txtPassword = new JPasswordField(20);
        lbMessage   = new JLabel();
        btnEnter    = new CustomButton("SUBMIT");
        btnEnter.addActionListener(this);

        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // loginPanel first row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        loginPanel.add(lbUsername, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(txtUsername, gc);

        // loginPanel second row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(lbPassword, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(txtPassword, gc);

        // loginPanel third row
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(lbMessage, gc);

        // loginContainer setup and add button



        loginContainer = new JPanel();
        loginContainer.setLayout(new BoxLayout(loginContainer, BoxLayout.Y_AXIS));
        loginContainer.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
        loginContainer.add(loginPanel);

        // JFrame settings
        try {this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg"))))); }
        catch (IOException e) {e.printStackTrace();}
        this.pack();
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(loginContainer, BorderLayout.CENTER);
        this.add(btnEnter, BorderLayout.SOUTH);
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
            this.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MainFrame();
                }
            });
        } else {
            lbMessage.setText(" Invalid user.. ");
        }
    }
}
