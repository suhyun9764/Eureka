package ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TryWithResource {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("readme.md");
//            fileInputStream.
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
