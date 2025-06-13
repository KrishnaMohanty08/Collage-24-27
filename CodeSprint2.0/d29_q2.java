import java.util.*;
public class d29_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] nums=new int[n];
    for(int i=0;i<n;i++){nums[i]=sc.nextInt();}
    int[] result =sortedSquares(nums);
    for(int num:result){System.out.print(num+" ");}
  }
  public static int[] sortedSquares(int[] nums){
    int n=nums.length;
    int[] result=new int[n];
    int left=0,right=n-1,i=n-1;
    while(left<=right){
      int leftSq=nums[left]*nums[left];
      int rightSq=nums[right]*nums[right];
      if(leftSq>rightSq){
        result[i--]=leftSq;left++;
      }else {
        result[i--]=rightSq;right--;
      }
    }
    return result;
  }
}