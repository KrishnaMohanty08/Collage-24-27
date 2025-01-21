import java.util.*;
class Student{
    Scanner s= new Scanner(System.in);

    int roll_no;
    String name;
    float cgpa;

    Student(){
        System.out.println("Enter the roll_no.");
        roll_no=s.nextInt();
        System.out.println("Enter the name:");
        name=s.next();
        System.out.println("Enter the cgpa");
        cgpa=s.nextInt();
    }
    public float getCgpa(){
        return cgpa;
    }
    public String getName(){
        return name;
    }
}
public class student_5386{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n=sc.nextInt();

        Student[] student=new Student[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the details for the student"+(i+1));
            student[i]=new Student();
        }
        float lowestCgpa =Float.MAX_VALUE;
        String lowestCgpaStudentName="";

        for(int i=0;i<student.length;i++){
            if(student[i].getCgpa()<lowestCgpa){
                lowestCgpa=student[i].getCgpa();
                lowestCgpaStudentName=student[i].getName();
            }
        }
        System.out.println("Student with lowest CGPA: "+lowestCgpaStudentName+"with CGPA"+lowestCgpa);
        
    }
}