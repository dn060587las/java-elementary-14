package string.demo;

import java.io.FileInputStream;
import java.util.Scanner;

public class StringDemo {

    private static String MESSAGE_TEMPLATE = "Hello  number is : %1$s string is : %2$d";

    public static void main(String[] args) throws Exception {
        String str = "string1";
        String str2 = "string1";
        System.out.println(str == str2); //expect true
        str = new String(str2);
        System.out.println(str == str2); //expect false
        System.out.println(str.intern() == str2); //expect true
        acceptString(str.intern());
        String str3 = str.concat("1212");
        str3 = str + "1212";
        String str4 = "Hello World World";
        System.out.println(str4.indexOf("World"));
        System.out.println(str4.endsWith("rld"));

        System.out.println(String.format(MESSAGE_TEMPLATE, "World", 1));
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Pedagog\\test.txt");) {
            Scanner scanner = new Scanner(fis);
            scanner.useDelimiter("[,]");
            while (scanner.hasNext()) {
                System.out.println(String.format("String from file %s", scanner.next().intern()));
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append("str1");
        sb.append("str2");
        sb.append("str3");
        sb.append("str4");
        String str5 = sb.toString();

        str5 = "str1" + "str2" + "str3" + "str4";

    }

    public static void acceptString(String str) {
        ///
    }
}
