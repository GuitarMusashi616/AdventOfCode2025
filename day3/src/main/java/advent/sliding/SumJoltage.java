package advent.sliding;

public class SumJoltage {
    private long sum = 0;

    public long getSum() {
        return sum;
    }

    public void process(String line, int windowSize) {
        int[] maxes = getMaxes(line, windowSize);
        sum += getLong(maxes);
    }

    public void process(String line, int windowSize, boolean verbose) {
        int[] maxes = getMaxes(line, windowSize);
        long number = getLong(maxes);
        if (verbose) {
            System.out.println(number);
        }
        sum += number;
    }

    public int[] getMaxes(String line, int windowSize) {
        int[] indices = new int[windowSize];
        int i = 0;
        SlidingWindow window = SlidingWindow.fromString(line, windowSize);
        for (int maxIter : window) {
            indices[i] = window.get(maxIter);
            i++;
        }
        return indices;
    }

    public long getLong(int[] maxes) {
        long number = 0;
        for (int i = 0; i < maxes.length; i++) {
            number += maxes[i] * Math.pow(10, maxes.length - i - 1);
        }
        return number;
    }
}
