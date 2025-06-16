import java.util.*;

public class d32_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    int allSum=n*(n+1)/2;
    int sum=0;
    for(int i=0;i<n;i++){
      arr[i] =sc.nextInt();
      sum+=arr[i];
    }
    System.out.print(allSum-sum);
  }
}