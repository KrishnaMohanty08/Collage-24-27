class CounterThread extends Thread {
    private int lowerRange, upperRange;

    public CounterThread(String name, int lowerRange, int upperRange) {
        super(name); 
        this.lowerRange = lowerRange;
        this.upperRange = upperRange;
    }

    public void run() {
        System.out.println("Thread - " + getName());
        for (int i = lowerRange; i <= upperRange; i++) {
            System.out.print(i + "\t");
            try {
                Thread.sleep(5); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
        System.out.println();
    }
}

public class l9p1_5386 {
    public static void main(String[] args) {

        CounterThread thread = new CounterThread("First", 10, 15);
        thread.start();
    }
}
