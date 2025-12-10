package advent.entity;

public class Replace {
    public int i;
    public int j;
    public Range replaceWith;

    public Replace(int i, int j, Range replaceWith) {
        this.i = i;
        this.j = j;
        this.replaceWith = replaceWith;
    }

    @Override
    public String toString() {
        return String.format("del %s, del %s, replaceWith: %s", i, j, replaceWith);
    }
}
