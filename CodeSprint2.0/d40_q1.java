import java.util.*;
public class d40_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    double x=sc.nextDouble();
    int n=sc.nextInt();
    System.out.print(power(x,n));
  }
  public static double power(double x,int n){
    if(n==0) return 1.0;
    if(n<0){
      x=1/x;
      n=-n;
    }
    double half=power(x,n/2);
    if(n%2==0){
      return half*half;
    }else{
      return half*half*x;
    }
  }
}