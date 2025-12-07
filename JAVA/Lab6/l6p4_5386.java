import java.util.*;

class HrsException extends Exception {
    HrsException(){
        super();
    }
    public String toString(){
            return "Invalid hours! Must be between 0 and 24.";
        }
}
class MinException extends Exception {
    MinException(){
        super();
    }
    public String toString(){
        return "Invalid hours! Must be between 0 and 60.";
    }
}
class SecException extends Exception {
    SecException(){
        super();
    }
    public String toString(){
        return "Invalid hours! Must be between 0 and 60.";
    }
}
class Time {
    private int hours, minutes, seconds;
    
    public void setTime(int hours, int minutes, int seconds) throws HrsException, MinException, SecException {
        if (hours < 0 || hours > 24) {
            throw new HrsException();
        }
        if (minutes < 0 || minutes >= 60) {
            throw new MinException();
        }
        if (seconds < 0 || seconds >= 60) {
            throw new SecException();
        }
        
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public void displayTime() {
        System.out.printf("Time: %02d:%02d:%02d\n", hours, minutes, seconds);
    }
}

// Main class
public class l6p4_5386 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Time time = new Time();
        
        try {
            System.out.print("Enter hours: ");
            int hours = sc.nextInt();
            
            System.out.print("Enter minutes: ");
            int minutes = sc.nextInt();
            
            System.out.print("Enter seconds: ");
            int seconds = sc.nextInt();
            
            time.setTime(hours, minutes, seconds);
            time.displayTime();
        } catch (HrsException | MinException | SecException e) {
            System.out.println("Exception: " + e);
        } finally {
            sc.close();
        }
    }
}
