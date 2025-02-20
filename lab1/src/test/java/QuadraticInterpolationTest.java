import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import org.junit.jupiter.api.*;
import org.kuzne.FileInput;
import org.kuzne.QuadraticInterpolation;

public class QuadraticInterpolationTest {

    @Test
    public void pinnedFunction() {
        double expected = 1;
        double eps = 0.001;
        double actual = QuadraticInterpolation.extremeValue(0, 0.05, eps, -4, 4);
        assertTrue(Math.abs(expected-actual) <= eps);
    }

    @Test
    public void hyperbola() {
        double expected = -0.5;
        DoubleUnaryOperator f = x -> 1/x;
        double eps = 0.01;
        double actual = QuadraticInterpolation.extremeValue(f, -4, 0.5, eps, -1, -0.5);
        assertTrue(Math.abs(expected-actual) <= eps);
    }

    @Test
    public void fileInput() throws FileNotFoundException {
        double expected = 1;
        List<Double> inputFromFile = FileInput.fileInput("/Users/test/Desktop/University/Labs/SyPPO_2/labs/lab1/src/main/java/org/kuzne/input.txt");
        double eps = inputFromFile.get(2);
        DoubleUnaryOperator f = x -> Math.sqrt(x);
        double actual = QuadraticInterpolation.extremeValue(f, inputFromFile.get(0), inputFromFile.get(1), inputFromFile.get(2), inputFromFile.get(3), inputFromFile.get(4));
        assertTrue(Math.abs(expected-actual) <= eps);
    }

    @Test
    public void charsInFile() {
        String pathname = "/Users/test/Desktop/University/Labs/SyPPO_2/labs/lab1/src/test/java/charsInFile.txt";
        assertThrows(
            InputMismatchException.class,
           () -> FileInput.fileInput(pathname)
        );
    }

    @Test
    public void paramsNumberOverflow() {
        String pathname = "/Users/test/Desktop/University/Labs/SyPPO_2/labs/lab1/src/test/java/paramsNumberOverflow.txt";
        ArrayIndexOutOfBoundsException thrown = assertThrows(
           ArrayIndexOutOfBoundsException.class,
           () -> FileInput.fileInput(pathname)
        );
        assertTrue(thrown.getMessage().contains("ERROR: В файле ожидалось 5 параметров."));
    }

    @Test
    public void paramsNumberLack() {
        String pathname = "/Users/test/Desktop/University/Labs/SyPPO_2/labs/lab1/src/test/java/paramsNumberLack.txt";
        ArrayIndexOutOfBoundsException thrown = assertThrows(
           ArrayIndexOutOfBoundsException.class,
           () -> FileInput.fileInput(pathname)
        );
        assertTrue(thrown.getMessage().contains("ERROR: В файле ожидалось 5 параметров."));
    }

    @Test
    public void FileNotFound() {
        String pathname = "noSuchFile.txt";
        FileNotFoundException thrown = assertThrows(
            FileNotFoundException.class,
           () -> FileInput.fileInput(pathname)
        );
        assertTrue(thrown.getMessage().contains("ERROR: Файл с таким именем не найден."));
    }
}
