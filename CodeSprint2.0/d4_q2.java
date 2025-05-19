// import java.util.*;

// public class d4_q2 {
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);

//         int days= sc.nextInt();
//         if(days>10)System.out.println("(motivation message..)");

//         int count=1;

//         for(int i=0;i<=days;i++){
//             if((i+1)%2==0){
//                 for(int j=1;j<=i;j++){
//                 System.out.print(j+" ");
//                 count++;
//             }
//             }else if(i%2==0){
//                 for(int j=i;j>=1;j--){
//                     System.out.print(j+" ");
//                     count++;
//                 }
//             }System.out.println();

//         }
//         System.out.println("Total number printed: "+count);
//     }
// }
import java.util.*;

public class d4_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    int days=sc.nextInt();
    if(days>10)System.out.println("{motivation message}");

    int count=0;
    for(int i=1;i<=days;i++){
      if((i+1)%2==0){
        for(int j=1;j<=i;j++){
          System.out.print(j+" ");
          count++;
        }
      }else if(i%2==0){
        for(int j=i;j>=1;j--){
          System.out.print(j+" ");
          count++;
        }
      }System.out.println();
    }System.out.println("Total number printed :"+count);
  }
}