package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {

    ImageData imageData;

    static List<Node2D> points;
    static List<LineSegment> lineSegments = new ArrayList<>();
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

        /*for (LineSegment lineSegment : lineSegments) {
            lineSegment.paintComponent(g2D);
        }*/

        for(Boundary boundary : boundaries) {
            boundary.paintComponent(g2D);
        }

        for (Node2D node2D : points) {
            node2D.paintComponent(g2D);
        }
        g2D.dispose();
    }

    public static Node2D addPoint2D(Node2D node2D) {
        points.add(node2D);
        return node2D;
    }

    static void removePoint2D() {
        if(points.size() > 0) points.remove(points.size() - 1);
        else System.err.println("No points to remove!");
    }

    public static LineSegment addLineSegment(LineSegment lineSegment) {
        lineSegments.add(lineSegment);
        return lineSegment;
    }

    public static LineSegment addLineSegment(Node2D p1, Node2D p2) {
        LineSegment lineSegment = new LineSegment(p1, p2);
        lineSegments.add(lineSegment);
        return lineSegment;
    }

    public static void addBoundary(Boundary boundary) {
        boundaries.add(boundary);
        boundary.print();
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
        //this.repaint();
    }
}
