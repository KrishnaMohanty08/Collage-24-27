import java.util.*;
public class d35_q2{
public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int[] packets=new int[n];
  for(int i=0;i<n;i++){
    packets[i]=sc.nextInt();
  }
  System.out.println(minPackets(packets));
}
  public static int minPackets(int[] packets){
    Arrays.sort(packets);
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    for(int high:packets){
      if(!pq.isEmpty() && pq.peek()<=high){
        pq.poll();
      }
      pq.offer(high);
    }
    return pq.size();
  }
}