package advent.sliding;

import java.util.Iterator;
import java.util.List;

public class SlidingWindow implements Iterable<Integer> {
    public static int[][] fromLinesRaw(String[] lines) {
        int[][] result = new int[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int length = line.length();
            result[i] = new int[length];
            for (int j = 0; j < length; j++) {
                char chr = line.charAt(j);
                int num = chr - '0';
                result[i][j] = num;
            }
        }
        return result;
    }

    public static int[][] fromLinesRaw(List<String> lines) {
        String[] stringArr = lines.toArray(new String[lines.size()]);
        return fromLinesRaw(stringArr);
    }

    public static int[] fromStringRaw(String line) {
        int[] result = new int[line.length()];
        for (int j = 0; j < line.length(); j++) {
            char chr = line.charAt(j);
            int num = chr - '0';
            result[j] = num;
        }
        return result;
    }

    public static SlidingWindow fromString(String lines, int windowSize) {
        return new SlidingWindow(fromStringRaw(lines), windowSize);
    }

    public static void printRaw(int[][] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.printf("%d", intArr[i][j]);
            }
            System.out.println();
        }
    }

    private final int[] nums;
    private int windowSize;

    public SlidingWindow(int[] nums, int windowSize) {
        this.nums = nums;
        this.windowSize = windowSize;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SlidingMaxIterator(nums, windowSize);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    public int get(int index) {
        return nums[index];
    }

    public void printProcess() {
        for (int maxIndex : this) {
            System.out.printf("Next Max: %d (%d)%n", get(maxIndex), maxIndex);
        }
    }
}
