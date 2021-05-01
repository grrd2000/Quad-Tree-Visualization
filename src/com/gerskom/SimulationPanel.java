package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {

    ImageData imageData;

    static List<Node2D> points;
    static List<Boundary> boundaries = new ArrayList<>();

    public SimulationPanel(ImageData imageData) {
        super();
        this.imageData = imageData;
        this.setPreferredSize(new Dimension(imageData.width, imageData.height));
        points = imageData.keyPoints;
        //testData();
        quadTreeAlgorithm();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        g2D.drawImage(imageData.image, 0, 0, null);

        for(Boundary boundary : boundaries) {
            boundary.paintComponent(g2D);
        }

        for (Node2D node2D : points) {
            node2D.paintComponent(g2D);
        }
        g2D.dispose();
    }

    public static void addBoundary(Boundary boundary) {
        boundaries.add(boundary);
        //boundary.print();
    }

    void testData() {
        boundaries.add(new Boundary(0,0,imageData.image.getWidth(),imageData.image.getHeight()));
        boundaries.add(new Boundary(250,250,450,450));
        //this.repaint();
        //quadTreeAlgorithm();
    }

    public void quadTreeAlgorithm() {
        QuadTree quadTree = new QuadTree(1, new Boundary(0,0,imageData.width, imageData.height));

        for(Node2D node : imageData.keyPoints) {
            quadTree.insert(node.x, node.y, 1);
        }
        QuadTree.dfs(quadTree);
        System.out.println("end");
    }
}
