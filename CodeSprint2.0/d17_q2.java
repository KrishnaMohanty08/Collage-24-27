import java.util.*;

public class d17_q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while(true){
            String in = sc.nextLine();
            if (in.equals("exit"))break;
            char chars[] =in.toCharArray();
            for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String a = stack.pop();
                String b = stack.pop();
                String result = c + b + a;
                stack.push(result);
            }
        }
    }System.out.println(stack.pop());
    }
}