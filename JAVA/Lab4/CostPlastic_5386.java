import java.util.Scanner;
class Plastic2D_5359 {
    double length, width;

    public void inputDimensions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and width of the sheet:");
        length = sc.nextDouble();
        width = sc.nextDouble();
    }

    public double calculateCost_5359() {
        return length * width * 40;
    }
}

class Plastic3D_5359 extends Plastic2D_5359 {
    double height;
    public void inputDimensions() {
        super.inputDimensions();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height of the box:");
        height = sc.nextDouble();
    }

    public double calculateCost_5359() {
        return length * width * height * 60; 
    } 
}

public class CostPlastic_5359 {
    public static void main(String[] args) 
	{
        Plastic3D_5359 plastic = new Plastic3D_5359();
        plastic.inputDimensions();
        double cost_5359 = plastic.calculateCost_5359();
        System.out.println("The cost of plastic is: Rs " + cost_5359);
    }
}