import java.util.*;

public class d36_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int r=sc.nextInt();
    System.out.print(NcR(n,r));
  }
  public static long fact(int n){
    long fact=1;
    for(int i=2;i<=n;i++){
      fact*=i;
    }return fact;
  }
  public static long NcR(int n,int r){
    if(r>n)return 0;
    return fact(n)/(fact(r)*fact(n-r));
  }
}