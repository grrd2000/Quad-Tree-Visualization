package com.gerskom;

import java.awt.*;

public class Point2D {

    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println("P[" + x + ", " + y + "]");
    }

    public void paintComponent (Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(new Color(250,110,0));
        g2D.setStroke(new BasicStroke(1.5f));
        g2D.drawLine(x, y, x, y);
    }
}
