import java.util.*;

class l6p1_5386 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int arraySize = 4;
        int[] numbers = new int[arraySize];

        System.out.println("Enter " + arraySize + " numbers:");

        for (int i = 0; i < arraySize; i++) {
            numbers[i] =in.nextInt();
        } try {
            System.out.println("Accessing element at index 4: " + numbers[4]);
        }catch (ArrayIndexOutOfBoundsException e){
          System.out.println("Exception caught: " + e);
        }
    }
}
