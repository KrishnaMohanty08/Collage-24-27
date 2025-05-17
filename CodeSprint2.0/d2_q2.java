import java.util.*;

public class d2_q2{
  public static void main(String args[]){
  Scanner sc=new Scanner(System.in);
  
  System.out.println("Enter the number of hours: ");
  int totalHrs= sc.nextInt();

  System.out.println("Enter the number of vehicle each hour");
  int[] vehi=new int[totalHrs];
  for(int i=0;i<totalHrs;i++){
    vehi[i]=sc.nextInt();
  }
  
  System.out.println("Critical jam hours "+criticalHrs(vehi));
  }
  
  static int criticalHrs(int[] vehicle){
    
    int countCriticalHrs=0;
    for(int i=1;i<vehicle.length;i++){
      if(vehicle[i]>=50 && vehicle[i]<vehicle[i-1]){
        countCriticalHrs++;
        System.out.println(i);
      }
    }return countCriticalHrs;
  }
}