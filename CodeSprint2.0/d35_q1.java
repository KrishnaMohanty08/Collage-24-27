import java.util.*;
public class d35_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n =sc.nextInt();
    int groups=sc.nextInt();
    int[] parcels=new int[n];
    for(int i=0;i<n;i++){
      parcels[i]=sc.nextInt();
    }
    System.out.println(divideMin(groups,parcels,n));
  }
  public static int divideMin(int group,int[]parcels,int n){
    int low=Arrays.stream(parcels).max().getAsInt();
    int high=Arrays.stream(parcels).sum();
    int ans=high;

    while(low<=high){
      int mid=(low+high)/2;
      if(canDivide(parcels,group,mid)){
        ans=mid;
        high=mid-1;
      }else{
        low=mid+1;
      }
    }return ans;
  }
  public static boolean canDivide(int[] parcels,int k,int maxSum){
    int count=1;
    int currSum=0;
    for(int wt:parcels){
      if(currSum+wt>maxSum){
        count++;
        currSum=wt;
        if(count>k) return false;
      }else currSum+=wt;
    }
    return true;
  }
}