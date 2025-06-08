import java.util.*;

public class d24_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String in=sc.nextLine();
    StringBuilder res=new StringBuilder();
    int[] freq=new int[26];
    Queue<Character> q=new LinkedList<>();
    for(char ch:in.toCharArray()){
      freq[ch-'a']++;
      q.offer(ch);
      while(!q.isEmpty() && freq[q.peek()-'a']>1) q.poll();
      res.append(q.isEmpty()? '#':q.peek());
    }System.out.println(res);
  }
}