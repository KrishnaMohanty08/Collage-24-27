import java.util.*;
import java.io.*;

class newThread extends Thread{
    newThread(){
        super("Demo Thread");
        System.out.println("Child Thread"+this);
        this.start();
    }
    public void run(){
        try{
            for(int i =5;i>0;i--){
                System.out.println("Child Thread:"+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("child Thread is interuppted");
        }
        System.out.println("Child thread is exiting");
    }
}
public class thread {
    public static void main(String[] args) {
        new newThread();
        try{
            for(int i =5;i>0;i--){
                System.out.println("Main Thread"+i);
                Thread.sleep(5000);
            }
        }catch(InterruptedException e){
            System.out.println("main Thread is Exiting");
        }
    }
}
