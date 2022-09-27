package fileWork;

import java.io.FileInputStream;
import java.io.IOException;

public class ioTool {
    public String readFile(String filename) {
        try (FileInputStream fIS = new FileInputStream(filename)) {
            byte[] file = new byte[fIS.available()];
            fIS.read(file);
            return new String(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
