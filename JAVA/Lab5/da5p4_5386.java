import java.util.*;
interface Employee
{
void getdetails();
}
interface Manager extends Employee
{
void getDeptDetails();
}

class Head implements Manager
{
 private int empId;
 private String empName;
 private int deptId;
 private String deptname;

    public void getDetails() 
	{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter employee id= ");
        empId = in.nextInt();
        System.out.print("Enter employee name= ");
        empName = in.nextLine();
    }
	
	public void getDeptDetails()
	{
	Scanner in =new Scanner(System.in);
	System.out.println("Enter department id=");
	deptId=in.nextInt();
	System.out.println("Enter department name=");
	deptname=in.nextLine();
	}
	
	public void displayDetails() {
        System.out.println("Employee id: " + empId);
        System.out.println("Employee name: " + empName);
        System.out.println("Department id: " + deptId);
        System.out.println("Department name: " + deptname);
    }
}
public class da5p4_5359
{
    public static void main(String[] args) 
	{
    Head head = new Head();
    head.getDetails();
    head.getDeptDetails();
    head.displayDetails();
    }
}


	
	
	
