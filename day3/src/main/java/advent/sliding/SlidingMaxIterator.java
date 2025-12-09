package advent.sliding;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SlidingMaxIterator implements Iterator<Integer> {
    private int[] numbers;
    private int howMany;
    private int curr;

    public SlidingMaxIterator(int[] numbers, int howMany) {
        this.numbers = numbers;
        this.howMany = howMany;
        this.curr = 0;
    }

    public int getMaxIndex(int start, int end) {
        int largestDigit = -1;
        int largestIndex = -1;
        for (int i = start; i < end; i++) {
            if (numbers[i] > largestDigit) {
                largestDigit = numbers[i];
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    @Override
    public boolean hasNext() {
        // return numbers.length-howMany-1 < numbers.length;
        return howMany > 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int index = getMaxIndex(curr, numbers.length - howMany + 1);
        curr = index+1;
        howMany -= 1;
        return index;
    }
}
