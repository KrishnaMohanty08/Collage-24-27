
import java.util.*;
public class patt1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
/* 
    1
   212
  32123
 4321234
543212345


        for(int i=1;i<=5;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
*/
/*
1
3 2
6 5 4
10 9 8 7
 
        for(int i=0;i<n;i++){
            int count=(i*(2+1)/2);
            for(int j=0;j<i;j++){
                System.out.print(count--);
            }
            System.out.println();
        }
    */
/*
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((j%2)==0)System.out.print("0 ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
*/
/*
1   2   3   4
8   7   6   5
9  10  11  12
16 15  14  13
 
        int count=1,start=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                start=count+3;
                for(int j=start;j>=count;j--){
                    System.out.print(j+" ");
                }
                count+=4;
            }else{
                for(int j=1;j<n;j++){
                    System.out.print(count++ +" ");
                }
            }
            System.out.println();
        }
    */
/*
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
*/
            for(int i=1;i<n;i++){
                for(int j=n-i;j>i;j--){
                    System.out.print(" ");
                }
                for(int j=1;j<i;j++){
                    System.out.print(j+" ");
                }
                for(int j=i;j>=1;j--){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
    }
}