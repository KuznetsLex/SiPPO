package org.kuzne;

import static org.kuzne.FunctionUsed.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuadraticInterpolation {
    public static double extremeValue(double startValue, double step, double tolerance, double leftBound, double rightBound) {
        Point2D firstPoint = new Point2D(startValue, f(startValue));
        Point2D secondPoint = new Point2D(startValue+step, f(startValue+step));
        Point2D thirdPoint = firstPoint.getY() < secondPoint.getY() ? 
                    new Point2D(startValue-step, f(startValue-step)) : 
                    new Point2D(startValue+2*step, f(startValue+2*step));

        
        double a = firstPoint.getX();
        double b = secondPoint.getX();
        double c = thirdPoint.getX();
        double fa = firstPoint.getY();
        double fb = secondPoint.getY();
        double fc = thirdPoint.getY();
        double delta = (0.5)*(((b*b-c*c)*fa+(c*c-a*a)*fb+(a*a-b*b)*fc)/((b-c)*fa+(c-a)*fb+(a-b)*fc));
        List<Point2D> pointsList = new ArrayList<>();
        Collections.addAll(pointsList, firstPoint, secondPoint, thirdPoint, new Point2D(delta, f(delta)));          

        double newMin = f(delta);
        double oldMin = Double.POSITIVE_INFINITY;
        while (oldMin-newMin >= tolerance) {
            pointsList.remove(Collections.min(pointsList));
            a = pointsList.get(0).getX();
            b = pointsList.get(1).getX();
            c = pointsList.get(2).getX();
            fa = pointsList.get(0).getY();
            fb = pointsList.get(1).getY();
            fc = pointsList.get(2).getY();
            delta = (0.5)*(a+b) + (0.5*(fa-fb)*(b-c)*(c-a))/((b-c)*fa+(c-a)*fb+(a-b)*fc);
            if (delta < leftBound || delta > rightBound) { break; }
            oldMin = newMin;
            newMin = f(delta);
            pointsList.add(new Point2D(delta, newMin));
        }
        return delta;
    }
}