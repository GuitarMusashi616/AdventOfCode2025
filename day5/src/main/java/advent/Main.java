package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import advent.entity.Data;
import advent.entity.Range;
import advent.entity.Replace;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        part2();
    }

    public static void part1() throws IOException {
        List<String> contents = Files.readAllLines(Path.of("src/main/resources/input.txt"));
        var data = Data.fromStringList(contents);
        var result = FreshRangeCheck.processData(data);
        System.out.println(result.stream().filter(x -> x).toArray().length);
    }

    public static void part2() throws IOException {
        List<String> contents = Files.readAllLines(Path.of("src/main/resources/input.txt"));
        var data = Data.fromStringList(contents);
        // System.out.println(data);

        boolean isContinue = true;

        while (isContinue) {
            int before = data.ranges.size();
            data.ranges = MergeRanges.mergeRanges(data.ranges);
            int after = data.ranges.size();
            isContinue = before != after;
        }

        System.out.println(data.ranges);
        long result = data.ranges.stream().map(x -> x.getDist() + 1).reduce((a,b) -> a + b).orElse(-1L);
        System.out.println(result);
    }


}