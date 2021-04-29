package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class SimulationPanel extends JPanel {

    ImageData imageData;

    static List<Point2D> points;
    static List<LineSegment> lineSegments = new ArrayList<>();
    static List<Line> lines = new ArrayList<>();

    public SimulationPanel(ImageData imageData) {
        super();
        this.imageData = imageData;
        points = imageData.keyPoints;
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        g2D.drawImage(imageData.image, 0, 0, null);

        for (LineSegment lineSegment : lineSegments) {
            lineSegment.paintComponent(g2D);
        }

        for (Point2D point2D : points) {
            point2D.paintComponent(g2D);
        }
        g2D.dispose();
    }

    public static Point2D addPoint2D(Point2D point2D) {
        points.add(point2D);
        return point2D;
    }

    static void removePoint2D() {
        if(points.size() > 0) points.remove(points.size() - 1);
        else System.err.println("No points to remove!");
    }

    public static LineSegment addLineSegment(LineSegment lineSegment) {
        lineSegments.add(lineSegment);
        return lineSegment;
    }

    public static LineSegment addLineSegment(Point2D p1, Point2D p2) {
        LineSegment lineSegment = new LineSegment(p1, p2);
        lineSegments.add(lineSegment);
        return lineSegment;
    }
}
