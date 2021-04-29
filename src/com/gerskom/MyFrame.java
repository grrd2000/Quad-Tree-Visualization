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

        int width = imageData.width + 40;
        int height = imageData.height + 40;
        this.setSize(width, height);
        this.setTitle("QuadTree Visualization");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(20,5));
        this.setVisible(true);

        centerPanel = new SimulationPanel(imageData);

        northPanel.setBackground(Color.DARK_GRAY);
        westPanel.setBackground(Color.DARK_GRAY);
        southPanel.setBackground(Color.DARK_GRAY);
        eastPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBackground(new Color(58,58,58));

        northPanel.setPreferredSize(new Dimension(100,30));
        westPanel.setPreferredSize(new Dimension(15,100));
        eastPanel.setPreferredSize(new Dimension(15, 100));
        southPanel.setPreferredSize(new Dimension(100,30));
        centerPanel.setPreferredSize(new Dimension(imageData.width, imageData.height));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
}
