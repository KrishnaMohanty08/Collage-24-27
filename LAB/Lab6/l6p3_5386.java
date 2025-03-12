import java.util.*;

class NegativeNumberException extends Exception {
    NegativeNumberException() {
        super();
    }
    String tostring(){
            return "hello";
        }
    
    }


class Input {
    void processInput(Scanner sc) throws NegativeNumberException {
        while (true) {
            System.out.print("Enter a number : ");

            int num = sc.nextInt();
            
            if (num > 0) {
                throw new NegativeNumberException();
            } else {
                System.out.println("Double value: " + (num * 2));
            }
        }
    }
}

public class l6p3_5386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input in = new Input();
        
        try {
            in.processInput(sc);
        } catch (NegativeNumberException e) {
            System.out.println(e.tostring());
        } finally {
            System.out.println("done");
        }
    }
}
