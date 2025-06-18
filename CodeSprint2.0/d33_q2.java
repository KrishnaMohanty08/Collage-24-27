import java.util.*;

public class d33_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String s=sc.next();
    int count=0,op=0;
    for(char ch:s.toCharArray()){

      if(ch=='1'){
        count++;
      }else{
        if(count>0){
          op++;
          count--;
        }
      }
    }
    System.out.println(op);
  }
}