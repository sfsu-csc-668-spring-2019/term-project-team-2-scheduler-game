package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import scheduler.Scheduler;

public class FrameSignup extends JFrame implements ActionListener {

    private JPanel frameContainer, formPanel, buttonsPanel;
    private CustomImage logoPanel;
    private JLabel lbUsername, lbPassword, lbMessage;
    private JTextField txtUsername;
    private JPasswordField txtPassword1, txtPassword2;
    private CustomButton btnSignup, btnCancel;

    public FrameSignup() {

        // Helpers
        Dimension dim = new Dimension();
        Color bgColor = Color.decode("#262a33");

        // Logo
        logoPanel = new CustomImage(new ImageIcon("images/logo-login.png").getImage());

        // Form (Step 1) - Create and populate the panel
        JPanel p = new JPanel(new SpringLayout());
        p.setBackground(bgColor);

        lbUsername = new JLabel("Username: ", JLabel.TRAILING);
        lbUsername.setForeground(Color.WHITE);
        p.add(lbUsername);
        txtUsername = new JTextField(20);
        lbUsername.setLabelFor(txtUsername);
        p.add(txtUsername);

        lbPassword = new JLabel("Password: ", JLabel.TRAILING);
        lbPassword.setForeground(Color.WHITE);
        p.add(lbPassword);
        txtPassword1 = new JPasswordField(20);
        lbPassword.setLabelFor(txtPassword1);
        p.add(txtPassword1);

        lbPassword = new JLabel("Password: ", JLabel.TRAILING);
        lbPassword.setForeground(Color.WHITE);
        p.add(lbPassword);
        txtPassword2 = new JPasswordField(20);
        lbPassword.setLabelFor(txtPassword2);
        p.add(txtPassword2);

        // Form (Step 2)  - Lay out the panel
        CustomForm.makeCompactGrid(p, 3 , 2, 60, 0, 5, 10);

        // Form (Step 3)  - Add final components
        formPanel = new JPanel(new BorderLayout());
        formPanel.setBackground(bgColor);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 42));
        formPanel.add(p);

        // Buttons
        buttonsPanel = new JPanel(new GridLayout(3,1));
        buttonsPanel.setBackground(bgColor);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 10, 50));
        dim.height = 150;
        buttonsPanel.setPreferredSize(dim);

        btnSignup = new CustomButton("SIGN UP", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        btnSignup.addActionListener(this);
        btnSignup.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, bgColor));

        btnCancel = new CustomButton("CANCEL", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnCancel.addActionListener(this);
        btnCancel.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, bgColor));

        lbMessage = new JLabel("", SwingConstants.CENTER);
        lbMessage.setForeground(Color.WHITE);

        buttonsPanel.add(btnSignup);
        buttonsPanel.add(btnCancel);
        buttonsPanel.add(lbMessage);

        // frameContainer settings
        frameContainer = new JPanel(new BorderLayout());
        frameContainer.setBackground(bgColor);
        frameContainer.add(logoPanel, BorderLayout.NORTH);
        frameContainer.add(formPanel, BorderLayout.CENTER);
        frameContainer.add(buttonsPanel, BorderLayout.SOUTH);

        // JFrame
        this.setLayout(new BorderLayout());
        this.add(frameContainer, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Scheduler Sign Up");
        this.setSize(400, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        int validator = 0;
        String userName = txtUsername.getText();
        String password1 = String.valueOf(txtPassword1.getPassword());
        String password2 = String.valueOf(txtPassword2.getPassword());

        if (clicked == btnSignup) {
            if (userName.trim().isEmpty() || password1.trim().isEmpty() || password2.trim().isEmpty()) {
                lbMessage.setText("All fields are required.");
            }
            else if (!password1.trim().equals(password2.trim())) {
                lbMessage.setText("Password does not match.");
            }
            else {
                validator = 1;

                Scheduler.createUser(userName, password1);

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new FrameLogin("Account successfully created!");
                    }
                });
            }
        }

        if (clicked == btnCancel) {
            this.dispose();
        }
    }
}
