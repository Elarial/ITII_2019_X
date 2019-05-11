package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class MainWindow extends JFrame {
    private static MainWindow instance;
    public static MainWindow getInstance()
    {
        if(instance == null)
            instance = new MainWindow();
        return instance;
    }
    private MainWindow(){
        super("JavaSwingApp");
        initialize();
    }
    private void initialize()
    {

        Dimension windowDimension = new Dimension(300,300);
        this.setSize(windowDimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        this.setLayout(new GridLayout(3,1));
        JLabel headerLabel = new JLabel("",JLabel.CENTER );
        JLabel statusLabel = new JLabel("",JLabel.CENTER);

         */

        this.validate();
        this.repaint();

        final MainMenuBar menuBar = new MainMenuBar();
        final DropDownMenu dropDownMenu = new DropDownMenu();
        final NorthPanel northPanel = new NorthPanel();
        final PanelContainer panelContainer = new PanelContainer();
        final CenterPanel centerPanel = new CenterPanel();
        final ListPanel listPanel = new ListPanel();
        final MonthlyPanel monthlyPanel = new MonthlyPanel();
        final WeeklyPanel weeklyPanel = new WeeklyPanel();
        final RightPanel rightPanel = new RightPanel();

        this.setJMenuBar(menuBar);
        this.add(panelContainer);
        panelContainer.add(northPanel,BorderLayout.PAGE_START);
        panelContainer.add(centerPanel,BorderLayout.CENTER);
        panelContainer.add(rightPanel,BorderLayout.LINE_END);

        northPanel.add(dropDownMenu,BorderLayout.CENTER);
        centerPanel.add(listPanel,"Liste");
        centerPanel.add(monthlyPanel,"Mois");
        centerPanel.add(weeklyPanel,"Semaine");



        dropDownMenu.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String box = dropDownMenu.getSelectedItem().toString();
                CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
                cardLayout.show(centerPanel, box);
            }
        });

        this.setVisible(true);
    }
}
