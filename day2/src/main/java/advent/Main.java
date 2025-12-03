package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        part2();
    }

    public static void part1() throws IOException {
        IDigitCheck idCheck = new IdCheck();
        IdSum idSum = new IdSum(idCheck);
        LineSplitter lineSplitter = new LineSplitter();

        String content = Files.readString(Path.of("src/main/resources/input.txt"));
        for (String ids : lineSplitter.splitCommas(content)) {
            for (long id : lineSplitter.iterDash(ids)) {
                idSum.process(id);
            }
        }

        System.out.println(idSum);
    }

    public static void part2() throws IOException {
        IDigitCheck idCheck = new IdCheckRepeated();
        IdSum idSum = new IdSum(idCheck);
        LineSplitter lineSplitter = new LineSplitter();

        String content = Files.readString(Path.of("src/main/resources/input.txt"));
        for (String ids : lineSplitter.splitCommas(content)) {
            for (long id : lineSplitter.iterDash(ids)) {
                idSum.process(id);
            }
        }

        System.out.println(idSum);
    }
}
