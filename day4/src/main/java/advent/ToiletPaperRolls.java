package advent;

import java.util.List;

public class ToiletPaperRolls implements IRollAtRowCol {
    private final List<String> rolls;

    public ToiletPaperRolls(List<String> rolls) {
        this.rolls = rolls;
    }

    public boolean isInbounds(int row, int col) {
        if (row < 0 || row >= rolls.size()) {
            return false;
        }
        String rowStr = rolls.get(row);
        if (col < 0 || col >= rowStr.length()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasRollAt(int row, int col) {
        if (!isInbounds(row, col)) {
            return false;
        }
        String rowStr = rolls.get(row);
        return rowStr.charAt(col) == '@';
    }

    @Override
    public int getMaxRows() {
        return rolls.size();
    }

    @Override
    public int getMaxCols() {
        return rolls.get(0).length();
    }

    @Override
    public void removeRollAt(int row, int col) {
        if (!isInbounds(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        String rowStr = rolls.get(row);
        String newRowStr = new StringBuilder(rowStr).replace(col, col+1, ".").toString();
        rolls.set(row, newRowStr);
    }
}
