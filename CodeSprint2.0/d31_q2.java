import java.util.*;

public class d31_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=Integer.parseInt(sc.nextLine());
    String[] words=new String[n];
    for(int i=0;i<n;i++){
      words[i]=sc.nextLine();
    }List<String>seen =new ArrayList<>();
    for(int i=0;i<n;i++){
      int niceness=0;
      for(String prev:seen){
        if(prev.compareTo(words[i])<0){
          niceness++;
        }
      }
      System.out.println(niceness);
      seen.add(words[i]);
    }
  }
}