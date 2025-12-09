package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import advent.sliding.SlidingWindow;
import advent.sliding.SumJoltage;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        part2();
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

    static void part2() throws IOException {
        List<String> examples = Files.readAllLines(Path.of("src/main/resources/input.txt"));

        // for (String example : examples) {
        //     SlidingWindow numbers = SlidingWindow.fromString(example, 12);
        //     System.out.println(numbers);
        //     numbers.printProcess();
        // }

        SumJoltage sumj = new SumJoltage();
        for (String example : examples) {
            sumj.process(example, 12, true);
        }
        System.out.printf("%nTotal: %d%n", sumj.getSum());
    }
}
