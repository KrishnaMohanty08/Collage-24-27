import java.util.*;

class Substract{
    Scanner s=new Scanner(System.in);

    double a;
    double b;
    Substract (){
        System.out.println("Enter the numbers:");
        this.a=s.nextFloat();
        this.b=s.nextFloat();
        //float c=a-b;
    }
    Substract(double x,double y){
        this.a=x;
        this.b=y;
        double c=a-b;
    }
    void display(){
        System.out.println("The difference between two is :"+(a-b));
    }

}
public class subs_5386{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        Substract diff=new Substract(87.3,45.1);
        //diff.display();

        Substract dif=new Substract();
        dif.display();

    }
}