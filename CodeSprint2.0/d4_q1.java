import java.util.*;

// public class d4_q1{
//   public static void main(String args[]){
//     Scanner sc=new Scanner(System.in);

//     System.out.println("Enter n:");
//     int n=sc.nextInt();

//     if((n+1)%2==0){
//       String[][] matrix =new String[n+1][n+1];

//       for(int i=1;i<=n;i++){
//         if(i-1<n/2){
//             for(int j=1;j<=n;j++){
//             if(i==j)matrix[i][j]=String.valueOf(j);
//             else if(i+j==n+1)matrix[i][j]=String.valueOf(j);
//             else matrix[i][j]="-";
//             System.out.print(matrix[i][j]+" ");
//             }
//         }
//         else{
//             for(int j=n;j>=1;j--){
//             if(i==j)matrix[i][j]=String.valueOf(j);
//             else if(i+j==n+1)matrix[i][j]=String.valueOf(j);
//             else matrix[i][j]="-";
//             System.out.print(matrix[i][j]+" ");
//             }
//         }System.out.println();
//       }

//     }else System.out.print("enter a odd number");
// }   
// }


public class d4_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    if((n+1)%2==0){
      String[][] matrix =new String[n+1][n+1];

      for(int i=1;i<=n;i++){
        if(i-1<n/2){
          for(int j=1;j<=n;j++){
            if(i==j)matrix[i][j]=String.valueOf(j);
            else if(i+j==n+1)matrix[i][j]=String.valueOf(j);
            else matrix[i][j]="-";
            System.out.print(matrix[i][j]+" ");
          }
        }else{
          for(int j=n;j>=1;j--){
            if(i==j)matrix[i][j]=String.valueOf(j);
            else if(i+j==n+1)matrix[i][j]=String.valueOf(j);
            else matrix[i][j]="-";
            System.out.print(matrix[i][j]+" ");
          }
        }System.out.println();
      }
      
    }else System.out.print("enter a odd number");

  }
}