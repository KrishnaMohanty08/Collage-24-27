import java.util.*;
public class d43_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    List<List<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
      adj.add(new ArrayList<>());
      String[] line=sc.nextLine().trim().split("\\s+");
      for(String val:line){
        if(!val.isEmpty()){
          adj.get(i).add(Integer.parseInt(val));
        }
      }
    }
    List<Integer> result =dfsTraversal(n,adj);
    System.out.println(result);
  }
  public static List<Integer> dfsTraversal(int n,List<List<Integer>> adj){
    boolean[] visited=new boolean[n];
    List<Integer> order=new ArrayList<>();
    dfs(0,adj,visited,order);
    return order;
  }
  private static void dfs(int node ,List<List<Integer>> adj,boolean[] visited,List<Integer> order){
    visited[node]=true;
    order.add(node);
    for(int neighbor:adj.get(node)){
      if(!visited[neighbor]){
        dfs(neighbor,adj,visited,order);
      }
    }
  }
}