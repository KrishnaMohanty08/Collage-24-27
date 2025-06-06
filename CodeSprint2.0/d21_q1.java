import java.util.*;
public class d21_q1{
  public static void main(String arga[]){
    Scanner sc=new Scanner(System.in);
    ArrayList<Integer> tickets=new ArrayList<>();
    while(true){
      String in=sc.nextLine();
      if(in.equals("exit"))break;
      tickets.add(Integer.parseInt(in));
    }
    int k=sc.nextInt();
    int t=0;
    for(int i=0;i<tickets.size();i++){
      if(i<=k){
        t+=Math.min(tickets.get(i),tickets.get(k));
      }else{
        t+=Math.min(tickets.get(i),tickets.get(k));
      }
    }System.out.print(t);
  }
}