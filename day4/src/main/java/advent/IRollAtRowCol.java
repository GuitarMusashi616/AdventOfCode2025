package advent;

public interface IRollAtRowCol {
    boolean hasRollAt(int row, int col);
    int getMaxRows();
    int getMaxCols();
    void removeRollAt(int row, int col);
}
