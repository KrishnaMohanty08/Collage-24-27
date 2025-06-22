import java.util.*;
public class d38_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    System.out.println(getSymbol(n,k));
  }
  public static int getSymbol(int n,int k){
    int count=Integer.bitCount(k-1);
    return count%2;
  }
}