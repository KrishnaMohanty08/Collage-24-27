import java.util.*;
public class d27_q2{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] codes=new int[n];
    int[] count=new int[n+1];
    
    for(int i=0;i<n;i++){
      codes[i]=sc.nextInt();
      count[codes[i]]++;
    }
    int duplicate=-1,missing =-1;

    for(int i=1;i<=n;i++){
      if(count[i]==2)duplicate=i;
      else if(count[i]==0)missing=i;
    }
    System.out.println(duplicate+" "+missing);
  }
}
