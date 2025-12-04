package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        part1();
    }

    static void part1() throws IOException {
        List<String> examples = Files.readAllLines(Path.of("src/main/resources/input.txt"));
        var jolt = new Joltage2();
        var battSum = new BatterySum(jolt);
        for (String example : examples) {
            battSum.process(example);
        }
        System.out.println(battSum);
    }

}
