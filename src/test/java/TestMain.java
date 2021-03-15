import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "25\n2000\n370.35\n-1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        double[] expected = new double[]{2395.35, 2295.35, 100.0};
        double[] actual = Arrays.stream(outContent.toString().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "10\n12\n14\n15\n29\n99\n-1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        double[] expected = new double[]{179.0, 179.0, 0.0};
        double[] actual = Arrays.stream(outContent.toString().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "99.99\n0\n1000\n999.99\n0\n-1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        double[] expected = new double[]{2099.98, 2049.98, 50.0};
        double[] actual = Arrays.stream(outContent.toString().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "0\n-1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        double[] expected = new double[]{0.0, 0.0, 0.0};
        double[] actual = Arrays.stream(outContent.toString().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "-1";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        double[] expected = new double[]{0.0, 0.0, 0.0};
        double[] actual = Arrays.stream(outContent.toString().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        assertArrayEquals(expected, actual);
    }
}