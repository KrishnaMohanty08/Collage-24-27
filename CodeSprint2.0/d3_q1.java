// import java.util.*;

// public class d3_q1{
//   public static void main(String args[]){
//     Scanner sc=new Scanner(System.in);

//     System.out.println("Enter the no. of days:");
//     int n=sc.nextInt();
//     System.out.println("Enter the temprature readings");
//     int temp[]=new int[n];
//     for(int i=0;i<n;i++){
//       temp[i]=sc.nextInt();
//     }

//     int len=1;
//     int maxLen=1;
//     for(int i =1;i<n;i++){
//         if(temp[i]>temp[i-1]){
//             len++;
//             maxLen=Math.max(maxLen, len);
//         }else len=1;
//         System.out.println("what why:"+temp[i]+" "+maxLen+" "+len);
        
//     }System.out.println(maxLen);
//   }
  
// }
import java.util.*;

public class d3_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the no. of days:");
    int n=sc.nextInt();
    System.out.println("Enter the temprature readings");
    int temp[]=new int[n];
    for(int i=0;i<n;i++){
      temp[i]=sc.nextInt();
    }

    int len=1;
    int maxLen=1;
    for(int i=1;i<n;i++){
      if(temp[i]>temp[i-1]){
        len++;
        maxLen=Math.max(maxLen,len);
      }else len=1;
    }
    System.out.print("longest length: "+maxLen);
  }
}