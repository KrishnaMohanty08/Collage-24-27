import java.util.*;

public class d6_q1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String jewels = new String();
        jewels = sc.next();
        String stones = new String();
        stones = sc.next();

        Set<Character> jewelSet = new HashSet<>();
        for (char ch : jewels.toCharArray())
            jewelSet.add(ch);

        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewelSet.contains(ch))
                count++;
        }
        System.out.println("total no of jewels :" + count);
    }
}