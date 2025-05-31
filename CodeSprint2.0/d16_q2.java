import java.util.*;
public class d16_q2{
  public static void main(String arsg[]){
    Scanner sc=new Scanner(System.in);

    LinkedList<Integer> list1=new LinkedList<>();
    LinkedList<Integer> list2=new LinkedList<>();
    while(true){
      String in=sc.next();
      if(in.equals("exit"))break;
      list1.add(Integer.parseInt(in));
    }
    while(true){
      String in =sc.next();
      if(in.equals("exit"))break;
      list2.add(Integer.parseInt(in));
    }
    LinkedList<Integer> list3=new LinkedList<>();
    int i=0,j=0;
    while(i<list1.size()&&j<list2.size()){
      if(list1.get(i)<=list2.get(j)){list3.add(list1.get(i));i++;}
      else{list3.add(list2.get(j));j++;}
    }
    while(i<list1.size()){list1.add(i);i++;}
    while(i<list2.size()){list2.add(j);j++;}
    System.out.print(list3);
  }
}