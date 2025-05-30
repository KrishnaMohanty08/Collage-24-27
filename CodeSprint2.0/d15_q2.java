import java.util.*;

public class d15_q2{
  public static void main(String arg[]){
    Scanner sc=new Scanner(System.in);
    LinkedList<Integer> l1=new LinkedList<>();
    LinkedList<Integer> l2=new LinkedList<>();
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      l1.add(Integer.parseInt(in));
    }
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      l2.add(Integer.parseInt(in));
    }
    Collections.reverse(l1);
    Collections.reverse(l2);
    LinkedList<Integer> l3=new LinkedList<>();

    int carry=0;
    int max=Math.max(l1.size() ,l2.size());
    for(int i=0;i<max;i++){
        int d1 = (i < l1.size()) ? l1.get(i) : 0;
        int d2 = (i < l2.size()) ? l2.get(i) : 0;
        int sum = d1 + d2 + carry;
        carry = sum / 10;
        l3.add(sum % 10);
        }
        if (carry > 0) {
            l3.add(carry);
        }
    System.out.println(l3);
  }
}