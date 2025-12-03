package advent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class InvalidIdTest {
    @Test
    public void idIsInvalid() {
        IdCheck app = new IdCheck();

        Map<String, Boolean> numberCheck = Map.of(
            "11", true,
            "22", true,
            "23", false
        );

        for (Map.Entry<String, Boolean> number : numberCheck.entrySet()) {
            boolean result = app.isDigitsRepeated(number.getKey());
            assertTrue(result == number.getValue(), "Number does not return correct result");
        }
    }

    @Test
    public void commaSplitTest() {
        LineSplitter lineSplitter = new LineSplitter();
        String problem = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";
        var result = lineSplitter.splitCommas(problem);
        assertEquals(11, result.length);
    }

    @Test
    public void dashSplitTest() {
        LineSplitter lineSplitter = new LineSplitter();
        String[] problems = {"11-22", "95-115", "998-1012"};
        String[][] result = {
            lineSplitter.splitDash(problems[0]),
            lineSplitter.splitDash(problems[1]),
            lineSplitter.splitDash(problems[2])
        };

        assertEquals("11", result[0][0]);
        assertEquals("22", result[0][1]);
        assertEquals("95", result[1][0]);
        assertEquals("115", result[1][1]);
        assertEquals("998", result[2][0]);
        assertEquals("1012", result[2][1]);
    }
}
