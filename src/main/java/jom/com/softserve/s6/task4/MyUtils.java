package jom.com.softserve.s6.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyUtils {

    public static String readFile(String filename) {
        StringBuilder binaryStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                binaryStringBuilder.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return binaryToString(binaryStringBuilder.toString());
    }

    private static String binaryToString(String binaryString) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < binaryString.length(); i += 7) {
            String byteString = binaryString.substring(i, Math.min(i + 7, binaryString.length()));
            int charCode = Integer.parseInt(byteString, 2);
            result.append((char) charCode);
        }

        return result.toString();
    }

}
