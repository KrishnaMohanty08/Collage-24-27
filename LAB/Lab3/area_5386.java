import java.util.Scanner;

class Area {
    
    double area(double radius) {
        return 3.14*radius*radius;
    }
    double area(double base, double height) {
        return 0.5*base*height;
    }
    double area(int side) {
        return side*side;
    }
}

public class area_5386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Area calculator = new Area();

        System.out.println("Choose the shape to calculate the area:");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Square");
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                double circleArea = calculator.area(radius);
                System.out.printf("The area of the circle is: %.2f\n", circleArea);
                break;

            case 2:
                System.out.print("Enter the base of the triangle: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = scanner.nextDouble();
                double triangleArea = calculator.area(base, height);
                System.out.printf("The area of the triangle is: %.2f\n", triangleArea);
                break;

            case 3:
                System.out.print("Enter the side length of the square: ");
                int side = scanner.nextInt();
                double squareArea = calculator.area(side);
                System.out.printf("The area of the square is: %.2f\n", squareArea);
                break;

            default:
                System.out.println("Invalid choice! Please select 1, 2, or 3.");
                break;
        }

    }
}