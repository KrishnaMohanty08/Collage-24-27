import java.util.*;

public class d3_q3{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    
    System.out.println("Enter the rows");
    int r=sc.nextInt();
    System.out.println("Enter the cols");
    int c=sc.nextInt();

    int[][] stock=new int[r][c];
    for(int i=0;i<r;i++){
      System.out.println("Enter the product types");
      for(int j=0;j<c;j++){
        stock[i][j] =  sc.nextInt();
      }
    }
    System.out.print("The overStocked warehouses: "+isOverStocked(stock,r,c));
  }
  static int isOverStocked(int[][]matrix,int r,int c){
    int overStocked=0;
    for(int i=0;i<r;i++){
      int overHund=0;
      for(int j=0;j<c;j++){
        if(matrix[i][j]>=100)overHund++;
      }if(overHund>=3)overStocked++;
    }
    return overStocked;
  }
}