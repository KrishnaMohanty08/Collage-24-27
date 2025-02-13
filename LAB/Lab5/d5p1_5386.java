import java.util.*;

abstract class Student
 {
    protected int rollNo;
    protected long regNo;

    
    public void getInput() 
{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Roll No: ");
        rollNo = in.nextInt();
        System.out.println("Enter Registration No: ");
        regNo = in.nextLong();
    }

   
    public abstract void course();
}
class Kiitian extends Student 
{
   
    public void course() 
{
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }

    
    public void displayDetails() 
{
        System.out.println("Roll No - " + rollNo);
        System.out.println("Registration No - " + regNo);
        course(); 
    }
}


public class d5p1_5386
  {
    public static void main(String[] args)
 {
        
        Kiitian kiitian = new Kiitian();
        
                kiitian.getInput();
        
              kiitian.displayDetails();
    }
}
