import java.util.*;
public class d23_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    String[] in=sc.nextLine().split(" ");
    int n=in.length;
    int[] a=new int[n];
    for(int i=0;i<n;i++) a[i]=Integer.parseInt(in[i]);
    int k=sc.nextInt();
    int[] dp=new int[n];
    dp[0]=a[0];
    for(int i=1;i<n;i++){
      int max=Integer.MIN_VALUE;
      for(int j=Math.max(0,i-k);j<i;j++) max=Math.max(max,dp[j]);
      dp[i]=max+a[i];
    }
    System.out.println(dp[n-1]);
  }
}