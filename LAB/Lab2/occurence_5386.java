import java.util.*;

public class occurence_5386{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt(); 

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt(); 
        }

        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i]; 
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1); 
        }

        System.out.println("The number of their occurrences are:");
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        sc.close(); 
    }

}