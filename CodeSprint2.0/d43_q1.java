import java.util.*;
public class d43_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
      String[] line=sc.nextLine().trim().split("\\s+");
      for(String val:line) {
        if(!val.isEmpty()){
          adj.get(i).add(Integer.parseInt(val));
        }
      }
    }
    List<Integer> result=bfsTraverse(n,adj);
    System.out.print(result);
  }
  public static List<Integer> bfsTraverse(int n,List<List<Integer>> adj){
    boolean[] visited=new boolean[n];
    Queue<Integer> queue=new LinkedList<>();
    List<Integer>order=new ArrayList<>();
    queue.add(0);
    visited[0]=true;
    while(!queue.isEmpty()){
      int curr=queue.poll();
      order.add(curr);
      for(int neighbor:adj.get(curr)){
        if(!visited[neighbor]){
          visited[neighbor]=true;
          queue.add(neighbor);
        }
      }
    }
    return order;
  }
}