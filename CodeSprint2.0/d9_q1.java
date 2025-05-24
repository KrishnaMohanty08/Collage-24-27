import  java.util.*;

public class d9_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    String text=sc.next();
    String pattern =sc.next();
    ArrayList<Integer> list=new ArrayList<>();

    int i=text.toLowerCase().indexOf(pattern.toLowerCase());
    while(i!=-1){
      list.add(i);
      i=text.toLowerCase().indexOf(pattern.toLowerCase(),i+1);
    }
   System.out.println(list);
  }
}