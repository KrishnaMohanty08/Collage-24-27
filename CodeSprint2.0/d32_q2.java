import java.util.*;

public class d32_q2{
  public static void main(String arg[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] nums=new int[n];
    for(int i=0;i<n;i++){
      nums[i]=sc.nextInt();
    }
    int target=sc.nextInt();
    System.out.println(insertAt(nums,target));
  }
  public static int insertAt(int[] nums,int target){
    int low=0,high=nums.length-1;
    while(low<=high){
      int mid=(low+high)/2;
      if(nums[mid]==target){
        return mid;
      }else if(nums[mid]<target){
        low=mid+1;
      }else{
        high=mid-1;
      }
    }return low;
  }
}