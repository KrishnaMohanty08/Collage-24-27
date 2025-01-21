import java.util.*;

class Rectangle{
    Scanner s=new Scanner(System.in);

    double length=0;
    double breadth=0;
    Rectangle (){
        System.out.print("Enter the length :");
        this.length=s.nextDouble();
        System.out.print("Enyter the breadth :");
        this.breadth=s.nextDouble();
    }
    Rectangle(double length ,double breadth){
        this.length=length;
        this.breadth=breadth;
    }
    double area(){
        return this.length*this.breadth;
    }
}
public class rectA_5386{
    public static void main(String args[]){
        Rectangle rect1 =new Rectangle(34.1,7);

        System.out.print("The area of rectangle is :"+rect1.area());
    }
}