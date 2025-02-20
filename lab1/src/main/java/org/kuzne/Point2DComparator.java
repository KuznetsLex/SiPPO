package org.kuzne;
import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {
    
    public int compare(Point2D a, Point2D b) {
        double delta= a.getX() - b.getX();
        if(delta > 0) return 1;
        if(delta < 0) return -1;
        return 0;
    }
}