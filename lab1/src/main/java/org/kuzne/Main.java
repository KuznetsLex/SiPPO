package org.kuzne;

// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        double eps = 0.0005;
        DoubleUnaryOperator f = x -> 2*x*x - Math.exp(x);
        double actual = QuadraticInterpolation.extremeValue(f, 1, 0.5, eps, -99999, 99999);
        System.out.println(actual);
    }
    
}
