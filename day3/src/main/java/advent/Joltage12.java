package advent;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Joltage12 implements IJoltage {
    @Override
    public int[] getMax(String batteryBank) {
        List<Integer> newBank = new ArrayList<>();
        for (int i = 0; i < batteryBank.length(); i++) {
            String numStr = batteryBank.substring(i, i+1);
            int num = Integer.parseInt(numStr);
            newBank.add(num);
        }
        return getMax(newBank);
    }
    public int largestFrom(List<Integer> batteryBank, int start, int end) {
        // gets the largest from slice [start, end)
        int largest = -1;
        int index = -1;
        for (int i = start; i < end; i++) {
            if (batteryBank.get(i) > largest) {
                largest = batteryBank.get(i);
                index = i;
            }
        }
        return index;
    }

    public int[] getMax(List<Integer> batteryBank) {
        int[] result = new int[12];

        for (int i = 0; i < 12; i++) {
            int start = 0;
            int end = batteryBank.size() - 11;
            int index = largestFrom(batteryBank, start, end);
            int largest = batteryBank.get(index);
            result[i] = largest;
        }

        try {
            int digit1 = batteryBank
                .stream()
                .limit(batteryBank.size() - 11)
                .max(Integer::compare)
                .orElseThrow();

            result[0] = digit1;

            int index1 = batteryBank.indexOf(digit1);
            int digit2 = batteryBank
                .stream()
                .skip(index1+1)
                .max(Integer::compare)
                .orElseThrow();

            result[1] = digit2;

        } catch (NoSuchElementException e) {
            System.out.println(e);
            System.out.println("Cant find the biggest int in the first n-1 elemnts of battery bank");
        }
        return result;
    }
}
