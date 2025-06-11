import java.util.*;

public class d27_q1{
  public static String[] findRank(int[] score){
    int n=score.length;
    String[] result= new String[n];
    int[][] iPairs=new int[n][2];
    for(int i=0;i<n;i++){
      iPairs[i][0]=score[i];
      iPairs[i][1]=i;
    }
    Arrays.sort(iPairs,(a,b)->b[0]-a[0]);
    for(int i=0;i<n;i++){
      int index=iPairs[i][1];
      if(i==0)result[index]="Gold Medal";
      else if(i==1)result[index]="Silver Medal";
      else if(i==2) result[index]="Broze Medal";
      else result[index]=String.valueOf(i+1);
    }return result;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] scores=new int[n];
    for(int i=0;i<n;i++){
      scores[i]=sc.nextInt();
    }
    System.out.println(Arrays.toString(findRank(scores)));
  }
}