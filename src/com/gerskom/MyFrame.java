package com.gerskom;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {

    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    SimulationPanel centerPanel;

    public MyFrame(ImageData imageData) {

        ImageIcon icon = new ImageIcon("input.jpg");
        centerPanel = new SimulationPanel(imageData);

        int width = imageData.width;
        int height = imageData.height;
        this.setSize(width, height);
        this.setTitle("QuadTree Visualization");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setVisible(true);

        northPanel.setBackground(Color.DARK_GRAY);
        westPanel.setBackground(Color.DARK_GRAY);
        southPanel.setBackground(Color.DARK_GRAY);
        eastPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBackground(new Color(58,58,58));

        northPanel.setPreferredSize(new Dimension(0,0));
        westPanel.setPreferredSize(new Dimension(0,0));
        eastPanel.setPreferredSize(new Dimension(0, 0));
        southPanel.setPreferredSize(new Dimension(0,0));
        centerPanel.setPreferredSize(new Dimension(imageData.width, imageData.height));


        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
}
