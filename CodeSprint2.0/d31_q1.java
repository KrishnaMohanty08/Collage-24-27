import java.util.*;

public class d31_q1{
  public static int countBPairs(int[] cards){
    Set<String> seen=new HashSet<>();
    int count=0;
    for(int i=0;i<cards.length;i++){
      for(int j=0;j<cards.length;j++){
        if(i!=j && cards[i]>cards[j]){
          String pair=cards[i]+","+cards[j];
          if(!seen.contains(pair)){
            seen.add(pair);
            count++;
          }
        }
      }
    }return count;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] cards=new int[n];
    for(int i=0;i<n;i++){
      cards[i]=sc.nextInt();
    }
    System.out.println(countBPairs(cards));
  }
}