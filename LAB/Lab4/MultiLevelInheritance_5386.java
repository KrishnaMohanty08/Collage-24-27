import java.util.Scanner;

class Plate_5359 {
    double length, width;

    Plate_5359(double l, double w) {
        length = l;
        width = w;
        System.out.println("Plate Constructor: Length = " + length + ", Width = " + width);
    }
}

class Box_5359 extends Plate_5359 {
    double height;

    Box_5359(double l, double w, double h) {
        super(l, w);
        height = h;
        System.out.println("Box Constructor: Height = " + height);
    }
}

class WoodBox_5359 extends Box_5359 {
    double thickness;

    WoodBox_5359(double l, double w, double h, double t) {
        super(l, w, h);
        thickness = t;
        System.out.println("WoodBox Constructor: Thickness = " + thickness);
    }
}

public class MultiLevelInheritance_5359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length, width, height, and thickness:");
        double l = sc.nextDouble(), w = sc.nextDouble(), h = sc.nextDouble(), t = sc.nextDouble();

        WoodBox_5359 woodBox = new WoodBox_5359(l, w, h, t);
    }
}
