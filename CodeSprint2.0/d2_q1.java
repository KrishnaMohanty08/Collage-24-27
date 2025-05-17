import java.util.*;

public class d2_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the number of Ritik's score:");
    int n=sc.nextInt();

    System.out.println("Enter the scores :");
    int[] scores=new int[n];
    for(int i=0;i<n;i++){
      scores[i]=sc.nextInt();
    }

    int magical=0;
    for(int i=1;i<n-1;i++){
      if(scores[i]>scores[i-1] && scores[i]>scores[i+1])
        magical++;
        
    }
    System.out.print("magical days:"+magical);
  }
}