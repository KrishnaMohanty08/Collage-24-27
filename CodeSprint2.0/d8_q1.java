import java.util.*;

public class d8_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    int target=sc.nextInt();
    int n=sc.nextInt();
    int[] sessions=new int[n];
    for(int i=0;i<n;i++){
      sessions[i]=sc.nextInt();
    }

    minSum(sessions,target);
  }
  static void minSum(int[]arr,int target){
    int n=arr.length;
    int minLen=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      int sum=0;
      for(int j=i;j<n;j++){
        sum+=arr[j];
        if(sum== target){
          int len=j-i+1;
          minLen=Math.min(minLen,len);

        }
      }
    }System.out.println(minLen);
  }
}