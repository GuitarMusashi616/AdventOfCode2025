package advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        part2();
    }

    public static void part1() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/example.txt"));
        System.out.println(lines);
        var tp = new ToiletPaperRolls(lines);
        var countNeighbors = new CountNeighbors(tp);

        var count = countNeighbors.rollsWithAdjacentLessThan(4);
        System.out.println(count);
    }

    public static void part2() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/input.txt"));
        System.out.println(lines);
        var tp = new ToiletPaperRolls(lines);
        var countNeighbors = new CountNeighbors(tp);

        var savedCoords = new ArrayList<Coord>();
        countNeighbors.rollsWithAdjacentLessThan(4, savedCoords);
        var total = 0;

        while (savedCoords.size() > 0) {
            countNeighbors.removeRollsFrom(savedCoords);
            total += savedCoords.size();
            System.out.printf("%d (%d)%n", total, savedCoords.size());
            savedCoords = new ArrayList<Coord>();
            countNeighbors.rollsWithAdjacentLessThan(4, savedCoords);
        }
    }
}
