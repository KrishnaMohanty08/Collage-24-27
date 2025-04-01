import java.io.*;
import java.util.*;

class newThread implements Runnable {
    String name;
    Thread t;

    newThread(String n) {
        name = n;
        t = new Thread(this, n);
        System.out.println(t);
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("running of " + name + " " + i);
                Thread.sleep(100);
            }

        } catch (Exception e) {
            System.out.println("interrupted");
        }
    }

}

public class multiThread {
    public static void main(String[] args) {
        newThread one=new newThread("one");
        newThread two=new newThread("second");
        newThread three=new newThread("three");
        one.t.start();
        two.t.start();
        three.t.start();

        System.out.println(one.t.isAlive());
        System.out.println(two.t.isAlive());
        System.out.println(three.t.isAlive());

        try{
            one.t.join();
            two.t.join();
            three.t.join();
        }catch(Exception e){
            System.out.println("main thread interrupted");
        }
            

    }
}
