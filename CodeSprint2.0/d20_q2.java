import java.util.*;
public class d20_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ngeIndex = new int[n];
        Arrays.fill(ngeIndex, -1);
        Stack<Integer> s1 = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!s1.isEmpty() && arr[i] > arr[s1.peek()]) {
                ngeIndex[s1.pop()] = i;
            }s1.push(i);
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for(int i = 0; i < n; i++) {
            int ngePos = ngeIndex[i];
            if(ngePos == -1) {
                result[i] = -1;
            } else {
                for(int j = ngePos + 1; j < n; j++) {
                    if(arr[j] < arr[ngePos]) {
                        result[i] = arr[j];break;
                    }}}
        }for(int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }}
}
