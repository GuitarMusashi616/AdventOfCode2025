package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import advent.entity.Data;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) throws IOException {
        part1();
    }

    public static void part1() throws IOException {
        List<String> contents = Files.readAllLines(Path.of("src/main/resources/input.txt"));
        var data = Data.fromStringList(contents);
        var result = FreshRangeCheck.processData(data);
        System.out.println(result.stream().filter(x -> x).toArray().length);
    }


}