package string.demo;

import java.io.FileInputStream;
import java.util.Scanner;

public class FileToString {
    public static void main(String[] args) throws Exception{
        try (
                FileInputStream fis = new FileInputStream("C:\\Users\\Pedagog\\test.txt");
                Scanner scanner = new Scanner(fis);
        ) {
            scanner.useDelimiter("[,]");
            StringBuffer sb = new StringBuffer();
            while (scanner.hasNext()) {
                sb.append(scanner.next());
                sb.append(" ");
            }
            System.out.println(String.format("Result is %s", sb.toString()));
        }
    }
}
