import java.util.*;
public class d18_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    String[] arr=str.trim().split("\\s+");
    Stack<Integer> s=new Stack<>();
    for(String t:arr){
      if("+-*/".contains(t)){
        int b=s.pop(),a=s.pop();
        s.push(t.equals("+")?a+b:t.equals("-")?a-b:t.equals("*")?a*b:a/b);
      }else {
        s.push(Integer.parseInt(t));
      }
    }System.out.print(s.pop());
  }
}