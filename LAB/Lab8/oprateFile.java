import java.util.*;
import java.io.*;

public class oprateFile {
    public static void main(String[] args) {

        // Writing to the file
        try (FileWriter myWriter = new FileWriter("hello.txt")) {
            myWriter.write("We are your friends\n");
            myWriter.write("of Class of section CSE 27\n");
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred while writing: " + e.getMessage());
        }

        // Reading from the file
        try (Scanner myReader = new Scanner(new File("hello.txt"))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }
    }
}