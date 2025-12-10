package advent;

import java.util.List;

public class CountNeighbors {
    private final IRollAtRowCol rollGrid;

    public CountNeighbors(IRollAtRowCol rollGrid) {
        this.rollGrid = rollGrid;
    }

    public void removeRollsFrom(List<Coord> coords) {
        for (Coord coord : coords) {
            rollGrid.removeRollAt(coord.row, coord.col);
        }
    }

    public int rollsWithAdjacentLessThan(int n) {
        int count = 0;
        for (int i = 0; i < rollGrid.getMaxRows(); i++) {
            for (int j = 0; j < rollGrid.getMaxCols(); j++) {
                if (rollGrid.hasRollAt(i, j) && numNeighbors(i, j) < n) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public int rollsWithAdjacentLessThan(int n, List<Coord> saveCoords) {
        int count = 0;
        for (int i = 0; i < rollGrid.getMaxRows(); i++) {
            for (int j = 0; j < rollGrid.getMaxCols(); j++) {
                if (rollGrid.hasRollAt(i, j) && numNeighbors(i, j) < n) {
                    count += 1;
                    saveCoords.add(new Coord(i, j));
                }
            }
        }
        return count;
    }

    public int numNeighbors(int row, int col) {
        int count = 0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j <=col+1; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (rollGrid.hasRollAt(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
