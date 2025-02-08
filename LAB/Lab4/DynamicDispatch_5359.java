import java.util.*;
class Apple_5359 {
    public void show() {
        System.out.println("This is Apple.");
    }
}

class Banana_5359 extends Apple_5359 {
    public void show() {
        System.out.println("This is Banana.");
    }
}

class Cherry_5359 extends Apple_5359 {
    public void show() {
        System.out.println("This is Cherry.");
    }
}

public class DynamicDispatch_5359 {
    public static void main(String[] args) {
        Apple_5359 ob;

        ob = new Apple_5359();
        ob.show();

        ob = new Banana_5359();
        ob.show();

        ob = new Cherry_5359();
        ob.show();
    }
}