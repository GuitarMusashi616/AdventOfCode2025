package advent;

import java.util.ArrayList;
import java.util.List;

public class IdSum {
    private IDigitCheck idCheck;
    private List<Long> invalidIds = new ArrayList<Long>();

    public IdSum(IDigitCheck idCheck) {
        this.idCheck = idCheck;
    }

    public void process(String id) {
        if (idCheck.isDigitsRepeated(id)) {
            try {
                invalidIds.add(Long.parseLong(id));
            } catch (NumberFormatException e) {
                System.out.println(id.toString() + " is not a number");
                System.out.println(e);
            }
        }
    }

    public void process(long id) {
        String strId = String.valueOf(id);
        if (idCheck.isDigitsRepeated(strId)) {
            invalidIds.add(id);
        }
    }

    public long getTotal() {
        long total = 0;
        for (long number : invalidIds) {
            total += number;
        }
        return total;
    }

    @Override
    public String toString() {
        long total = getTotal();
        return String.format("Total: %d%nInvalid Ids: %s", total, invalidIds);
    }
}
