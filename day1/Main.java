import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        String filename = "input.txt";
        example1(filename);
    }

    public static void example1(String filename) throws IOException{
        List<String> lines = Files.readAllLines(Path.of(filename));

        int startingNumber = 50;
        ComboLock lock = new ComboLock(startingNumber);
        // System.out.println(lock.getNumber());

        for (String line : lines) {
            Rotation rot = Rotation.parseFrom(line);
            lock.apply(rot);
            System.out.println(line);
            System.out.println(lock);
        }
    }
}