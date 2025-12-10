package advent;

import java.util.HashSet;
import java.util.Set;

import advent.entity.Data;
import advent.entity.Range;

public class FreshCheck implements IFresh{
    private Set<Long> freshNums = new HashSet<>();

    @Override
    public boolean isFresh(long id) {
        return freshNums.contains(id);
    }

    @Override
    public void setFresh(long id) {
        freshNums.add(id);
    }

    public void setFresh(long start, long end) {
        for (long i = start; i <= end; i++) {
            setFresh(i);
        }
    }

    public void processData(Data data) {
        for (Range range : data.ranges) {
            setFresh(range.start, range.end);
        }
        for (var number: data.numbers) {
            printCheck(number);
        }
    }



    public void printCheck(long id) {
        if (isFresh(id)) {
            System.out.printf("%d is fresh%n", id);
        } else {
            System.out.printf("%d is spoiled%n", id);
        }
    }
}
