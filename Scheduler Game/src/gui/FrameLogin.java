package gui;

import scheduler.Scheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameLogin extends JFrame implements ActionListener, TemplateFrame {

    private JPanel frameContainer, formPanel, buttonsPanel;
    private CustomImage logoPanel;
    private JLabel lbUsername, lbPassword, lbMessage;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private CustomButton btnLogin, btnSignup;

    private String message;
    private Color color;
    private Dimension dim;

    public FrameLogin(String message) {

        // Stores parameter
        this.message = message;

        // Icon
        logoPanel = new CustomImage(new ImageIcon("Scheduler Game/src/images/logo-login.png").getImage());

        // Implements methods from TemplateComponent interface
        setHelpers();
        setForm();
        setButtons();
        addChildren();
        setFrame();
    }

    @Override
    public void setHelpers() {
        this.dim = new Dimension();
        this.color = Color.decode("#262a33");
    }

    @Override
    public void setForm() {
        JPanel p = new JPanel(new SpringLayout());
        p.setBackground(color);

        // Form (Step 1) - Create and populate the panel
        lbUsername = new JLabel("Username: ", JLabel.TRAILING);
        lbUsername.setForeground(Color.WHITE);
        p.add(lbUsername);
        txtUsername = new JTextField(20);
        lbUsername.setLabelFor(txtUsername);
        p.add(txtUsername);

        lbPassword = new JLabel("Password: ", JLabel.TRAILING);
        lbPassword.setForeground(Color.WHITE);
        p.add(lbPassword);
        txtPassword = new JPasswordField(20);
        lbPassword.setLabelFor(txtPassword);
        p.add(txtPassword);

        // Form (Step 2)  - Lay out the panel
        CustomForm.makeCompactGrid(p, 2 , 2, 60, 0, 5, 10);

        // Form (Step 3)  - Add final components
        formPanel = new JPanel(new BorderLayout());
        formPanel.setBackground(color);
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 42));
        formPanel.add(p);
    }

    @Override
    public void setButtons() {

        buttonsPanel = new JPanel(new GridLayout(3,1));
        buttonsPanel.setBackground(color);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 10, 50));

        dim.height = 150;
        buttonsPanel.setPreferredSize(dim);

        btnLogin = new CustomButton("LOG IN", Color.decode("#9d3deb"), Color.decode("#6D0EB5"));
        btnLogin.addActionListener(this);
        btnLogin.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, color));

        btnSignup = new CustomButton("SIGN UP", Color.decode("#434751"), Color.decode("#6D0EB5"));
        btnSignup.addActionListener(this);
        btnSignup.setBorder(BorderFactory.createMatteBorder(3, 0, 0, 0, color));

        lbMessage = new JLabel(message, SwingConstants.CENTER);
        lbMessage.setForeground(Color.WHITE);

        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnSignup);
        buttonsPanel.add(lbMessage);
    }

    @Override
    public void setFrame() {
        this.setLayout(new BorderLayout());
        this.add(frameContainer, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Scheduler Login");
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void addChildren() {
        frameContainer = new JPanel(new BorderLayout());
        frameContainer.setBackground(color);
        frameContainer.add(logoPanel, BorderLayout.NORTH);
        frameContainer.add(formPanel, BorderLayout.CENTER);
        frameContainer.add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        String userName = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());

        if (clicked == btnLogin) {
            if (!userName.isEmpty() && !password.isEmpty()) {

                int check = Scheduler.loadUser(userName, password);

                if(check == 0) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new FrameMain();
                        }
                    });
                    this.dispose();
                } else {
                    lbMessage.setText("Invalid Username or Password.");
                }

            } else {
                lbMessage.setText("Invalid Username or Password.");
            }
        }
        else if (clicked == btnSignup) {
            this.dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new FrameSignup();
                }
            });
        }
    }

}