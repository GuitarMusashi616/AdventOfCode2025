public class ComboLock {
    private int number;
    private int zerosEncountered = 0;

    public ComboLock(int initial) {
        this.number = initial;
        this.zerosEncountered = 0;
    }

    public void decrement() {
        if (number == 0) {
            number = 99;
            return;
        }
        if (number == 1) {
            zerosEncountered += 1;
        }
        number -= 1;
    }

    public void increment() {
        if (number == 99) {
            number = 0;
            zerosEncountered += 1;
            return;
        }
        number += 1;
    }

    public void apply(Rotation rotation) {
        if (rotation.getDir() == RotationDir.LEFT) {
            for (int i = 0; i < rotation.getMag(); i++) {
                decrement();
            }
            return;
        }
        for (int i = 0; i < rotation.getMag(); i++) {
            increment();
        }
        return;
    }

    @Override
    public String toString() {
        return String.format("Number: %d, Zeros: %d", number, zerosEncountered);
    }
}
