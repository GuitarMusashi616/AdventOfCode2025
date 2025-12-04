package advent;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Joltage2 implements IJoltage {
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

    public int[] getMax(List<Integer> batteryBank) {
        int[] result = {-1, -1};
        try {
            int digit1 = batteryBank
                .stream()
                .limit(batteryBank.size() - 1)
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
