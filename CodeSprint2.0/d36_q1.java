import java.util.*;
public class d36_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    double sum=1;
    if(n==0)System.out.println("1");
    else{
        for(int i=1;i<n;i++){
      double term = Math.pow(1.0 / 3, i);
      sum+=term;
    }
    System.out.println("sum "+sum);
}
  }
}