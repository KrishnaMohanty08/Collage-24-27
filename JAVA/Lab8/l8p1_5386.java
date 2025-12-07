import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class l8p1_5386 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try (FileWriter student=new FileWriter("hello.txt")){

            System.out.println("Enter the roll no.");
            int rollNo=sc.nextInt();
            student.write("RollNo:"+rollNo);

            System.out.println("Enter the Name");
            String name=sc.next();
            student.write("\nName:"+name);
            
            System.out.println("Enter the Subject");
            String subject=sc.next();
            student.write("\nSubject:"+subject);

            System.out.println("Enter the Marks");
            int marks=sc.nextInt();
            student.write("\nMarks:"+marks);

            
        }catch(IOException e){
            System.out.println("input error occured" +e.getMessage());
        }
        try (Scanner student = new Scanner(new File("hello.txt"))) {
            while (student.hasNextLine()) {
                String data = student.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading: " + e.getMessage());
        }
    }

}
