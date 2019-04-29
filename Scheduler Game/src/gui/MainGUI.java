package gui;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel customerPanel = new JPanel();
    private JPanel shoppingListPanel = new JPanel();
    private JPanel salePanel = new JPanel();

    public MainGUI(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.draw(this.createMainPanel());
    }


    private JPanel createMainPanel(){

        //main
        mainPanel.setLayout(new BorderLayout());
        customerPanel.setPreferredSize(new Dimension(600 , 90));
        mainPanel.add(customerPanel, BorderLayout.NORTH);
        shoppingListPanel.setPreferredSize(new Dimension(600, 420));
        mainPanel.add(shoppingListPanel, BorderLayout.CENTER);
        salePanel.setPreferredSize(new Dimension(600, 90));
        mainPanel.add(salePanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private void draw(JPanel mainPanel){

        this.getContentPane().add(mainPanel);
        this.pack();
        this.setSize(900, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Scheduler - Group 2");
        this.setVisible(true);
    }

}
