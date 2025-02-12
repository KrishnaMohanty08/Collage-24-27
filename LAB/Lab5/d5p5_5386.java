import General.Employee;
import Marketing.Sales;
import java.util.*;

public class d5p5_5359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee ID and employee name:");
        int empid = sc.nextInt();
        sc.nextLine();
        String ename = sc.nextLine();
        System.out.println("Enter the basic salary:");
        double basic = sc.nextDouble();
        
        Sales salesPerson = new Sales(empid, ename, basic);
        double totalEarnings = salesPerson.earnings();
        
        System.out.println("The emp id of the employee is " + salesPerson.getEmpid());
        System.out.println("The total earning is " + totalEarnings);
      
    }
}