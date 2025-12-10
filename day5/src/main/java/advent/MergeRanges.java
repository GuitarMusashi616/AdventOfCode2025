package advent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import advent.entity.Range;

public class MergeRanges {
    
    public static List<Range> mergeRanges(List<Range> ranges) {
        Collections.sort(ranges);

        List<Range> nextRound = new ArrayList<>();

        Range r1 = ranges.remove(0);
        while (!ranges.isEmpty()) {
            Range r2 = ranges.remove(0);
            if (r1.canMerge(r2)) {
                Range merged = r1.merge(r2);
                r1 = merged;
            } else {
                nextRound.add(r1);
                r1 = r2;
            }
        }
        nextRound.add(r1);
        return nextRound;
    }
}
