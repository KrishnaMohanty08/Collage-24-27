import java.util.*;

public class d39_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(countGood(n,0));
  }
  public static int countGood(int n ,int i){
    if(i==n)return 1;
    int choices=(i%2==0)?5:4;
    return choices*countGood(n,i+1);
  }
  
}