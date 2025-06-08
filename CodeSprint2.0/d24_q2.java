import java.util.*;

public class d24_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] queue = new int[n];
        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(queue[i] + " ");
        }
    }
}
