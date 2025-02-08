
interface Motor
 {
   
    int capacity = 5; 
    void run();

   
    void consume();
}
class WashingMachine implements Motor {
        public void run() {
        System.out.println("Washing machine is running.");
    }

        public void consume() {
        System.out.println("Washing machine is consuming power.");
    }

    
    public void displayCapacity() {
        System.out.println("Capacity of the motor is " + capacity + " horsepower.");
    }
}

public class d5p2_5359{
    public static void main(String[] args) {
                WashingMachine wm = new WashingMachine();

                wm.displayCapacity();

        
        wm.run();
        wm.consume();
    }
}
