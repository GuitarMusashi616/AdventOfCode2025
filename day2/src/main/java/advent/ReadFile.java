package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFile {
    public void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
            return;
        }
    }
    
}
