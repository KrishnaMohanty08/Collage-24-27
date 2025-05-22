import java.util.*;

public class d7_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    int n=sc.nextInt();
    int[] stockPrices=new int[n];

    for(int i=0;i<n;i++){
      stockPrices[i]=sc.nextInt();
    }
    int minPrice=stockPrices[0];
    int maxProfit=0;
    for(int i=0;i<n;i++){
      int currProfit=stockPrices[i]-minPrice;
      
      maxProfit=Math.max(maxProfit,currProfit);
      minPrice=Math.min(minPrice,stockPrices[i]);
      System.out.println(maxProfit+" "+minPrice);
    }
    System.out.print(maxProfit);
    
  }
}