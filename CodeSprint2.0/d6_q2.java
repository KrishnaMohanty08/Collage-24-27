import java.util.*;

public class d6_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    System.out.print("Enter the number of paitents :");
    int numP=sc.nextInt();
    String[] names=new String[numP];
    for(int i=0;i<numP;i++){
      names[i]=sc.next();
    }

    int count=0;
    
    List<String> c1=new ArrayList<>();
    Set<String> c2=new HashSet<>();
    
    for(String s:names){
      if((s.startsWith("a")||s.startsWith("e")||s.startsWith("i")||s.startsWith("o")||s.startsWith("u")) && !c1.contains(s)){
        count++;
        c1.add(s);
        c2.add(s);
        System.out.print(s+" ");
      }
    }System.out.print(count);
    
    
  }
}