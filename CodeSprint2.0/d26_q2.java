import java.util.*;
public class d26_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt(),power[]=new int[n];
    for(int i=0;i<n;i++) power[i]=sc.nextInt();
    int wrapE=sc.nextInt(),closestTripletE=power[0]+power[1]+power[2],
    minDiff=Math.abs(wrapE-closestTripletE);
    Arrays.sort(power);
    for(int i=0;i< n-2;i++)
      for(int j=i+1,k=n-1;j<k;){
        int sum=power[i]+power[j]+power[k],diff=Math.abs(wrapE-sum);
        if(diff<minDiff||(diff==minDiff && sum>closestTripletE)){
          closestTripletE=sum;
          minDiff=diff;
        }
        if(sum<wrapE)j++;
        else k--;
      }System.out.println(closestTripletE);
    }
  }
    