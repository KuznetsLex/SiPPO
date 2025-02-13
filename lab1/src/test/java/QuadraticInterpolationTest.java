import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.kuzne.QuadraticInterpolation;

public class QuadraticInterpolationTest {

    @Test
    public void parabola() {
        double expected = 1;
        double tolerance = 0.0001;
        double actual = QuadraticInterpolation.extremeValue(4, 0.3, tolerance, -4, 4);
        assertTrue(Math.abs(expected-actual) <= tolerance);
    }

    @Test
    public void hyperbola() {
        double expected = 1;
        double tolerance = 0.0001;
        double actual = QuadraticInterpolation.extremeValue(4, 0.3, tolerance, -4, 4);
        assertTrue(Math.abs(expected-actual) <= tolerance);
    }

    @Test
    public void sqrt() {
        double expected = 1;
        double tolerance = 0.0001;
        double actual = QuadraticInterpolation.extremeValue(4, 0.3, tolerance, -4, 4);
        assertTrue(Math.abs(expected-actual) <= tolerance);
    }
}
