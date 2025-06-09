import java.util.*;
public class d25_q1{
  public static boolean triplet(int[] arr,int target){
    Arrays.sort(arr);
    int n=arr.length;
    for(int i=0;i<n-2;i++){
      int left=i+1;
      int right=n-1;
      while(left<right){
        int sum=arr[i]+arr[left]+arr[right];
        if(sum==target)return true;
        else if(sum<target) left++;
        else right--;
      }
    }
    return false;
  }
    public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int[] arr=new int[n];
      for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
      }
      int target=sc.nextInt();
      System.out.println(triplet(arr,target));
  }
}
