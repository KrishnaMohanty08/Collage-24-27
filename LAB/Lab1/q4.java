import java.util.Scanner;

public class q4 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int n=sc.nextInt();
        System.out.print("The reverse of the number is:");
        int a=0;
        while(n!=0)
        {
            a=(a*10)+(n%10);
            n=n/10;
        }
        System.out.print(a);
    }
}
