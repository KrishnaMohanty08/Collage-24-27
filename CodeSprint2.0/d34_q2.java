import java.util.*;
public class d34_q2{
  public static int findr(int[] houses,int[] heaters){
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int r=0;
    for(int house:houses){
      int idx=Arrays.binarySearch(heaters,house);
      if(idx<0){
        idx= -idx-1;
      }int dist1=idx<heaters.length?Math.abs(heaters[idx]-house):Integer.MAX_VALUE;
      int dist2=idx>0?Math.abs(heaters[idx-1]-house):Integer.MAX_VALUE;
      r=Math.max(r,Math.min(dist1,dist2));
    }
    return r;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int h=sc.nextInt();
    int[] houses=new int[h];
    for(int i=0;i<h;i++){
      houses[i]=sc.nextInt();
    };
    int he=sc.nextInt();
    int[] heaters=new int[he];
    for(int i=0;i<he;i++){
      heaters[i]=sc.nextInt();
    }
    System.out.println(findr(houses,heaters));
  }
}