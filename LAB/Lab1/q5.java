import java.util.Scanner;

public class q5 
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After swapping the numbers are:"+a+" "+b);
        
    }
    
}
