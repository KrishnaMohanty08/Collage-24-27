import java.util.*;
class rectangle{

	int length;
	int breadth;

	rectangle(int length,int breadth){
		this.length=length;
		this.breadth=breadth;
	}
	void read(){
	System.out.println("length of the rectangle ="+length);
	System.out.println("breadth of the rectangle ="+breadth);
	}
	int  calculatearea(){
		int area=length*breadth;
		return area;
	}
	int calculateper(){
		int perimeter=2*(length+breadth);
		return perimeter;
	}
	void display(){
		System.out.println("area of the rectangle ="+ calculatearea() +" \nperimeter rof the rectangle ="+ calculateper() );
	}
}
public class demoRect_5386{
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length,breadth  of the rectangle: ");

        int length = in.nextInt();
        int breadth = in.nextInt();

        rectangle  ob1 = new rectangle(length,breadth);
        ob1.read();
		ob1.display();
	}
}