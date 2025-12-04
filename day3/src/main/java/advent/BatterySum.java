package advent;

public class BatterySum {
    private long total = 0;
    private final IJoltage jolt;

    public BatterySum(IJoltage jolt) {
        this.jolt = jolt;
    }

    public long getSum(int[] batteries) {
        int length = batteries.length;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            int mult = length-i-1;
            sum += batteries[i]*Math.pow(10, mult);
        }
        return sum;
    }

    public void process(String batteryBank) {
        int[] batteries = jolt.getMax(batteryBank);
        long sum = getSum(batteries);
        System.out.printf("Result: %d%n", sum);
        total += sum;
    }

    @Override
    public String toString() {
        return String.format("Total: %d", total);
    }
}
