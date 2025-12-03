public class CombinationLock {
    private int startingNumber;
    private int numTimesPassZero;

    public CombinationLock(int startingNumber) {
        this.startingNumber = startingNumber;
        this.numTimesPassZero = 0;
    }

    public void accept(Rotation rotation) {
        startingNumber = rotation.doRotation(startingNumber);
        if (startingNumber == 0) {
            numTimesPassZero += 1;
        }
    }

    public void altAccept(Rotation rotation) {
        numTimesPassZero += rotation.getZerosEncountered(startingNumber);
        startingNumber = rotation.doRotation(startingNumber);
    }

    @Override
    public String toString() {
        return String.format("Number: %d, PassZero: %d", startingNumber, numTimesPassZero);
    }

    public int getNumber() {
        return startingNumber;
    }
}
