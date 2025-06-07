import java.util.*;

public class d23_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    Queue<Integer> r=new LinkedList<>();
    Queue<Integer> d=new LinkedList<>();
    int n=s.length();

    for(int i=0;i<n;i++){
      if(s.charAt(i)=='R') r.add(i);
      else d.add(i);
    }while(!r.isEmpty() && !d.isEmpty()){
      int ri=r.poll(),di=d.poll();
      if(ri<di)r.add(ri+n);
      else d.add(di+n);
    }
    System.out.println(r.isEmpty()?"Dire":"Radiant");
  }
}