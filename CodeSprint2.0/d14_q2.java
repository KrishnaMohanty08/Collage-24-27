import java.util.*;

public class d14_q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> ll1 = new LinkedList<>();
        while (true) {
            String in = sc.next();
            if (in.equals("exit"))break;
            ll1.add(in);
        }
        int i = 0;
        String input = new String();
        while (i < ll1.size()) {
            input = input.concat(ll1.get(i));
            i++;
        }
        String output = String.valueOf(2 * Integer.parseInt(input));
        LinkedList<Character> result = new LinkedList<>();
        for (int j = 0; j < output.length(); j++) {
            result.add(output.charAt(j));
        }
        for (char value : result) {
            System.out.print(value+ " ");
        }
    }
}