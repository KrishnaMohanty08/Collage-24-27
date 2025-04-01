
class Q{
    int n;
    boolean flag=false;

    synchronized void put(int p){
        if(flag){
            try{
                wait();
            }catch(Exception e){
                System.out.println("Error in production");
            }
        }
        n=p;
        System.out.println("Put"+n);
        notify();
    }
    synchronized int get(){
        if(!flag){
            try{
                wait();
            }catch(Exception e){
                System.out.println("Error in production");
            }
        }
        System.out.println("Got:"+n);
        flag=false;
        notify();
        return n;
        
    }
    
}
class Producer implements Runnable {
    Q x;
    Thread t;
    Producer(Q y){
        x=y;
        t=new Thread(this);
    }
    public void run(){
        int i =0;
        while(true){
            x.put(i++);
        }
    }
}
class Consumer implements Runnable{
    Q x;
    Thread t;
    Consumer(Q y){
        x=y;
        t=new Thread(this);
    }
    public void run(){
        while(true){
            x.get();
        }
    }
}
public class prodConsu {
    public static void main(String[] args) {
        Q q=new Q();
        Producer p=new Producer(q);
        Consumer c=new Consumer(q);
        p.t.start();
        c.t.start();
    }
}
