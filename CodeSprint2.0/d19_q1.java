import java.util.*;
public class d19_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    
    Stack<String> gifts=new Stack<>();
    Map<String,Integer> freq=new HashMap<>();
    int out=0;
    
    for(int i=0;i<n;i++){
      String in=sc.nextLine();
      String[] operation=in.split("\\s+");
      if(operation[0].equalsIgnoreCase("push")||operation[0].equalsIgnoreCase("pop")||operation[0].equalsIgnoreCase("count")){
        if(operation[0].equalsIgnoreCase("push")){
          String gift=operation[1];
          gifts.push(gift);
          freq.put(gift,freq.getOrDefault(gift,0)+1);
        }
        if(operation[0].equalsIgnoreCase("pop")){
          if(!gifts.isEmpty()){
            gifts.pop();
          }else System.out.println("empty");
        }
        if(operation[0].equalsIgnoreCase("count")){
          out=freq.get(gifts.peek());
          System.out.println(out);
        }
      }else{
        System.out.print("Invalid Input");
      }
    }
  }
}