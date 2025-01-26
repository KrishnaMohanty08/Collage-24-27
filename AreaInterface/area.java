import java.util.*;

interface Area{
    void findArea();
}
class Triangle implements Area{
    double dim1;
    double dim2;
    Triangle(){
        this.dim1=0;
        this.dim2=0;
    }
    Triangle(double side1,double side2){
        dim1=side1;
        dim2=side2;
    }
    public void findArea(){
        double area=0.5*this.dim1*this.dim2;
        System.out.println("The Area of triangle is :"+ area);
    }
}
class Rectangle implements Area{

    double dim1;
    double dim2;
    Rectangle(){
        this.dim1=0;
        this.dim2=0;
    }
    Rectangle(double side1,double side2){
        dim1=side1;
        dim2=side2;
    }
    public void findArea(){
        double area=0.5f*this.dim1*this.dim2;
        System.out.println("The Area of triangle is :"+ area);
    }
}
public class area{
    public static void main(String[] args) {
        Area A;
        A =new Triangle(0.2,6.9);
        A.findArea();
        
        Triangle t =new Triangle();
        t.findArea();

        A =new Rectangle();
        A.findArea();
        
    }
}