import java.util.*;

public class d28_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
    }
    int power=sc.nextInt();
    System.out.println(tokenScore(arr,power));
  }
  public static int tokenScore(int[] tokens,int power){
    Arrays.sort(tokens);
    int score =0,max=0,i=0,j=tokens.length-1;
    while(i<=j){
      if(power>=tokens[i]){
        power-=tokens[i++];
        score++;
        max = Math.max(max, score);
     }else if(score >0){
        power+=tokens[j--];
        score--;
     }else break;
    }return max;
    }
}