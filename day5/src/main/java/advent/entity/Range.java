package advent.entity;

public class Range {
    public long start;
    public long end;

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public boolean inRange(long id) {
        return start <= id && id <= end;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", start, end);
    }
}
