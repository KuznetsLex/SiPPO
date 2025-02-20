package org.kuzne;

import static org.kuzne.FunctionUsed.f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleUnaryOperator;


public class QuadraticInterpolation {
    public static double extremeValue(DoubleUnaryOperator f, double startValue, double step, double eps, double leftBound, double rightBound) {
        if (f.applyAsDouble(leftBound) < f.applyAsDouble(leftBound+eps)) { return leftBound; }
        if (f.applyAsDouble(rightBound) < f.applyAsDouble(rightBound-eps)) { return rightBound; }
        if (!(leftBound <= rightBound && startValue >= leftBound && startValue <= rightBound)) { throw new ArrayIndexOutOfBoundsException(); }
        Point2D firstPoint = new Point2D(startValue, f);
        Point2D secondPoint = new Point2D(startValue+step, f);
        Point2D thirdPoint = firstPoint.getY() < secondPoint.getY() ? 
                    new Point2D(startValue-step, f) : 
                    new Point2D(startValue+2*step, f);

        // начало to delete 
        System.out.print(firstPoint + ", ");
        System.out.print(secondPoint + ", ");
        System.out.print(thirdPoint + ", \n");
        // конец to delete

        double a = firstPoint.getX();
        double b = secondPoint.getX();
        double c = thirdPoint.getX();
        double fa = firstPoint.getY();
        double fb = secondPoint.getY();
        double fc = thirdPoint.getY();
        double delta = (0.5)*(((b*b-c*c)*fa+(c*c-a*a)*fb+(a*a-b*b)*fc)/((b-c)*fa+(c-a)*fb+(a-b)*fc));
        List<Point2D> pointsList = new ArrayList<>();
        Collections.addAll(pointsList, firstPoint, secondPoint, thirdPoint, new Point2D(delta, f));          

        double newMin = f.applyAsDouble(delta);
        double oldMin = Double.POSITIVE_INFINITY;

        Comparator<Point2D> cmp = new Point2DComparator();
        while (Math.abs(oldMin-newMin) >= eps) {
            pointsList.sort(cmp);
            if (Collections.max(pointsList).equals(pointsList.get(0)) &&
                Collections.min(pointsList).equals(pointsList.get(1))) {
                    pointsList.remove(3);
            } 
            else if (Collections.max(pointsList).equals(pointsList.get(3)) &&
                Collections.min(pointsList).equals(pointsList.get(2))) {
                    pointsList.remove(0);
            } else {
                pointsList.remove(Collections.max(pointsList));
            }
            
            // начало to delete 
            for (Point2D point : pointsList) {
                System.out.print(point+"; ");
            }
            System.out.println();
            // конец to delete

            a = pointsList.get(0).getX();
            b = pointsList.get(1).getX();
            c = pointsList.get(2).getX();
            fa = pointsList.get(0).getY();
            fb = pointsList.get(1).getY();
            fc = pointsList.get(2).getY();
            delta = (0.5)*(a+b) + (0.5*(fa-fb)*(b-c)*(c-a))/((b-c)*fa+(c-a)*fb+(a-b)*fc);
            oldMin = newMin;
            newMin = delta;
            pointsList.add(new Point2D(delta, f));
        }
        return delta;
    }

    public static double extremeValue(double startValue, double step, double eps, double leftBound, double rightBound) {
        if (f.applyAsDouble(leftBound) < f.applyAsDouble(leftBound+eps)) { return leftBound; }
        if (f.applyAsDouble(rightBound) < f.applyAsDouble(rightBound-eps)) { return rightBound; }
        if (!(leftBound <= rightBound && startValue >= leftBound && startValue <= rightBound)) { throw new ArrayIndexOutOfBoundsException(); }
        Point2D firstPoint = new Point2D(startValue, f);
        Point2D secondPoint = new Point2D(startValue+step, f);
        Point2D thirdPoint = firstPoint.getY() < secondPoint.getY() ? 
                    new Point2D(startValue-step, f) : 
                    new Point2D(startValue+2*step, f);
            
        // начало to delete 
        System.out.print(firstPoint + ", ");
        System.out.print(secondPoint + ", ");
        System.out.print(thirdPoint + ", \n");
        // конец to delete

        double a = firstPoint.getX();
        double b = secondPoint.getX();
        double c = thirdPoint.getX();
        double fa = firstPoint.getY();
        double fb = secondPoint.getY();
        double fc = thirdPoint.getY();
        double delta = (0.5)*(((b*b-c*c)*fa+(c*c-a*a)*fb+(a*a-b*b)*fc)/((b-c)*fa+(c-a)*fb+(a-b)*fc));
        List<Point2D> pointsList = new ArrayList<>();
        Collections.addAll(pointsList, firstPoint, secondPoint, thirdPoint, new Point2D(delta, f));          

        double newMin = f.applyAsDouble(delta);
        double oldMin = Double.POSITIVE_INFINITY;

        Comparator<Point2D> cmp = new Point2DComparator();
        while (Math.abs(oldMin-newMin) >= eps) {
            pointsList.sort(cmp);
            if (Collections.max(pointsList).equals(pointsList.get(0)) &&
                Collections.min(pointsList).equals(pointsList.get(1))) {
                    pointsList.remove(3);
            } 
            else if (Collections.max(pointsList).equals(pointsList.get(3)) &&
                Collections.min(pointsList).equals(pointsList.get(2))) {
                    pointsList.remove(0);
            } else {
                pointsList.remove(Collections.max(pointsList));
            }
            // начало to delete 
            for (Point2D point : pointsList) {
                System.out.print(point+"; ");
            }
            System.out.println();
            // конец to delete 
            a = pointsList.get(0).getX();
            b = pointsList.get(1).getX();
            c = pointsList.get(2).getX();
            fa = pointsList.get(0).getY();
            fb = pointsList.get(1).getY();
            fc = pointsList.get(2).getY();
            delta = (0.5)*(a+b) + (0.5*(fa-fb)*(b-c)*(c-a))/((b-c)*fa+(c-a)*fb+(a-b)*fc);
            oldMin = newMin;
            pointsList.add(new Point2D(delta, f));
        }
        return delta;
    }
}