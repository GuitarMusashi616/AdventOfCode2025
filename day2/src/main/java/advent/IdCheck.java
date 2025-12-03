package advent;

public class IdCheck implements IDigitCheck {
    @Override
    public boolean isDigitsRepeated(String numbers) {
        if (numbers.length() % 2 == 1) {
            return false;
        }

        String firstHalf = numbers.substring(0, numbers.length()/2);
        String secondHalf = numbers.substring(numbers.length()/2);

        return firstHalf.equals(secondHalf);
    }
}
