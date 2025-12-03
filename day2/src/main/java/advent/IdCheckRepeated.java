package advent;

public class IdCheckRepeated implements IDigitCheck{
    public boolean splitInGroups(String digits, int groupsOf, int howMany) {
        String[] groups = new String[howMany];

        for (int groupI = 0; groupI < howMany; groupI++) {
            var group = digits.substring(groupI * groupsOf, (groupI+1)*groupsOf);
            groups[groupI] = group;
        }

        String groupA;
        String groupB = groups[0];

        for (String group : groups) {
            groupA = groupB;
            groupB = group;
            if (!groupA.equals(groupB)) {
                return false;
            }
        }
        
        return true;
    }


    @Override
    public boolean isDigitsRepeated(String numbers) {
        for (int i = 1; i < numbers.length(); i++) {
            if (numbers.length() % i == 0) {
                boolean isRepeating = splitInGroups(numbers, i, Math.floorDiv(numbers.length(), i));
                if (isRepeating) {
                    return true;
                }
            }
        }

        return false;
    }
    
}
