import java.util.*;
public class d45_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] nums=new int[n];
    for(int i=0;i<n;i++){
      nums[i]= sc.nextInt();
    }
    int[] result=prod(nums);
    for(int val:result){
      System.out.print(val+" ");
    }
  }
  public static int[]prod(int[] nums){
    int n=nums.length;
    int[] result=new int[n];
    int[] left=new int[n];
    int[] right=new int[n];
    left[0] =1;
    for(int i=1;i<n;i++){
      left[i]=left[i-1]*nums[i-1];
    }
    right[n-1]=1;
    for(int i=n-2;i>=0;i--){
      right[i]=right[i+1]*nums[i+1];
    }
    for(int i=0;i<n;i++){
      result[i]=left[i]*right[i];
    }
     return result;
  }
}