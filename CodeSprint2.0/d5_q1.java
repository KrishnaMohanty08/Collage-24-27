import java.util.*;

public class d5_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    int n=sc.nextInt();
    int[][] classroom=new int[n][n];
    int total=0;

    if(n==1){ System.out.print(n);total++;}

    else{
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          if((i+j)%2==0){
            classroom[i][j]=1;
            total++;
          }else classroom[i][j]=0;
          System.out.print(classroom[i][j]+" ");
        }System.out.println();
      }
    }System.out.println("Total students seated "+total);
  }
}