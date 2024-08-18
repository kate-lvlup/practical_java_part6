package jom.com.softserve.s6.task3;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyUtils {
    public static void writeFile(String filename, String text) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            for (char ch : text.toCharArray()) {
                //The string must be right-aligned within 7 characters. If the string is shorter
                // than 7 characters, it will be padded with spaces on the left until it reaches 7 characters.
                String binaryString = String.format("%7s", Integer.toBinaryString(ch)).replace(' ', '0');
                for (char bit : binaryString.toCharArray()) {
                    fos.write(bit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
