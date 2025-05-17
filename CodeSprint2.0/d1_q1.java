import java.util.*;

public class d1_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner (System.in);
    System.out.println("Enter the number if prices: ");int n=sc.nextInt();
    int[] iceCreamPrices=new int[n];
    System.out.println("Enter Shivam's budget: ");int budget=sc.nextInt();

    System.out.println("Enter the prices: ");
    for(int i=0;i<n;i++){
      iceCreamPrices[i]=sc.nextInt();
    }
    Arrays.sort(iceCreamPrices);

    boolean canBuy=false;

    int output=binarySearch(iceCreamPrices,budget);
    if(output!=-1)canBuy=true;
    System.out.println("Output: "+canBuy);
  }
  static int binarySearch(int[]arr,int b){
    int low=0;int high=arr.length-1;
    while(low<=high){
      int mid=(low+high)/2;
      if(arr[mid]<b){
        low=mid+1;
      }else if (arr[mid]>b){
        high=mid-1;
      }else{
        return mid;
      }
    }return -1;
  }
}