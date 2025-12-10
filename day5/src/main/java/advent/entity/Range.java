package advent.entity;

public class Range implements Comparable<Range>{
    public long start;
    public long end;

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public boolean inRange(long id) {
        return start <= id && id <= end;
    }

    public long getDist() {
        return end - start;
    }

    public boolean canMerge(Range other) {
        return end >= other.start && other.end >= start;
    }

    public Range merge(Range other) {
        assert canMerge(other) : String.format("Cannot merge %s with %s", this, other);

        return new Range(Math.min(start, other.start), Math.max(end, other.end));
    }


    @Override
    public String toString() {
        return String.format("(%d, %d)", start, end);
    }

    @Override
    public int compareTo(Range other) {
        // return Long.compare(getDist(), other.getDist());
        return Long.compare(start, other.start);
    }
}
