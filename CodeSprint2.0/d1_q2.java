import java.util.*;

public class d1_q2{
  public static void main (String args[]){
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter the number of shots :");
    int n=sc.nextInt();
    
    System.out.println("Enter the shots: ");
    int[] scores =new int[n];
    for(int i=0;i<n;i++){
      scores[i]=sc.nextInt();
    }

    int badShots=0;
    int goodShots=0;
    for(int i=0;i<n;i++){
      if(scores[i]>=7)goodShots++;
      else badShots++;
    }
    System.out.print(goodShots+" "+badShots);
  }
}