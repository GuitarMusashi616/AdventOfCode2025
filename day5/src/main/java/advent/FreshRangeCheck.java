package advent;

import java.util.ArrayList;
import java.util.List;

import advent.entity.Data;
import advent.entity.Range;

public class FreshRangeCheck {
    public static List<Boolean> processData(Data data) {
        // var result = new ArrayList<Boolean>();
        // for (var number: data.numbers) {
        //     data.isValid(number);
        // }
        // return result;
        List<Boolean> result = data.numbers.stream().map(x -> data.isValid(x)).toList();
        return result;
    }
}
