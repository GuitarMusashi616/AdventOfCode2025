public class Rotation {
    private final RotationDir dir;
    private final int magnitude;

    public Rotation(RotationDir dir, int magnitude) {
        this.dir = dir;
        this.magnitude = magnitude;
    }

    public int getZerosEncountered(int startingNumber) {
        if (this.dir == RotationDir.LEFT) {
            return Math.abs(Math.floorDiv(startingNumber - this.magnitude, 100));
        }
        
        return Math.abs(Math.floorDiv(startingNumber + this.magnitude, 100));
    }


    public int doRotation(int startingNumber) {
        if (this.dir == RotationDir.LEFT) {
            return Math.floorMod(startingNumber - this.magnitude, 100);
        }
        
        return Math.floorMod(startingNumber + this.magnitude, 100);
    }

    public static Rotation parseFrom(String parseStr) {
        assert parseStr != null && parseStr != "" : "parseStr must be a valid string: " + parseStr.toString();

        char firstChar = parseStr.toLowerCase().charAt(0);

        assert firstChar == 'l' || firstChar == 'r': "first char of parseStr must be L or R: " + firstChar;

        String numStr = parseStr.substring(1);
        int num = -1;

        try {
            num = Integer.parseInt(numStr);
        } catch(NumberFormatException e) {
            assert false : "parseStr must contain a valid number after first letter: " + parseStr.toString();
        }
        
        if (firstChar == 'l') {
            return new Rotation(RotationDir.LEFT, num);
        }

        return new Rotation(RotationDir.RIGHT, num);
    }

    public RotationDir getDir() {
        return this.dir;
    }

    public int getMag() {
        return this.magnitude;
    }
}