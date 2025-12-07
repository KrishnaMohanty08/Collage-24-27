import java.util.*;
interface Salary 
{
    double earnings();  
    double deductions();  
    double bonus(); 
}

class Manager implements Salary {
    protected double basicSalary;

        Manager(double basicSalary) {
        this.basicSalary = basicSalary;
    }

   
    public double earnings() {
        double da = 0.80 * basicSalary;  
        double hra = 0.15 * basicSalary;  
        return basicSalary + da + hra;
    }

        public double deductions() {
        return 0.12 * basicSalary; 
    }

    
    public double bonus() {
        return 0.0; 
    }
}

class Substaff extends Manager {
    
    Substaff(double basicSalary) {
        super(basicSalary);
    }

       public double bonus() {
        return 0.50 * basicSalary;  
    }
}

public class d5p3_5386
{
    public static void main(String[] args)
 {        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");
        double basicSalary = in.nextDouble();

        Substaff substaff = new Substaff(basicSalary);

        double earnings = substaff.earnings();
        double deductions = substaff.deductions();
        double bonus = substaff.bonus();

        System.out.println("Earnings: " + earnings);
        System.out.println("Deductions: " + deductions);
        System.out.println("Bonus: " + bonus);
    }
}
