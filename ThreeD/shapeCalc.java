import java.util.*;
interface twoD{
    double findArea();//calc surface area
}
interface threeD extends twoD{
    double findVolume();//calc volume 
}
class Cuboid implements threeD{
    double dim1;
    double dim2;
    double dim3;

    Cuboid(double length,double breadth,double height) {
        this.dim1=length;
        this.dim2=breadth;
        this.dim3=height;
    }
    public double findArea(){
        return 2*((dim1*dim2)+(dim2*dim3)+(dim3*dim1));
    }
    public double findVolume(){
        return dim1*dim2*dim3;
    }

}
class Cube implements threeD{
    double dim1;

    Cube(){

    }
    Cube(double length) {
        this.dim1=length;
    }
    public double findArea(){
        return 6*dim1;
    }
    public double findVolume(){
        return dim1*dim1*dim1;
    }
}
public class shapeCalc {
    public static void main(String[] args) {
        threeD L=new Cuboid(3,3,3);
        System.out.println("Volume of Cuboid by IRV :"+L.findVolume());
        System.out.println("Surface Area of Cuboid by IRV :"+L.findArea());
        
        
        Cuboid A=new Cuboid(2,2,2);
        System.out.println("Volume of Cuboid by OB-A :"+A.findVolume());
        System.out.println("Surface Area of Cuboid by OB-A :"+A.findArea());
        

        Cube B=new Cube(3);
        System.out.println("Volume of Cube by OB-B :"+B.findVolume());
        System.out.println("Surface Area of Cube by OB-B :"+B.findArea());
    }
}
