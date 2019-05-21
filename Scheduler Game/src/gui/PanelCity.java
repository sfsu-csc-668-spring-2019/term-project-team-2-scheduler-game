package gui;

import scheduler.Scheduler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class PanelCity extends JPanel implements ActionListener, TemplateComponent {

    private PanelDashboard dashboardCity;
    private JLabel panelTitle;
    private JPanel[] panelArray = new JPanel[12];
    private JPanel cityPanel = new JPanel();
    private JPanel statPanel = new JPanel();
    private Hashtable<JToggleButton, ArrayList<Integer>> lots = new Hashtable<>();
    private CustomButton[] btnArray = new CustomButton[12];
    private Color color;
    private Dimension dim;

    public PanelCity() {

        // Implements methods from TemplateComponent interface
        setHelpers();
        setContent();
        setContainer();
        addChild();
    }

    @Override
    public void setHelpers() {
        this.dim = new Dimension();
        this.color = Color.decode("#262A34");
    }

    @Override
    public void setContent() {

        panelTitle = new JLabel("City");

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("Scheduler Game/src/images/logo-city.png", 4);

        // Create the main panels that will have the main content
        dashboardCity = new PanelDashboard("Scheduler Game/src/images/logo-city.png", 12);
        for(int i=0; i<12; i++) {
            panelArray[i] = new JPanel();
        }

        // Create the dashboard button for each of the main panels
        btnArray[0] = dashboardCity.newDashButton("City Manager");
        btnArray[1] = dashboardCity.newDashButton("Stats");
        //btnArray[2] = dashboardCity.newDashButton("Three");
        btnArray[0].addActionListener(this);
        btnArray[1].addActionListener(this);
        //btnArray[2].addActionListener(this);

        // Create all the other empty buttons
        for(int i=3; i<12; i++) {
            btnArray[i] = dashboardCity.newDashButton("");
        }

        dashboardCity.setBackground(color);
    }

    @Override
    public void setContainer() {
        dim.width = 600;
        this.setPreferredSize(dim);
        this.setLayout(new BorderLayout());
    }

    @Override
    public void addChild() {
        this.add(dashboardCity, BorderLayout.WEST);
        this.add(panelArray[0], BorderLayout.EAST);
        this.add(panelTitle, BorderLayout.CENTER);
        this.add(cityPanel);
        //this.add(statPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        this.remove(cityPanel);
        cityPanel.removeAll();
        this.remove(statPanel);
        statPanel.removeAll();

        if (clicked == btnArray[0]){

            int areaX = 3;
            int areaY = 3;
            JPanel addBuilding = new JPanel();
            JPanel cityGrid = new JPanel();
            //addBuilding.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            addBuilding.setLayout(new BoxLayout(addBuilding, BoxLayout.Y_AXIS));
            cityGrid.setLayout(new GridLayout(areaX, areaY, 10, 10));
            JPanel lotSelection = new JPanel();
            JLabel lotLabel = new JLabel("No Lot Selected", JLabel.CENTER);
            JPanel purchaseButtonPanel = new JPanel();

            String [] buildingTypes = {"Civic", "Residential", "Commercial"};
            JComboBox buildingSelection = new JComboBox(buildingTypes);
            JButton buildingPurchase = new JButton("Purchase");
            buildingPurchase.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    ArrayList<JToggleButton> keys = new ArrayList<JToggleButton>(lots.keySet());
                    JToggleButton purchased = null;
                    for (int k = 0; k < keys.size(); k++){
                        JToggleButton selectedButton = keys.get(k);
                        if (selectedButton.isSelected()){
                            purchased = selectedButton;
                        }
                    }
                    if (purchased == null){
                        return;
                    }
                    String buildingType = (String)buildingSelection.getSelectedItem();
                    ArrayList<Integer> coord = lots.get(purchased);
                    purchased.setText(buildingType);
                    Scheduler.getUserCity().addBuilding(buildingType, coord);

                }
            });
            purchaseButtonPanel.add(buildingPurchase);
            lotSelection.add(lotLabel);
            lotSelection.add(buildingSelection);
            lotSelection.add(purchaseButtonPanel);
            addBuilding.add(lotSelection);
            for (int i = 0; i < areaX; i++)
            {
                for (int j = 0; j < areaY; j++)
                {
                    JToggleButton button = new JToggleButton("Unclaimed");
                    button.setActionCommand("(" + i + ", " + j + ")");
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {

                        ArrayList<JToggleButton> keys = new ArrayList<JToggleButton>(lots.keySet());
                        for (int k = 0; k < keys.size(); k++){
                            JToggleButton selectedButton = keys.get(k);
                            if (!selectedButton.equals((JToggleButton)ae.getSource()) && selectedButton.isSelected()){
                                selectedButton.setSelected(false);
                            }
                        }
                        JToggleButton but = (JToggleButton) ae.getSource();
                        lotLabel.setText(
                                "Purchase building at: " + but.getActionCommand());

                    }
                });
                    cityGrid.add(button);
                    ArrayList<Integer> coord = new ArrayList<Integer>(Arrays.asList(i,j));
                    lots.put(button, coord);
                }
            }
            cityPanel.add(addBuilding);
            cityPanel.add(cityGrid);
            // Set panel header text
            this.add(cityPanel);
        }
        else if (clicked == btnArray[1]){

            JLabel statLabel= new JLabel(Scheduler.getUserCity().toString());
            statPanel.add(statLabel);
            this.add(statPanel);
        }

        /*for(int i=0; i<12; i++) {
            if (clicked == btnArray[i]) {
                this.panelTitle.setText("City " + (i+1));
                break;
            }
        }*/

        this.revalidate();
        this.repaint();

    }
}
