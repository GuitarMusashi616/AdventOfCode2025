package advent;

import java.util.ArrayList;
import java.util.List;

public class LineSplitter {
    public String[] splitCommas(String content) {
        return content.split(",");
    }

    public String[] splitDash(String ids) {
        return ids.split("-");
    }

    public List<Long> iterDash(String ids) {
        List<Long> result = new ArrayList<Long>();
        String[] splitStrs = splitDash(ids);
        assert splitStrs.length == 2 : "Too many ids in " + ids.toString();
        try {
            long start = Long.parseLong(splitStrs[0].strip());
            long end = Long.parseLong(splitStrs[1].strip());
            for (long i = start; i <= end; i++) {
                result.add(i);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.printf("Cant parse start: %s or end: %s%n", splitStrs[0], splitStrs[1]);
        }

        return result;
    }
}
