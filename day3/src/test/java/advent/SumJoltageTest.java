package advent;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

import advent.sliding.SumJoltage;

/**
 * Unit test for simple App.
 */
public class SumJoltageTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldSolveExample() throws IOException{

        List<String> examples = Files.readAllLines(Path.of("src/main/resources/example.txt"));
        SumJoltage sumj = new SumJoltage();
        for (String example : examples) {
           // SlidingWindow.fromString(example, 12).printProcess();
            sumj.process(example, 12);
        }
        assertEquals(3121910778619L, sumj.getSum());
    }
}
