package advent.entity;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public List<Range> ranges;
    public List<Long> numbers;
    
    public Data(List<Range> ranges, List<Long> numbers) {
        this.ranges = ranges;
        this.numbers = numbers;
    }

    public boolean isValid(long number) {
        for (Range range : ranges) {
            if (range.inRange(number)) {
                return true;
            }
        }
        return false;
    }

    public static Data  fromStringList(List<String> strings) {
        List<Range> ranges = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();

        for (String line : strings) {
            line = line.strip();
            if (line.contains("-")) {
                String[] ab = line.split("-");
                ranges.add(new Range(Long.parseLong(ab[0]), Long.parseLong(ab[1])));
            } else if (line.length() > 0) {
                numbers.add(Long.parseLong(line.strip()));
            }
        }

        return new Data(ranges, numbers);
    }
    @Override
    public String toString() {
        return String.format("ranges: %s%n%nnumbers: %s", ranges, numbers);
    }
}
