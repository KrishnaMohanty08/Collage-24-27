import java.util.*;

public class diagonalSum_5386{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int[][] matrix_5386 =new int[3][3];

        //Enter the elements in the matrix
        System.out.println("Enter 9 numbers into the matrix:");
        for(int row=0;row<3;row++){
            for(int col =0;col<3;col++){
                matrix_5386[row][col]=sc.nextInt();
            }
        }

        int left=0;
        int right=0;
        //the sum of diagonal
        for(int row=0;row<3;row++){
            for(int col =0;col<3;col++){
                if(row==col){
                   left=left+matrix_5386[row][col]; 
                }
                else if(row+col==2){
                    right+=matrix_5386[row][col];
                }
            }
        }

        System.out.println("left :"+left);
        System.out.println("left :"+right);

    }
}