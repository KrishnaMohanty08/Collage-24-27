import java.util.*;
public class d19_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Stack<Integer> readings=new Stack<>();
    int mini=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      String in=sc.nextLine();
      String[] operation=in.split("\\s+");
      if(operation[0].equalsIgnoreCase("push")||operation[0].equalsIgnoreCase("pop")||operation[0].equalsIgnoreCase("min")){
        if(operation[0].equalsIgnoreCase("push")){
          int temp=Integer.parseInt(operation[1]);
          readings.push(temp);
          mini=Math.min(mini,temp);
        }
        if(operation[0].equalsIgnoreCase("pop")){
          if(!readings.isEmpty()){
            int removed = readings.pop();
        if (removed == mini) {
            mini = readings.isEmpty() ? Integer.MAX_VALUE :
            Collections.min(readings);
        }
    } else System.out.println("empty");
        }
        if(operation[0].equalsIgnoreCase("min")){
          System.out.println(mini);
        }
      }else{
        System.out.println("Invalid Input");
      }
    }
  }
}