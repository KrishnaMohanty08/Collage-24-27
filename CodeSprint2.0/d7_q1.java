import java.util.*;

public class d7_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    
    String security=new String();
    security=sc.next();
    int count=0;

    for(int i=0;i<security.length();i++){
      if (security.charAt(i) == '1') {
                if (i==0|| security.charAt(i-1)=='0') {
                    count++;
                }
            }
    }System.out.println(count);
    
  }
}